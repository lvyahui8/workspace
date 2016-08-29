package cn.agrin;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 
 * @author Agrin
 *	十字路口交通灯演示客户端
 */
@SuppressWarnings("serial")
public class DemoClient extends Frame{
	private BufferedImage bgImage;
	public static final int WINDOW_WIDTH = 700;
	public static final int WINDOW_HEIGHT = 700;
	
	Road [] roads = {
			new Road(),
			new Road(
					new Point((WINDOW_WIDTH+Road.WIDTH)>>1,WINDOW_HEIGHT), 
					new Point((WINDOW_WIDTH+Road.WIDTH)>>1,(WINDOW_HEIGHT/3)<<1),
					1
					),
			new Road(
					new Point(WINDOW_WIDTH,(WINDOW_HEIGHT-Road.WIDTH)>>1),
					new Point((WINDOW_WIDTH/3)<<1,(WINDOW_HEIGHT-Road.WIDTH)>>1),
					2
					),
			new Road(
					new Point((WINDOW_WIDTH-Road.WIDTH)>>1,0),
					new Point((WINDOW_WIDTH-Road.WIDTH)>>1,WINDOW_HEIGHT/3),
					3
					),
			new Road(
					new Point(0,(WINDOW_HEIGHT+Road.WIDTH)>>1),
					new Point(WINDOW_WIDTH/3,(WINDOW_HEIGHT+Road.WIDTH)>>1),
					4
					)
			};
	
	public Road[] getRoads() {
		return roads;
	}

	Image offScreenImage = null;
	

	@Override
	public void update(Graphics g) {
		if (null == offScreenImage) {
			offScreenImage = this.createImage(WINDOW_WIDTH, WINDOW_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color oldColor = gOffScreen.getColor();
		gOffScreen.setColor(Color.WHITE);
		gOffScreen.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		gOffScreen.setColor(oldColor);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	public DemoClient(){
		Direction dirs [] = Direction.values();
		for(int i = 0;i<dirs.length;i++)
			System.out.print(dirs[i]+",");
		System.out.println("");
		this.init();
		this.launch();
		new Thread(new Repaint()).start();
	}
	private void init(){

	}
	
	private void launch(){
		this.setBounds(200, 10, WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setTitle("十字路口运行演示");
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
//		Label lable = new Label("F:/图库/美化图片/23.jpg");
//		this.add(lable);
		try {
			bgImage = ImageIO.read(new File("img/background.bmp"));
			
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
//		Color oldColor = g.getColor();
//		g.setColor(Color.BLUE);
		
		g.drawImage(bgImage, 0, 0, this.getWidth(), this.getHeight(), this);
		
//		g.fill3DRect(0, 0, Road.CENTER_X-Road.WIDTH, Road.CENTER_Y-Road.WIDTH, true);
//		g.fill3DRect(Road.CENTER_X+Road.WIDTH, 0, Road.CENTER_X-Road.WIDTH, Road.CENTER_Y-Road.WIDTH, true);
//		g.fill3DRect(0, Road.CENTER_Y+Road.WIDTH, Road.CENTER_X-Road.WIDTH, Road.CENTER_Y-Road.WIDTH, true);
//		g.fill3DRect(Road.CENTER_X+Road.WIDTH, Road.CENTER_Y+Road.WIDTH, Road.CENTER_X-Road.WIDTH, Road.CENTER_Y-Road.WIDTH, true);
//		g.drawOval(Road.CENTER_X, Road.CENTER_Y, 10, 10);
//		g.drawLine(0, WINDOW_HEIGHT>>1,WINDOW_WIDTH/3, WINDOW_HEIGHT>>1);
//		g.drawLine((WINDOW_WIDTH/3)<<1, WINDOW_HEIGHT>>1,WINDOW_WIDTH, WINDOW_HEIGHT>>1);
//		g.drawLine(WINDOW_WIDTH>>1, 0,WINDOW_WIDTH>>1, WINDOW_HEIGHT/3);
//		g.drawLine(WINDOW_WIDTH>>1, (WINDOW_HEIGHT/3)<<1,WINDOW_WIDTH>>1, WINDOW_HEIGHT);
//g.drawRect(centerR.x, centerR.y, centerR.width, centerR.height);
//		g.setColor(oldColor);
		for (int i = 1; i < roads.length; i++) {
			roads[i].draw(g);
		}
	}

	class Repaint implements Runnable{

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			while(true){
				try {
					Thread.sleep(60);
					repaint();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
	static DemoClient dc = null;
	
	public static DemoClient getInstance(){
		return dc;
	}
	
	public static void main(String[] args) {
		dc = new DemoClient();
	}

	private  static Rectangle centerR = new Rectangle(Road.CENTER_X-Road.WIDTH, Road.CENTER_Y-Road.WIDTH,
			(Road.WIDTH<<1), (Road.WIDTH<<1));
//	private  static Rectangle centerR = new Rectangle(Road.CENTER_X-Road.WIDTH-Car.DIAMETER, Road.CENTER_Y-Road.WIDTH-Car.DIAMETER,
//			(Road.WIDTH<<1)+Car.DIAMETER*2, (Road.WIDTH<<1)+Car.DIAMETER*2);
	
	public static Rectangle getCenterRect(){
		return centerR;
	}
}
