import java.awt.Color;
import java.awt.Graphics;

public class Explode {
	Car data = new Car(true, new int[] { 4, 7, 12, 18, 26, 32, 49, 30, 14, 6 }, 0);

	public Explode(int currentX, int currentY, TankClient tc) {
		this.data.setCurrentX(currentX);
		this.data.setCurrentY(currentY);
		this.data.setTc(tc);
	}

	public void draw(Graphics g){
		if(data.getStep() == data.getDiameter().length){
			data.setStep(0);
			data.setLive(false);
		}
		if(!data.isLive()){
			data.getTc().explodes.remove(this);
			return;
		}
		Color oldColor = g.getColor();
		g.setColor(Color.ORANGE);
		g.fillOval(data.getCurrentX()-data.getDiameter()[data.getStep()]/2, data.getCurrentY()-data.getDiameter()[data.getStep()]/2, data.getDiameter()[data.getStep()], data.getDiameter()[data.getStep()]);
		data.setStep(data.getStep() + 1);
		g.setColor(oldColor);
	}
}
