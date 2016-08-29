package com.grin;

import java.awt.Color;//Abstract Window  Toolkits  
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bird extends AbstractBird {
	private int speed = 0;

	private Image [] icons = null;
	private int currrent_icon = 0;
	protected Bird(int height) {
		super(height);
		locateIcon();
	}

	private void locateIcon() {
		//将目录./img/birds/封装才对象，方便操作文件夹
		File dir = new File("./img/birds/");
		if(dir.exists()){
			//获取当前目录的所有文件
			File files [] = dir.listFiles();
			icons = new Image[files.length];
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				try {
					icons[i] = ImageIO.read(file);
				} catch (IOException e) {
					//
					e.printStackTrace();
				}
			}
			
		}
	}

	@Override
	public void draw(Graphics g,GameClient gc) {
		Color oldCOlor = g.getColor();
		g.setColor(Color.BLUE);
		drawBird(g,gc);
		//降落
		sport(gc,g);
		g.setColor(oldCOlor);
	}
	
	private static int time = 0;
	private void drawBird(Graphics g,GameClient gc) {
		if(null == icons){
			g.fillOval(super.getX(),super.getHeight(), AbstractBird.RADIUS, AbstractBird.RADIUS);
		}
		else{
			g.drawImage(icons[currrent_icon], super.getX(), 
					super.getHeight(), AbstractBird.RADIUS<<1,AbstractBird.RADIUS<<1,null,gc);
		} 
		
		if(9 == time){
			//换图片
			currrent_icon = (currrent_icon+1)%icons.length;
		}
		time = (time+1)%10;
g.drawRect(super.getX(), super.getHeight(), RADIUS<<1, RADIUS<<1);
//		System.out.println(currrent_icon);
//		System.out.println(icons.length);
	}

	public void sport(GameClient gc,Graphics g) {
		Aisle [] aisles = gc.getAisles();
//System.out.println(aisles.length);
		for (int i = 0; i < aisles.length; i++) {
			Aisle aisle = aisles[i];
			if(super.collideWalls(aisle.getWalls(),g)){
System.out.println("哈哈。你撞到了"+i);
			}
//System.out.println(i);
		}
//System.out.println(super.getHeight());
		
		super.setHeight(super.getHeight()+speed);
		constantAcceleration();
		int col_Bor=super.collodeBorder();
		if(1==col_Bor){
			super.setHeight(20);
		}
		else if(-1==col_Bor){
			super.setHeight(GameClient.HEIGHT-AbstractBird.RADIUS*2-1);
		}

	}
	
	public void constantAcceleration(){//向下匀加速
		speed += AbstractBird.G;
	}
	/*
	private void sport(){
		
		if(super.collodeBorder())
			speed=0;
	
		super.setHeight(super.getHeight()+speed);
		speed+=AbstractBird.G;
	}
	*/
	@Override
	public void jump() {	//跳跃
		speed = AbstractBird.JUMP_SPEED;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_SPACE:
			jump();
			break;

		default:
			break;
		}
	}

}
