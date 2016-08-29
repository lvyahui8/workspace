import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings({ "static-access", "serial" })
public class Yard extends Frame {
	public static final int ROWS = 40;
	public static final int COLS = 50;
	public static final int BLOCK_SIZE = 10;
	private static final int WIDTH = COLS * BLOCK_SIZE;
	private static final int HEIGHT = ROWS * BLOCK_SIZE;
	

	private Snake snake = new Snake();
	private Egg egg = new Egg();
	Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if (null == offScreenImage) {
			offScreenImage = this.createImage(WIDTH, HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
//	
	public void launch(){
		this.setLocation(300, 300);
		this.setSize(WIDTH, HEIGHT);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO 自动生成的方法存根
				System.exit(0);
			}
		});
		this.addKeyListener(new KeyMonitor());
		this.setVisible(true);
		new Thread(new Paint()).start();
	}
	
	@Override
	public void paint(Graphics g) {
		Color oldC = g.getColor();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0,this.COLS * this.BLOCK_SIZE , this.ROWS * this.BLOCK_SIZE);
		g.setColor(Color.DARK_GRAY);
		for(int i=1;i<this.ROWS-1;i++){
			g.drawLine(0, this.BLOCK_SIZE * i, this.WIDTH, this.BLOCK_SIZE * i);
		}
		for(int i=1;i<this.COLS-1;i++){
			g.drawLine( this.BLOCK_SIZE * i,0, this.BLOCK_SIZE * i,this.HEIGHT );
		}
		g.setColor(oldC);
		this.snake.draw(g);
		egg.draw(g);
		snake.eat(egg);
	}

	private class Paint implements Runnable{
		public void run(){
			while(true){
				try {
					Thread.sleep(60);
//					snake.move();
					repaint();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
	
	public class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			snake.key(e);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new Yard().launch();
	}
}
