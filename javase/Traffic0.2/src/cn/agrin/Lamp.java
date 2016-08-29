package cn.agrin;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Lamp implements Graph{

	enum Color{
		RED(imgRed),GREEN(imgGreen),YELLOW(imgYellow);
		private BufferedImage img = null;
		private Color(BufferedImage img){
			this.img = img;
		}
		public BufferedImage getImg(){
			return img;
		}
	}
	static private BufferedImage imgRed = null;
	static private BufferedImage imgGreen = null;
	static private BufferedImage imgYellow = null;
	static {
		try{
		imgRed = ImageIO.read(new File("img/redLamp.gif"));
		imgGreen = ImageIO.read(new File("img/greenLamp.gif"));
		imgYellow = ImageIO.read(new File("img/yellowLamp.gif"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public static final long RED_TIME = 8;
	public static final int YEOOLW_TIME = 3;
	public static final int DIAMETER = 40;
	
	private Point location = new Point(0,0);
	
	public void setLocation(Point location) {
		this.location.moveTo(location.getX(),location.getY());
	}

	private Color light = Color.RED;
	
	public Lamp(Point location,Color light){
		this.location = location;
		this.light = light;
	}
	public Lamp(){
		
	}
	public Point getLocation() {
		return location;
	}
	/**
	 * 如果是红灯的，说明车不能过
	 * @return
	 */
	public Color lampColor() {
		return light;
	}

	public void setLight(Color light) {
		this.light = light;
	}

	@Override
	public void draw(Graphics g) {
//		Color oldColor = g.getColor();
//		g.setColor(Color.WHITE);
//		g.fillRect(location.getX(), location.getY(), DIAMETER, DIAMETER);
//		if(isRedLamp()){
//			g.setColor(Color.RED);
//		}
//		else{
//			g.setColor(Color.GREEN);
//		}
//		g.fillOval(location.getX(), location.getY(),DIAMETER, DIAMETER);
//		g.setColor(oldColor);
//		BufferedImage img = light.getImg();
//		if(lampColor() == Color.RED){
//			img = 
//		}
//		else if(lampColor() == Color.GREEN){
//			
//		}
//		else {
//			
//		}
		g.drawImage(light.getImg(),location.getX(), location.getY(), DIAMETER, DIAMETER, DemoClient.getInstance());
	}

}
