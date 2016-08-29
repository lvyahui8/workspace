package com.grin;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class AbstractBird {

	public static final int RADIUS = 20;//С��뾶
	public static final int G = 1;		//�������ٶ�
	public static final int JUMP_SPEED = -9;//��Ծ���ٶ�
	private int height;	//С��ǰ�߶�
	private Rectangle rect;
	
	protected AbstractBird(int height) {
		this.height = height;
	}

	
	
	//���󷽷���������ʵ��
	abstract public void draw(Graphics g,GameClient gc);	//��ͼ
	abstract public void jump();							//��Ծ
//	abstract public void sport(GameClient gc);							//����
	
	
	
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getX(){
		return GameClient.WIDTH>>2;
	}
	public boolean collideWalls(Rectangle [] walls, Graphics g){
		boolean isCollde = false;
		for(int i = 0;i < walls.length;i++){
//System.out.println("hh"+i);
//System.out.println("hh"+i+":"+this.getRect()+":"+walls[i]);
			g.drawRect((int)walls[i].getX(),(int) walls[i].getY(), (int)walls[i].getWidth(), (int)walls[i].getHeight());
			g.drawRect((int)this.getRect().getX(),(int) this.getRect().getY(), (int)this.getRect().getWidth(), (int)this.getRect().getHeight());
//System.out.println(rect);
			if(walls[i].intersects(this.getRect())){
				isCollde = true;
				System.out.println("hh"+i+":");
				break;
			}
		}
//System.out.println(this.getRect());
//System.out.println(walls[0]);
//System.out.println(walls[1]);
		return isCollde;
	}
	protected Rectangle getRect(){
		return new Rectangle(this.getX(),this.getHeight(),RADIUS<<1,RADIUS<<1);
	}
	
	public int collodeBorder(){
		int res = 0;
		if(this.getHeight() >= (GameClient.HEIGHT - (AbstractBird.RADIUS<<1)+ 5)){
			res = -1;
		}
		else if(this.getHeight() <= 15){
			res=1;
		}
		return  res ;
	}
}
