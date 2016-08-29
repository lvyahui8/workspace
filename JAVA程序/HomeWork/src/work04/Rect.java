package work04;

public class Rect extends AbstractShape{
	private double length;
	private double width;
	
	public Rect(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}

	@Override
	protected void calculateArea() {
		super.setArea(length * width);
	}

	@Override
	protected void calculatePerimeter() {
		super.setPerimeter((length + width)*2);
	}

}
