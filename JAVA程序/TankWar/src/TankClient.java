import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
/**
 * 这个类时坦克的主窗口
 * @author Agrin
 */
public class TankClient extends Frame {
	private static final long serialVersionUID = 4946343426190831373L;
	public static final int TANK_COUNT = 10;
	// 坦克
	Tank tank = Tank.getGoodTank();
	List<Missile> missiles = new ArrayList<Missile>();
	List<Tank> tanks = new ArrayList<Tank>();
	List<Explode> explodes = new ArrayList<Explode>();
	public static final int BACK_WIDTH = 800;// 背景宽度
	public static final int BACK_HEIGHT = 600;// 背景高度
	private static final long SLEEP_TIME = 40;// 线程休眠时间
	
	Wall w1 = new Wall(300,200,20,150,this);
	Wall w2 = new Wall(300,100,300,20,this);
	
	Image offScreenImage = null;

	/**
	 * @param g 
	 */
	@Override
	public void update(Graphics g) {
		if (null == offScreenImage) {
			offScreenImage = this.createImage(BACK_WIDTH, BACK_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color oldColor = gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);
		gOffScreen.fillRect(0, 0, BACK_WIDTH, BACK_HEIGHT);
		gOffScreen.setColor(oldColor);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	public void lauchFrame() {
		for(int i = 0; i < this.TANK_COUNT;i++){
			tanks.add(new Tank(50+40*(i+1),50,false,this,Tank.Direction.D));
		}
		tanks.add(tank);
		this.setBounds(60, 50, BACK_WIDTH, BACK_HEIGHT);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.addKeyListener(new KeyMonitor());
		this.setBackground(Color.GREEN);
		this.setResizable(false); // 不能改变大小
		this.setVisible(true);

		new Thread(new PaintThread()).start();
	}

	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		g.drawString("missile count:" + this.missiles.size(), 10, 50);
//		tank.draw(g);

		// for (Missile mis : this.missiles) {
		// mis.draw(g);
		// }
		
		for (int i = 0; i < this.missiles.size(); i++) {
			Missile mis = this.missiles.get(i);
			// if(!mis.hitTank(enemyTank)){
			mis.hisTanks(tanks);
			mis.hitWall(w1);
			mis.hitWall(w2);
			mis.draw(g);
			// }
		}
		for(int i = 0 ;i<tanks.size();i++){
			Tank t = tanks.get(i);
			t.collidesWithWall(w1);
			t.collidesWithWall(w2);
			t.collidesWithTanks(tanks);
			t.draw(g);
		}
		for(int i=0;i<explodes.size();i++){
			Explode e  = explodes.get(i);
			e.draw(g);
		}
		w1.draw(g);
		w2.draw(g);
	}

	public TankClient(String string) {
		// TODO 自动生成的构造函数存根
		super(string);
	}
	/**
	 * 内部类，重画线程
	 * @author Agrin
	 *
	 */
	private class PaintThread implements Runnable {
		@Override
		public void run() {
			// TODO 自动生成的方法存根
			while (true) {
				try {
					Thread.sleep(SLEEP_TIME);
					repaint();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	private class KeyMonitor extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自动生成的方法存根
			tank.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			tank.keyPressed(e);
		}

	}

	public static void main(String[] args) {
		TankClient tc = new TankClient("TankWar");
		tc.lauchFrame();
	}
}
