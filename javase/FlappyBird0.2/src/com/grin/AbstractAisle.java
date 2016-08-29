package com.grin;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class AbstractAisle {
	public static final int WIDTH = 60;
	public static final int HEIGHT = AbstractBird.RADIUS*6;

	private int x;
	private int upside;
	private int turns=0;
	
	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

	private GameClient gc = null;

	public GameClient getGc() {
		return gc;
	}

	protected AbstractAisle(GameClient gc, int upside) {
		this.gc = gc;
		restart();
		System.out.println(x);
		this.upside = upside;
	}

	public void restart() {
		turns++;
		this.x = gc.getWidth();
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getUpside() {
		return upside;
	}
	public void setUpside(int upside) {
		this.upside = upside;
	}
	public int getBelow() {
		return upside + HEIGHT;
	}
	
	abstract void self_draw(Graphics g);
	
	public Rectangle [] getWalls(){
		Rectangle [] walls = {
				new Rectangle(this.x,0,WIDTH,upside),
				new Rectangle(this.x,upside+HEIGHT,WIDTH,gc.getHeight()-upside-HEIGHT)
		};
		return walls;
	}
	
	public boolean collodeAisle(){
		return x<-WIDTH;
	}
	
}