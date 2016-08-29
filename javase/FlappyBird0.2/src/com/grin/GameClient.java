package com.grin;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;

@SuppressWarnings("serial")
public class GameClient extends Frame {//java gui  graphs  user interface   ///   awt   swing
	public static final int  WIDTH = 300;
	public static final int HEIGHT = 400;
	
	Bird bird = new Bird(HEIGHT>>1);
	Aisle aisle= null;
	Aisle aisle1=null;
	public GameClient(String title){
		setFrame(title);
		addListener();
		aisle = new Aisle(this, 100);
		aisle1 = new Aisle(this,200);
		startRepaintThread();
//		 try {
//			   FileInputStream fileau=new FileInputStream("D:/01.mid" );
//			   AudioStream as=new AudioStream(fileau);
//			   AudioPlayer.player.start(as);
//			    }
//			  catch (Exception e) {System.out.println("ʧ�ܿ���");}
//			}
	}
	
	public Aisle  [] getAisles() {
		Aisle [] aisles ={
				aisle,
				aisle1
		};
		return aisles;
	}

	//˫���弼�� 
	private Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		if (null == offScreenImage) {
			offScreenImage = super.createImage(WIDTH, HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color oldColor = gOffScreen.getColor();
		gOffScreen.setColor(Color.WHITE);
		gOffScreen.fillRect(0, 0, WIDTH, HEIGHT);
		gOffScreen.setColor(oldColor);
		
		paint(gOffScreen);
		
		g.drawImage(offScreenImage, 0, 0, null);
	}
	 //repaint->update->paint
//	static int i = 0;
	@Override
	public void paint(Graphics g) {
		Color oldColor = g.getColor();
//		g.setColor(Color.RED);
//		g.drawRect(i++, GameClient.HEIGHT>>1,10, 10);
		aisle.self_draw(g);
	
		if(aisle.getX()<(WIDTH-AbstractAisle.WIDTH)/2 || aisle.getTurns()>aisle1.getTurns()){
			aisle1.self_draw(g);
		}
		bird.draw(g,this);
		g.setColor(oldColor);
	}

	private void startRepaintThread() {
		//����
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
						try {
							//���ܳ����쳣�Ĵ���
							Thread.sleep(60);
							GameClient.super.repaint();
						} catch (InterruptedException/*�쳣����*/ e) {
							/*�����쳣*/
							e.printStackTrace();
						}
				}
			}
		}).start();
	}

	private void addListener() {
		//���Ӵ��ڼ�����ʹ���ڿɹر�
		super.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		//���Ӽ��̼���
		super.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				bird.keyPressed(e);
			}
			
		});
	}

	private void setFrame(String title) {
		super.setTitle(title);
		super.setBounds(100, 100, WIDTH, HEIGHT);
//		super.setLocation(100, 100);
//		super.setSize(WIDTH, HEIGHT);
System.out.println(super.getWidth());
		super.setResizable(false);
		super.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GameClient("FlappyBird");
	}
}
