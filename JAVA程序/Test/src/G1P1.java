import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;		//��Ҫ���û�ͼ��ɫ
import java.awt.event.*;

public class G1P1 extends JFrame{
    //	������Ϸ��Ļ��С
	final int WIDTH = 900,HEIGHT = 650;
	//	���ó�����ʽ�ٶ�
	double p1Speed = .5,p2Speed = .5;
	//	�� 0,1,2,3��ʾ��������ʻ�����ϣ��ң��£���
	final int UP = 0,RIGHT = 1,DOWN = 2,LEFT =3;
	//	������Ĭ����ʻ����������
	int p1Direction = UP;
	int p2Direction = UP;
	/*	�����Ǵ����Ƶľ���  */
	//	����ľ��ηֱ����������������²��֣��Լ������������� 
	Rectangle left		=		new Rectangle(0,0,WIDTH/9,HEIGHT);													//
	Rectangle right		=		new Rectangle((WIDTH/9)*8,0,WIDTH/9,HEIGHT);										//
	Rectangle top		=		new Rectangle(0,0,WIDTH,HEIGHT/9);													//
	Rectangle bottom	=		new Rectangle(0,(HEIGHT/9)*8,(WIDTH/9)*9,(HEIGHT/9));								//
	Rectangle center	=		new Rectangle(																		//
		(int)((WIDTH/9)*2.5),(int)((HEIGHT/9)*2.5),
		(int)((WIDTH/9)*5),(HEIGHT/9)*4);
	//	��������ܵ��ϵ��ϰ���
	Rectangle obstacle	=		new Rectangle(WIDTH/2,(int)((HEIGHT/9)*7),WIDTH/10,HEIGHT/9);						//
	Rectangle obstacle2	=		new Rectangle(WIDTH/3,(int)((HEIGHT/9)*5),WIDTH/10,HEIGHT/4);						//
	Rectangle obstacle3	=		new Rectangle(2*(WIDTH/3),(int)((HEIGHT/9)*5),WIDTH/10,HEIGHT/4);					//
	Rectangle obstacle4	=		new Rectangle(WIDTH/3,HEIGHT/9,WIDTH/30,HEIGHT/9);									//
	Rectangle obstacle5	=		new Rectangle(WIDTH/2,(int)((HEIGHT/9)*1.5),WIDTH/30,HEIGHT/4);						//
	//	������������ܵ����յ���
	Rectangle finish	=		new Rectangle(WIDTH/9,(HEIGHT/2)-(HEIGHT/9),(int)((WIDTH/9)*1.5),HEIGHT/70);		//
	//	����ľ��δ�����
	Rectangle p1		=		new Rectangle((WIDTH/9),(HEIGHT/2),WIDTH/30,WIDTH/30);
	Rectangle p2		=		new Rectangle(((WIDTH/9)+((int)((WIDTH/9)*1.5)/2)),(HEIGHT/2)+(HEIGHT/10),WIDTH/30,WIDTH/30);

	//	���캯��
	public G1P1(){
		//	ʹ������Ĵ�������JFrame
		super("Radocal Racing");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	//	��������update��update����� paint��Ҳ��˵����awt�̵߳�����paint����
		//	��ʼ���ڲ���
		Move1 m1 = new Move1();
		Move2 m2 = new Move2();
		m1.start();
		m2.start();
	}
	
	//	�÷������ڻ�������������
	public void paint(Graphics g){
		super.paint(g);
		//	������������
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0,0,WIDTH,HEIGHT);
		//	����ʱ�Ƚ���������Ϊ��ɫ
		g.setColor(Color.GREEN);
		//	����ľ������ڻ������ܵ���������
		Rectangle line0		=		new Rectangle(WIDTH/9,HEIGHT/2,(int)((WIDTH/9)*1.5)/2,HEIGHT/140);					//
		//	����ľ������ڻ������ܵ���������
		Rectangle line1		=		new Rectangle(																		//							
			((WIDTH/9)+((int)((WIDTH/9)*1.5)/2)),
			(HEIGHT/10)+(HEIGHT/2),
			(int)((WIDTH/9)*1.5)/2,
			HEIGHT/140);
		//	���ڻ��Ƹ�������
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
		//	���������ߵ���ɫΪ��ɫ��Ȼ�����������
		g.setColor(Color.WHITE);
		g.fillRect(line0.x,line0.y,line0.width,line0.height);
		g.fillRect(line1.x,line1.y,line1.width,line1.height);
		//	�����յ����ɫΪ��ɫ��Ȼ������յ���
		g.setColor(Color.YELLOW);
		g.fillRect(finish.x,finish.y,finish.width,finish.height);
		//	��������1Ϊ��ɫ
		g.setColor(Color.BLUE);
		//	��������1
		g.fill3DRect(p1.x,p1.y,p1.width,p1.height,true);
		//	��������2Ϊ��ɫ
		g.setColor(Color.RED);
		//	��������2
		g.fill3DRect(p2.x,p2.y,p2.width,p2.height,true);
	}

	private class Move1 extends Thread implements KeyListener{
	    public void run(){
	    	addKeyListener(this);
			while(true){
				try {
				    //	ˢ����Ϸ��Ļ
					repaint();
					//	�������ײ����ǽ����ô����4
					if(
							p1.intersects(left)		|| 
							p1.intersects(right)	||
							p1.intersects(top)		||
							p1.intersects(bottom) 	||
							p1.intersects(obstacle) ||
							p1.intersects(obstacle2)||
							p1.intersects(p2) 		||
							p1.intersects(obstacle3)||
							p1.intersects(obstacle4)||
							p1.intersects(obstacle5)
 							){
						 p1Speed = -4;
					}
					if (p1.intersects(center)){
						p1Speed = -2.5;
					}
					//	��ʻ�����в��ϼ���
					if (p1Speed<=5) {
					    p1Speed += .2;
					}
					//	���ͨ���������Ʒ���
					if(UP == p1Direction){
						p1.y -= (int)p1Speed;
					}
					else if(DOWN == p1Direction){
						p1.y += (int)p1Speed;
					}
					else if(LEFT == p1Direction){
						p1.x -= (int)p1Speed;
					}
					else if(RIGHT == p1Direction){
						p1.x += (int)p1Speed;
					}
					//	����ÿ�μ��ٵ�ʱ����
					Thread.sleep(100);
				}
				catch (Exception e) {
				    break;
				}
			}
		}
	    
	    //	�÷����ڰ���ĳ��ʱ����
	    public void keyPressed(KeyEvent event){
	    	
	    }
	    //	�÷������ͷ�ĳ����ʱ����
	    public void keyReleased(KeyEvent event){
	    	
	    }
	    //	�÷����ڼ���ĳ����ֵʱ����
	    public void keyTyped(KeyEvent event){
	    	char key = event.getKeyChar();
	    	if('a' == key){
	    		p1Direction = LEFT;
	    	}
	    	else if ('s' == key){
	    		p1Direction = DOWN;
	    	}
	    	else if ('d' == key){
	    		p1Direction = RIGHT;
	    	}
	    	else if ('w' == key){
	    		p1Direction = UP;
	    	}
	    }
	}
	private class Move2 extends Thread implements KeyListener{
	    public void run(){
	    	addKeyListener(this);
			while(true){
				try {
				    //	ˢ����Ϸ��Ļ
			//		repaint();
					//	�������ײ����ǽ����ô����4
					if(
							p2.intersects(left)		|| 
							p2.intersects(right)	||
							p2.intersects(top)		||
							p2.intersects(bottom) 	||
							p2.intersects(obstacle) ||
							p2.intersects(obstacle2)||
							p2.intersects(p1)		||
							p2.intersects(obstacle3)||
							p2.intersects(obstacle4)||
							p2.intersects(obstacle5)
 							){
						 p2Speed = -4;
					}
					if (p2.intersects(center)){
						p2Speed = - 2.5;
					}
					//	��ʻ�����в��ϼ���
					if (p2Speed<=5) {
					    p2Speed += .2;
					}
					//	���ͨ���������Ʒ���
					if(UP == p2Direction){
						p2.y -= (int)p2Speed;
					}
					else if(DOWN == p2Direction){
						p2.y += (int)p2Speed;
					}
					else if(LEFT == p2Direction){
						p2.x -= (int)p2Speed;
					}
					else if(RIGHT == p2Direction){
						p2.x += (int)p2Speed;
					}
					//	����ÿ�μ��ٵ�ʱ����
					Thread.sleep(100);
				}
				catch (Exception e) {
				    break;
				}
			}
		}
	    
	    //	�÷����ڰ���ĳ��ʱ����
	    public void keyPressed(KeyEvent event){
	    	
	    }
	    //	�÷������ͷ�ĳ����ʱ����
	    public void keyReleased(KeyEvent event){
	    	
	    }
	    //	�÷����ڼ���ĳ����ֵʱ����
	    public void keyTyped(KeyEvent event){
	    	char key = event.getKeyChar();
	    	if('j' == key){
	    		p2Direction = LEFT;
	    	}
	    	else if ('k' == key){
	    		p2Direction = DOWN;
	    	}
	    	else if ('l' == key){
	    		p2Direction = RIGHT;
	    	}
	    	else if ('i' == key){
	    		p2Direction = UP;
	    	}
	    }
	}
	public static void main(String [] argssd){
		new G1P1();
	}
}