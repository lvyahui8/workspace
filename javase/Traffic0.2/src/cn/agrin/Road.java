package cn.agrin;

import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



public class Road implements Graph{
	private static final int ADD_CAR_TIME = 1;
	private static final LightControl lc = LightControl.getInstance();
	private boolean hasCar = false;
	public static final int WIDTH = 100;
	public static final int CENTER_X = DemoClient.WINDOW_WIDTH/2;
	public static final int CENTER_Y = DemoClient.WINDOW_HEIGHT/2;
	
//	private Point start = null;
//	private Point end = null;
	private Point leftLane = null;
	private Point forwardLane = null;
	private Point rightLane = null;
	private int number = 0;
	
	private int leftCount = 0;
	private int forwardCount = 0;
	
	public synchronized void reduceLeft(){
		leftCount--;
	}
	public synchronized void reduceForward(){
		forwardCount--;
	}
	public synchronized void addLeft(){
		leftCount++;
	}
	public synchronized void addForward(){
		forwardCount++;
	}
	public Lamp getForward() {
		return forward;
	}

	public Lamp getLeft() {
		return left;
	}
	private Lamp forward = new Lamp();
	private Lamp left = new Lamp();
	
	
	public List<Car> cars = new ArrayList<Car>();
//	public List<Car> passCars = new ArrayList<Car>();
//	public List<Car> waitCars = new ArrayList<Car>();
	
//	public List<Car> getWaitCars() {
//		return waitCars;
//	}

	public Road(final Point start,final Point end,final int number) {
//		this.start = start;
//		this.end = end;
		this.number = number;
		this.init(start,end); 
//		new Thread(new AddCar()).start();
		ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1);
		pool.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run() {
				// TODO 自动生成的方法存根

				Direction dirs [] = Direction.values();
				Random r = new Random();				
				int dir = r.nextInt(3)+1;
				int i = dir +3*(number-1);//明确方向
				switch(dir){
				case 1:{//向前的
					
					if(8 <= forwardCount) return;
					else cars.add(new Car(new Point(forwardLane.getX(),forwardLane.getY()),dirs[i],Road.this));
					addForward();
					break;
				}
				case 2:{//向左的
					if(8 <= leftCount) return;
					else cars.add(new Car(new Point(leftLane.getX(),leftLane.getY()),dirs[i],Road.this));
					addLeft();
					break;
				}
				case 3:{//向右的
					cars.add(new Car(new Point(rightLane.getX(),rightLane.getY()),dirs[i],Road.this));
					break;
				}
//				cars.add(new Car(new Point(start.getX(),start.getY()),dirs[i],Road.this));
				}
				if(false == hasCar) hasCar = true;
			}
			
		}, Road.ADD_CAR_TIME, Road.ADD_CAR_TIME, TimeUnit.SECONDS);
	}
	
	public int getNumber() {
		return number;
	}

	public Road(){
		super();
	}
	
	@SuppressWarnings("static-access")
	private void init(Point start, Point end) {
		int lightLocation [] = new int[4];
		int lanePoint [][] = new int[3][2];//3车道，一个起点，终点就是中场矩形
		//明确每条道路上红绿灯的位置和3车道的起点与终点
		switch(this.number){
		case 1:{
			lightLocation[0] = (DemoClient.WINDOW_WIDTH>>1)-Road.WIDTH-Lamp.DIAMETER;
			lightLocation[1] = (DemoClient.WINDOW_HEIGHT>>1)-Road.WIDTH-Lamp.DIAMETER*2;
			lightLocation[2] = (DemoClient.WINDOW_WIDTH>>1)-Road.WIDTH-Lamp.DIAMETER*2;
			lightLocation[3] = (DemoClient.WINDOW_HEIGHT>>1)-Road.WIDTH-Lamp.DIAMETER*2;
			this.forward.setLight(Lamp.Color.GREEN);
			//左车道起点
			lanePoint[0][0] = (DemoClient.WINDOW_WIDTH)>>1;lanePoint[0][1] = DemoClient.WINDOW_HEIGHT;//lanePoint[0][2] = ;lanePoint[0][3] = ;
			//中车道起点
			lanePoint[1][0] = (DemoClient.WINDOW_WIDTH>>1)+Car.DIAMETER;lanePoint[1][1] = DemoClient.WINDOW_HEIGHT;//lanePoint[1][2] = ;lanePoint[1][3] = ;
			//右车道起点
			lanePoint[2][0] = (DemoClient.WINDOW_WIDTH>>1)+(Car.DIAMETER<<1);lanePoint[2][1] = DemoClient.WINDOW_HEIGHT;//lanePoint[2][2] = ;lanePoint[2][3] = ;
			break;
		}
		case 3:{
			lightLocation[0] = (DemoClient.WINDOW_WIDTH >> 1) + Road.WIDTH;
			lightLocation[1] = (DemoClient.WINDOW_HEIGHT >> 1) + Road.WIDTH
					+ Lamp.DIAMETER;
			lightLocation[2] = (DemoClient.WINDOW_WIDTH >> 1) + Road.WIDTH
					+ Lamp.DIAMETER;
			lightLocation[3] = (DemoClient.WINDOW_HEIGHT >> 1) + Road.WIDTH
					+ Lamp.DIAMETER;
			this.forward.setLight(Lamp.Color.GREEN);
			lanePoint[0][0] = (DemoClient.WINDOW_WIDTH>>1)-Car.DIAMETER;lanePoint[0][1] = 0;//lanePoint[0][2] = ;lanePoint[0][3] = ;
			lanePoint[1][0] = (DemoClient.WINDOW_WIDTH>>1)-(Car.DIAMETER<<1);lanePoint[1][1] = 0;//lanePoint[1][2] = ;lanePoint[1][3] = ;
			lanePoint[2][0] = (DemoClient.WINDOW_WIDTH>>1)-(Car.DIAMETER*3);lanePoint[2][1] = 0;//lanePoint[2][2] = ;lanePoint[2][3] = ;
			break;
		}
		case 2:{
			lightLocation[0] = (DemoClient.WINDOW_WIDTH >> 1) - Road.WIDTH
					- Lamp.DIAMETER * 2;
			lightLocation[1] = (DemoClient.WINDOW_HEIGHT >> 1) + Road.WIDTH;
			lightLocation[2] = (DemoClient.WINDOW_WIDTH >> 1) - Road.WIDTH
					- Lamp.DIAMETER * 2;
			lightLocation[3] = (DemoClient.WINDOW_HEIGHT >> 1) + Road.WIDTH
					+ Lamp.DIAMETER;
			lanePoint[0][0] = DemoClient.WINDOW_WIDTH;lanePoint[0][1] = (DemoClient.WINDOW_HEIGHT>>1) - (Car.DIAMETER);//lanePoint[0][2] = ;lanePoint[0][3] = ;
			lanePoint[1][0] = DemoClient.WINDOW_WIDTH;lanePoint[1][1] = (DemoClient.WINDOW_HEIGHT>>1) - (Car.DIAMETER<<1);//lanePoint[1][2] = ;lanePoint[1][3] = ;
			lanePoint[2][0] = DemoClient.WINDOW_WIDTH;lanePoint[2][1] = (DemoClient.WINDOW_HEIGHT>>1) - (Car.DIAMETER<<1)-Car.DIAMETER;//lanePoint[2][2] = ;lanePoint[2][3] = ;
			break;
		}
		case 4:{
			lightLocation[2] = (DemoClient.WINDOW_WIDTH >> 1) + Road.WIDTH
					+ Lamp.DIAMETER;
			lightLocation[3] = (DemoClient.WINDOW_HEIGHT >> 1) - Road.WIDTH
					- Lamp.DIAMETER * 2;
			lightLocation[0] = (DemoClient.WINDOW_WIDTH >> 1) + Road.WIDTH
					+ Lamp.DIAMETER;
			lightLocation[1] = (DemoClient.WINDOW_HEIGHT >> 1) - Road.WIDTH
					- Lamp.DIAMETER;
			lanePoint[0][0] = 0;lanePoint[0][1] = (DemoClient.WINDOW_HEIGHT)>>1;//lanePoint[0][2] = ;lanePoint[0][3] = ;
			lanePoint[1][0] = 0;lanePoint[1][1] = (DemoClient.WINDOW_HEIGHT>>1)+Car.DIAMETER;//lanePoint[1][2] = ;lanePoint[1][3] = ;
			lanePoint[2][0] = 0;lanePoint[2][1] = (DemoClient.WINDOW_HEIGHT>>1)+(Car.DIAMETER<<1);//lanePoint[2][2] = ;lanePoint[2][3] = ;
			break;
		}
		default:
		}
		//设置红绿灯位置
		this.forward.setLocation(new Point(lightLocation[0],lightLocation[1]));
		this.left.setLocation(new Point(lightLocation[2],lightLocation[3]));
		//将灯添加到控制器中
		this.lc.addLamp(forward);
		this.lc.addLamp(left);
		//设置车道起点
		this.leftLane = new Point(lanePoint[0][0], lanePoint[0][1]);
		this.forwardLane = new Point(lanePoint[1][0], lanePoint[1][1]);
		this.rightLane = new Point(lanePoint[2][0], lanePoint[2][1]);
		
	}

	@Override
	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(Color.RED);

		this.forward.draw(g);
		this.left.draw(g);
		

		
		
		for(int i=0;i<cars.size();i++){
			Car car = cars.get(i);
			car.draw(g);
		}
		
//g.setColor(Color.WHITE);
//g.drawString(number+": nearCar="+cars.size(), 40, number*41);
//g.drawString(number+": LCount="+leftCount, 130, number*41);
//g.drawString(number+": FCount="+forwardCount, (DemoClient.WINDOW_WIDTH>>1)+Road.WIDTH+10, number*41);
		
		g.setColor(oldColor);
	}

}
