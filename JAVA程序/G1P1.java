import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;		//需要设置绘图颜色
import java.awt.event.*;

public class G1P1 extends JFrame{
    //	设置游戏屏幕大小
	final int WIDTH = 900,HEIGHT = 650;
	//	设置车的形式速度
	double p1Speed = .5,p2Speed = .5;

	/*	下面是待绘制的矩形  */
	//	下面的矩形分别是赛场的左右上下部分，以及赛场中央区域
	Rectangle left		=		new Rectangle(0,0,WIDTH/9,HEIGHT);
	Rectangle right		=		new Rectangle((WIDTH/9)*9,0,WIDTH/9,HEIGHT);
	Rectangle top		=		new Rectangle(0,0,WIDTH,HEIGHT/9);
	Rectangle bottom	=		new Rectangle(0,(HEIGHT/9)*9,(WIDTH/9)*10,(HEIGHT/9));
	Rectangle center	=		new Rectangle(
		(int)((WIDTH/9)*2.5),(int)((HEIGHT/9)*2.5),
		(int)((WIDTH/9)*5),(HEIGHT/9)*4);
	//	下面绘制跑道上的障碍物
	Rectangle obstacle	=		new Rectangle(WIDTH/2,(int)((HEIGHT/9)*7),WIDTH/10,HEIGHT/9);
	Rectangle obstacle2	=		new Rectangle(WIDTH/3,(int)((HEIGHT/9)*5),WIDTH/10,HEIGHT/4);
	Rectangle obstacle3	=		new Rectangle(2*(WIDTH/3),(int)((HEIGHT/9)*5),WIDTH/10,HEIGHT/4);
	Rectangle obstacle4	=		new Rectangle(WIDTH/3,HEIGHT/9,WIDTH/30,HEIGHT/9);
	Rectangle obstacle5	=		new Rectangle(WIDTH/2,(int)((HEIGHT/9)*1.5),WIDTH/30,HEIGHT/4);
	//	下面绘制内外跑道的终点线
	Rectangle finish	=		new Rectangle(WIDTH/9,(HEIGHT/2)-(HEIGHT/9),(int)((WIDTH/9)*1.5),HEIGHT/70);
	//	下面的矩形用于绘制外跑道的起跑线
	Rectangle line0		=		new Rectangle(WIDTH/9,HEIGHT/2,(int)((WIDTH/9)*1.5)/2,HEIGHT/140);
	//	下面的矩形用于绘制内跑道的起跑线
	Rectangle line1		=		new Rectangle(
		((WIDTH/9)+((int)((WIDTH/9)*1.5)/2)),
		(HEIGHT/10)+(HEIGHT/2),
		(int)((WIDTH/9)*1.5)/2,
		HEIGHT/140);
	//	下面的矩形代表车辆
	Rectangle p1		=		new Rectangle((WIDTH/9),(HEIGHT/2),WIDTH/30,WIDTH/30);
	Rectangle p2		=		new Rectangle(((WIDTH/9)+((int)((WIDTH/9)*1.5)/2)),(HEIGHT/2)+(HEIGHT/10),WIDTH/30,WIDTH/30);

	//	构造函数
	public G1P1(){
		//	使用下面的代码设置JFrame
		super("Radocal Racing");
		setSize(WIDTH/9*10,HEIGHT/9*10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	//	这里会调用update，update会调用 paint，也有说法是awt线程调用了paint方法
		//	初始化内部类
		Move1 m1 = new Move1();
		Move2 m2 = new Move2();
		m1.start();
		m2.start();
	}

	//	该方法用于绘制赛车和赛场
	public void paint(Graphics g){
		super.paint(g);
		//	绘制赛场背景
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0,0,WIDTH,HEIGHT);
		//	绘制时先将场地设置为绿色
		g.setColor(Color.GREEN);
		//	现在绘制各个矩形
		g.fillRect(left.x,left.y,left.width,left.height);
		g.fillRect(right.x,right.y,right.width,right.height);
		g.fillRect(top.x,top.y,top.width,top.height);
		g.fillRect(bottom.x,bottom.y,bottom.width,bottom.height);
		g.fillRect(center.x,center.y,center.width,center.height);
		g.fillRect(obstacle.x,obstacle.y,obstacle.width,obstacle.height);
		g.fillRect(obstacle2.x,obstacle2.y,obstacle2.width,obstacle2.height);
		g.fillRect(obstacle3.x,obstacle3.y,obstacle3.width,obstacle3.height);
		g.fillRect(obstacle4.x,obstacle4.y,obstacle4.width,obstacle4.height);
		g.fillRect(obstacle5.x,obstacle5.y,obstacle5.width,obstacle5.height);
		//	设置起跑线的颜色为白色，然后绘制起跑线
		g.setColor(Color.WHITE);
		g.fillRect(line0.x,line0.y,line0.width,line0.height);
		g.fillRect(line1.x,line1.y,line1.width,line1.height);
		//	设置终点的颜色为黄色，然后绘制终点线
		g.setColor(Color.YELLOW);
		g.fillRect(finish.x,finish.y,finish.width,finish.height);
		//	设置赛车1为蓝色
		g.setColor(Color.BLUE);
		//	绘制赛车1
		g.fill3DRect(p1.x,p1.y,p1.width,p1.height,true);
		//	设置赛车2为红色
		g.setColor(Color.RED);
		//	绘制赛车2
		g.fill3DRect(p2.x,p2.y,p2.width,p2.height,true);
	}

	private class Move1 extends Thread {
	    public void run(){
			while(true){
				try {
				    //	刷新游戏屏幕
					repaint();
					if (p1Speed<=5) {
					    p1Speed += .2;
					}

					p1.y -= p1Speed;
					//	设置每次加速的时间间隔
					Thread.sleep(60);
				}
				catch (Exception e) {
				    break;
				}
			}
		}
	}
	private class Move2 extends Thread {
	    public void run(){
			while(true){
				try {
				    //	刷新游戏屏幕
					repaint();
					if (p2Speed<=5) {
					    p2Speed += .2;
					}

					p2.y -= p2Speed;
					//	设置每次加速的时间间隔
					Thread.sleep(60);
				}
				catch (Exception e) {
				    break;
				}
			}
		}
	}
	public static void main(String [] argssd){
		new G1P1();
	}
}