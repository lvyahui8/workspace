package ×÷ÒµËÄ;

abstract class Shape {
	private double area;
	private double perimeter;

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}

	abstract void calculateArea();

	abstract void calculatePerimeter();
}

class Circle extends Shape {
	private double r;

	Circle() {
	}

	Circle(double r0) {
		super();
		this.r = r0;
	}

	@Override
	void calculateArea() {
		this.setArea(3.14 * r * r);
	}

	@Override
	void calculatePerimeter() {
		this.setPerimeter(2 * 3.14 * r);
	}

}

class Rect extends Shape {
	Rect() {
	}

	private double x, y;

	Rect(double x0, double y0) {
		super();
		this.x = x0;
		this.y = y0;
		// TODO Auto-generated constructor stub
	}

	@Override
	void calculateArea() {
		this.setArea(x * y);
	}

	@Override
	void calculatePerimeter() {
		this.setPerimeter((x + y) * 2);
	}

}

class Square extends Rect {
	private double x;

	Square() {
	}

	Square(double x0) {
		super();
		this.x = x0;
	}

	@Override
	void calculateArea() {
		this.setArea(x * x);
	}

	@Override
	void calculatePerimeter() {
		this.setPerimeter(4 * x);
	}

}

public class Qz {

	public void main(String[] args) {
		Shape[] s = new Shape[3];
		s[0] = new Rect(6, 3);
		s[1] = new Circle(5);
		s[2] = new Square(6);
		// Shape shape = new MyRectangle(10, 20);
		s[0].calculateArea();
		s[0].calculatePerimeter();
		System.out.println(s[0].getArea());
		System.out.println(s[0].getPerimeter());
		s[1].calculateArea();
		s[1].calculatePerimeter();
		System.out.println(s[1].getArea());
		System.out.println(s[1].getPerimeter());
		s[2].calculateArea();
		s[2].calculatePerimeter();
		System.out.println(s[2].getArea());
		System.out.println(s[2].getPerimeter());
	}
}