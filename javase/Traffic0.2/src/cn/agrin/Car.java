package cn.agrin;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Car implements Graph{
	private BufferedImage bgImage;
	public static final   Point [] LINEAR_SPEED= {
		new Point(0,0),
		new Point(0,-3),
		new Point(-3,0),
		new Point(0,3),
		new Point(3,0)
	};
	
	private Lamp lamp = null;
	
	public static final int DIAMETER = Road.WIDTH/3;
	private Point location = null;
	private Steering steer = null;
	public Steering getSteer() {
		return steer;
	}
	public Point getLocation() {
		return location;
	}
	private Direction dir = null;
	
	private int xSpeed = 0;
	private int ySpeed = 0;
	private void setSpeed(int xSpeed,int ySpeed){
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	private Road road = null;
	private int number = -3;
	public static Random r = new Random();
	public Car(Point location,Direction dir,Road road){
		this.location = new Point(location.getX(),location.getY());
		this.dir = dir;
		this.road = road;
		this.lamp = road.getForward();
		number = road.getNumber();
		setSteering();
		setLinerSpeed(number);
		int ico = r.nextInt(11)+1;
		try {
			this.bgImage = ImageIO.read(new File("car/car ("+ico+").gif"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/**
	 * @param num 
	 * 
	 */
	private void setLinerSpeed(int num) {
		this.xSpeed = LINEAR_SPEED[num].getX();
		this.ySpeed = LINEAR_SPEED[num].getY();
	}
	
	private int turnDir = 0;
	public int getTurnDir(){
		return turnDir ;
	}
	private void setSteering() {
		// TODO 自动生成的方法存根
//System.out.println(number);
		turnDir = drection();
		switch(turnDir){
		case 1:{//左转
			lamp = road.getLeft();
			steer = new Steering(45,4 == number ? 1 : number+1,turnDir){
				@Override
				void turn() {
					// TODO 自动生成的方法存根
					switch(road.getNumber()){
					case 1:{
						xSpeed = -x;ySpeed = -y;
						break;
					}
					case 2:{
						xSpeed = -x;ySpeed = y;
						break;
					}
					case 3:{
						xSpeed = x;ySpeed = y;
						break;
					}
					case 4:{
						xSpeed = x;ySpeed = -y;
						break;
					}
					}
					this.turning = true;
				}
				
			};
			break;
		}
		case 3:{//右转
			steer = new Steering(11,1 == number ? 4 : number-1,turnDir){
				@Override
				void turn() {
					// TODO 自动生成的方法存根
					switch(road.getNumber()){
					case 1:{
						xSpeed = x;ySpeed = -y;
						break;
					}
					case 2:{
						xSpeed = -x;ySpeed = -y;
						break;
					}
					case 3:{
						xSpeed = -x;ySpeed = y;
						break;
					}
					case 4:{
						xSpeed = x;ySpeed = y;
						break;
					}
					}
					this.turning = true;
				}
				
			};
			break;
		}
		default:
		}
	}

	private boolean overLine = false;//已经过线了，就不受灯限制了
	public void  move(){
		if (location.getX() < -20
				|| location.getX() > DemoClient.WINDOW_WIDTH + 2
				|| location.getY() < 0
				|| location.getY() > DemoClient.WINDOW_HEIGHT + 2) {

			road.cars.remove(this);
		}
		if(!overLine && DemoClient.getCenterRect().intersects(this.getRect())){
			if(this.turnDir != 3 && ( this.lamp.lampColor() == Lamp.Color.RED || this.lamp.lampColor() == Lamp.Color.YELLOW)){
				return;
			}
			if(this.steer != null){
				this.steer.turn();
			}
			if(1 == this.turnDir){
				road.reduceLeft();
//				System.out.println(this.getTurnDir()+":"+this.dir.name());
			}
			else if(2 == this.turnDir){
				road.reduceForward();
//				System.out.println(this.getTurnDir()+":"+this.dir.name());
			}
			overLine = true;
		}
		if (steer != null && true == steer.turning) {
			steer.count++;
			if (steer.count == steer.step) {
				steer.turning = false;
				setLinerSpeed(steer.nextNumber);
			}
		}
		if(collideCars()){
			return;
		}
		//移动
		location.moveTo(location.getX() + xSpeed, location.getY() + ySpeed);
		
	}
	private boolean collideCars() {
		// TODO 自动生成的方法存根
		for(int i = road.cars.indexOf(this)-1;i>=0;i--){
			if(this.getRect().intersects(road.cars.get(i).getRect())){
				return true;
			}
		}
		return false;
	}
	@Override
	public void draw(Graphics g) {
//		Color oldColor = g.getColor();
//		g.setColor(Color.BLUE);
//		g.fillRect(location.getX(), location.getY(),DIAMETER, DIAMETER);
//		g.setColor(Color.WHITE);
//g.drawString(""+road.cars.indexOf(this),location.getX()+10, location.getY()+10);
		g.drawImage(bgImage, this.location.getX(), this.location.getY(), Car.DIAMETER, Car.DIAMETER,DemoClient.getInstance());

//		g.setColor(oldColor);
		if(!isStop() ){
			move();
		}
	}

	public int drection(){
//		S2N,S2W,E2W,E2S,
//		N2S,N2E,W2E,W2N,
//		S2E,E2N,N2W,W2S;
		int res = 2;//默认向前 
		switch(dir){
		case S2W:case E2S:case N2E:case W2N:{
			res = 1;//左转
			break;
		}
		case S2E:case E2N:case N2W:case W2S:{
			res = 3;//右转
			break;
		}
		default:
		}
		return res;
	}
	
	private int oldXSpeed=xSpeed,oldYSpeed=ySpeed;
	public int getOldXSpeed() {
		return oldXSpeed;
	}
	public int getOldYSpeed() {
		return oldYSpeed;
	}
	public void stop(){
		oldXSpeed = xSpeed;
		oldYSpeed = ySpeed;
		xSpeed = 0;
		ySpeed = 0;
	}

	public void restart(){
		this.setSpeed(oldYSpeed, oldYSpeed);
	}
	public boolean isStop(){
		return 0 == xSpeed && 0 == ySpeed;
 	}
	
	abstract class Steering {
		int x = 3,y =3;
		boolean turning = false;
		int step = 0;//转弯所需步数
		int count = 0;//转弯步数
		abstract void turn();
		int nextNumber = 0;//转向完了之后他在那条路上
		int turnDir;
		public Steering(int step,int number,int turnDir){
			this.step = step;
//			if(0 == number){
//				this.nextNumber = 4;
//			}else if(5 == number){
//				this.nextNumber = 1;
//			}
//			else if(number >= 1)
				this.nextNumber = number;
				this.turnDir = turnDir;
		}
	}
	
	
	public Rectangle getRect() {
		// TODO 自动生成的方法存根
		int i = 0;
		return new Rectangle(location.getX()+i,location.getY()+i,Car.DIAMETER-i,Car.DIAMETER-i);
	}
}
