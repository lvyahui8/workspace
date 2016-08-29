package work04;

public class Circle extends AbstractShape {
	private double radius;
	
	public static final double PI = 3.1415926535898;
	
	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	protected void calculateArea() {
		super.setArea(PI*(radius*radius));
	}

	@Override
	protected void calculatePerimeter() {
		super.setPerimeter(2*PI*radius );
	}

}
