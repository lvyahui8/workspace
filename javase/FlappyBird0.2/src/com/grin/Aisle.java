package com.grin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Aisle extends AbstractAisle {

	public Aisle(GameClient gc, int upside) {
		super(gc, upside);
		// TODO 自动生成的构造函数存根
	}

	@Override
	void self_draw(Graphics g) {
		Color oldcolor=g.getColor();
		g.setColor(Color.red);
//		g.fill3DRect(super.getX(),0,AbstractAisle.WIDTH,super.getGc().getHeight(),true);
//		g.setColor(Color.white);
//		g.fill3DRect(super.getX(),super.getUpside(),  WIDTH, HEIGHT, false);
		Rectangle rs [] = super.getWalls();
		for (int i = 0; i < rs.length; i++) {
			g.drawRect((int)rs[i].getX(),(int) rs[i].getY(), (int)rs[i].getWidth(), (int)rs[i].getHeight());
		}
		
		super.setX(super.getX()-4);
		if (super.collodeAisle()) {
			super.restart();
		}
//System.out.println(super.getX()+",");
		g.setColor(oldcolor);
	}
}
