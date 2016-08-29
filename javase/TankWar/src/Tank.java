import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

public class Tank {
	private int currentX = 0;
	private int currentY = 0;
	private int oldX;
	private int oldY;
	private static final int XSPEED = 6;// X方向速度
	private static final int YSPEED = 6;// Y方向速度
	private static final int TANK_R = 30; // 坦克半径
	private boolean live = true;
	private boolean good = false;
	private static Random r = new Random();

	enum Direction {
		L, LU, U, RU, R, RD, D, LD, STOP
	}; // 代表方向

	private boolean bL = false;
	private boolean bR = false;
	private boolean bU = false;
	private boolean bD = false;
	private Direction dir = Direction.STOP;
	private Direction ptDir = Direction.D;
	private int step = r.nextInt(12) + 3;
	static TankClient tc = null;

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}

	public Tank() {

	}

	{
		oldX = currentX;
		oldY = currentY; 
	}
	
	public Tank(int currentX, int currentY, boolean good) {
		this.currentX = currentX;
		this.currentY = currentY;
		this.good = good;
	}

	public Tank(int currentX, int currentY, boolean good, TankClient tc) {
		this(currentX, currentY, good);
		this.tc = tc;
	}

	public Tank(int currentX, int currentY, boolean good, TankClient tc,
			Direction dir) {
		this(currentX, currentY, good, tc);
		this.dir = dir;
	}

	public void move() {
		this.oldX = this.currentX;
		this.oldY = this.currentY;
		if (currentX < 0) {
			currentX = 0;
			return;
		}
		if (currentY < 30) {
			currentY = 30;
			return;
		}
		if (currentX + Tank.TANK_R > TankClient.BACK_WIDTH) {
			currentX = TankClient.BACK_WIDTH - Tank.TANK_R;
			return;
		}
		if (currentY + Tank.TANK_R > TankClient.BACK_HEIGHT) {
			currentY = TankClient.BACK_HEIGHT - Tank.TANK_R;
			return;
		}

		if (!good) {
			if (step == 0) {
				step = r.nextInt(12) + 3;

				Direction[] dirs = Direction.values();
				int rn = r.nextInt(dirs.length);
				this.dir = dirs[rn];
			}
			step--;
			if(r.nextInt(40)>36) this.fir(this.ptDir);
		}
		switch (dir) {
		case L: {
			currentX -= XSPEED;
			break;
		}
		case LU: {
			currentX -= XSPEED;
			currentY -= YSPEED;
			break;
		}
		case U: {
			currentY -= YSPEED;
			break;
		}
		case RU: {
			currentX += XSPEED;
			currentY -= YSPEED;
			break;
		}
		case R: {
			currentX += XSPEED;
			break;
		}
		case RD: {
			currentX += XSPEED;
			currentY += YSPEED;
			break;
		}
		case D: {
			currentY += YSPEED;
			break;
		}
		case LD: {
			currentX -= XSPEED;
			currentY += YSPEED;
			break;
		}
		default:
		}

		if (dir != Direction.STOP) {
			ptDir = dir;
		}
		// dir = Direction.STOP;
		// bR = bU = bL = bD = false;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void draw(Graphics g) {
		
		if (!live) {
			if (!good) {
			}
			else{
//				System.exit(0);
				tc.tank = Tank.getGoodTank();
				tc.tanks.add(tc.tank);
			}
			tc.tanks.remove(this);
			return;
		}
		this.move();
		Color oldColor = g.getColor();
		if (good) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.BLUE);
		}
		g.fillOval(currentX, currentY, TANK_R, TANK_R);
		g.setColor(oldColor);
		switch (ptDir) {
		case L: {
			g.drawLine(currentX + TANK_R / 2, currentY + TANK_R / 2, currentX,
					currentY + TANK_R / 2);
			break;
		}
		case LU: {
			g.drawLine(currentX + TANK_R / 2, currentY + TANK_R / 2, currentX,
					currentY);
			break;
		}
		case U: {
			g.drawLine(currentX + TANK_R / 2, currentY + TANK_R / 2, currentX
					+ TANK_R / 2, currentY);
			break;
		}
		case RU: {
			g.drawLine(currentX + TANK_R / 2, currentY + TANK_R / 2, currentX
					+ TANK_R, currentY);
			break;
		}
		case R: {
			g.drawLine(currentX + TANK_R / 2, currentY + TANK_R / 2, currentX
					+ TANK_R, currentY + TANK_R / 2);
			break;
		}
		case RD: {
			g.drawLine(currentX + TANK_R / 2, currentY + TANK_R / 2, currentX
					+ TANK_R, currentY + TANK_R);
			break;
		}
		case D: {
			g.drawLine(currentX + TANK_R / 2, currentY + TANK_R / 2, currentX
					+ TANK_R / 2, currentY + TANK_R);
			break;
		}
		case LD: {
			g.drawLine(currentX + TANK_R / 2, currentY + TANK_R / 2, currentX,
					currentY + TANK_R);
			break;
		}
		default:
		}
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		// System.out.println(key);
		tellKey(key, true);
	}

	public Rectangle getRect() {
		return new Rectangle(currentX, currentY, Tank.TANK_R, Tank.TANK_R);
	}

	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
		int key = e.getKeyCode();
		tellKey(key, false);
	}

	/**
	 * @param key
	 * @param bFlags
	 */
	public void tellKey(int key, boolean bFlags) {
		switch (key) {
		case KeyEvent.VK_RIGHT: {
			bR = bFlags;
			break;
		}
		case KeyEvent.VK_LEFT: {
			bL = bFlags;
			break;
		}
		case KeyEvent.VK_UP: {
			bU = bFlags;
			break;
		}
		case KeyEvent.VK_DOWN: {
			bD = bFlags;
			break;
		}
		case KeyEvent.VK_CONTROL: {
			fir(this.ptDir);
			break;
		}
		case KeyEvent.VK_A:{
			superFir();
			break;
		}
		default:
		}
		this.locateDirection();
	}

	public boolean isGood() {
		return good;
	}

	public Missile fir(Tank.Direction ptDir) {
		// TODO 自动生成的方法存根
		Missile mis = new Missile(currentX + (TANK_R - Missile.MIS_R) / 2,
				currentY + (TANK_R - Missile.MIS_R) / 2,ptDir , tc , this.good);
		this.tc.missiles.add(mis);
		return mis;
	}

	public void superFir(){
		Direction [] dirs = Direction.values();
		for(int i=0;i<dirs.length-1;i++){
			fir(dirs[i]);
		}
	}
	public void locateDirection() {
		if (!bL && !bU && !bR && !bD) {
			dir = Direction.STOP;
		} else if (bL && !bU && !bR && !bD) {
			dir = Direction.L;
		} else if (bL && bU && !bR && !bD) {
			dir = Direction.LU;
		} else if (!bL && bU && !bR && !bD) {
			dir = Direction.U;
		} else if (!bL && bU && bR && !bD) {
			dir = Direction.RU;
		} else if (!bL && !bU && bR && !bD) {
			dir = Direction.R;
		} else if (!bL && !bU && bR && bD) {
			dir = Direction.RD;
		} else if (!bL && !bU && !bR && bD) {
			dir = Direction.D;
		} else if (bL && !bU && !bR && bD) {
			dir = Direction.LD;
		}
	}

	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public boolean collidesWithWall(Wall w){
		if(this.live && this.getRect().intersects(w.getRect())){
//			this.dir = Direction.STOP;
			stay();
			return true;
		}
		return false;
	}

	/**
	 * 
	 */
	public void stay() {
		this.currentX = this.oldX;
		this.currentY = this.oldY;
	}
	public static Tank getGoodTank(){
		return new Tank(700, 500, true, tc);
	}
	
	public boolean collidesWithTanks(List<Tank> tanks){
		for(int i=0;i<tanks.size();i++){
			Tank t = tanks.get(i);
			if(this != t && this.live && t.isLive() && this.getRect().intersects(t.getRect())){
				this.stay();
				t.stay();
				return true;
			}
		}
		
		return false;
	}
}