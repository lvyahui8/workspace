
public class Car {
	private int currentX;
	private int currentY;
	private boolean live;
	private TankClient tc;
	private int[] diameter;
	private int step;

	public Car(boolean live, int[] diameter, int step) {
		this.live = live;
		this.diameter = diameter;
		this.step = step;
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

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public TankClient getTc() {
		return tc;
	}

	public void setTc(TankClient tc) {
		this.tc = tc;
	}

	public int[] getDiameter() {
		return diameter;
	}

	public void setDiameter(int[] diameter) {
		this.diameter = diameter;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
}