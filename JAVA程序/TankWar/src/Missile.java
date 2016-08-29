import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.awt.Rectangle;



public class Missile {
	public static final int MIS_R = 10;
	private static final int YSPEED = 15;
	private static final int XSPEED = 15;
	int currentX;
	int currentY;
	Tank.Direction dir;
	private boolean live = true;
	private boolean good;
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean bLive) {
		this.live = bLive;
	}

	private TankClient tc;
	public Missile(int currentX, int currentY, Tank.Direction dir, TankClient tc) {
		this(currentX,currentY,dir);
		this.tc = tc;
	}
	public Missile(int currentX, int currentY, Tank.Direction dir, TankClient tc,boolean good) {
		this(currentX,currentY,dir,tc);
		this.good = good;
	}

	public Missile(int currentX, int currentY, Tank.Direction dir) {
		this.currentX = currentX;
		this.currentY = currentY;
		this.dir = dir;
	}
	
	public void draw(Graphics g){
		move();
		Color oldColor = g.getColor();
		g.setColor(Color.BLACK);
		g.fillOval(currentX, currentY, MIS_R, MIS_R);
		g.setColor(oldColor);
	}

	public void move() {
		// TODO 自动生成的方法存根
		switch(dir){
		case L:{
			currentX -= XSPEED;
			break;
		}
		case LU:{
			currentX -= XSPEED;
			currentY -= YSPEED;
			break;
		}
		case U:{
			currentY -= YSPEED;
			break;
		}
		case RU:{
			currentX += XSPEED;
			currentY -= YSPEED;
			break;
		}
		case R:{
			currentX += XSPEED;
			break;
		}
		case RD:{
			currentX += XSPEED;
			currentY += YSPEED;
			break;
		}
		case D:{
			currentY += YSPEED;
			break;
		}
		case LD:{
			currentX -= XSPEED;
			currentY += YSPEED;
			break;
		}
		default:
		}
		
		if(!live || currentX<0 || currentY<0 || currentX >TankClient.BACK_WIDTH || currentY>TankClient.BACK_HEIGHT){
//			live = false;
			tc.missiles.remove(this);
		}
	}
	
	public Rectangle getRect(){
		return new Rectangle(currentX,currentY,MIS_R,MIS_R);
	}
	public boolean hitTank(Tank t){
		if (t.isLive() && this.getRect().intersects(t.getRect()) && this.good != t.isGood()) {
			t.setLive(false);
			this.live = false;
			tc.explodes.add(new Explode(currentX, currentY, tc));
			return true;
		}
		return false;
	}
	
	public boolean hisTanks(List <Tank> tanks){
		for (int i = 0;i<tanks.size();i++) {
			if (hitTank(tanks.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hitWall(Wall w){
		if(this.live && this.getRect().intersects(w.getRect())){
			this.live = false;
			return true;
		}
		return false;
	}
}
