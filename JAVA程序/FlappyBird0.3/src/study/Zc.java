package study;
abstract class Shape{
	private int area;	
	private int perimeter;
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getPerimeter() {
		return perimeter;
	}
	public void setPerimeter(int perimeter) {
		this.perimeter = perimeter;
	}
	abstract void calculateArea();
	abstract void calculatePerimeter();
}

class MyRectangle extends Shape{
	private int length;	
	private int width;
	public MyRectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	@Override
	void calculateArea() {
		this.setArea(length * width);
	}
	@Override
	void calculatePerimeter() {
		this.setPerimeter((length + width)<<1);
	}
}

public class Zc {
	public static void main(String [] args){
//		Shape shape = new MyRectangle(10, 20);
//		shape.calculateArea();
//		shape.calculatePerimeter();
//		System.out.println(shape.getArea());
//		System.out.println(shape.getPerimeter());
		
		Shape [] shapes = {
				new MyRectangle(10, 20),
				new MyRound(20)
		};
		for (int i = 0; i < shapes.length; i++) {
			Shape shape = shapes[i];
			shape.calculateArea();
			shape.calculatePerimeter();
			System.out.println(shape.getArea());
			System.out.println(shape.getPerimeter());
		}
	}
}


class MyRound extends Shape{
	private int radius;

	public MyRound(int radius) {
		this.radius = radius;
	}

	@Override
	void calculateArea() {
		this.setArea(radius*radius);
	}

	@Override
	void calculatePerimeter() {
		this.setPerimeter(radius*2);
	}
	
}

