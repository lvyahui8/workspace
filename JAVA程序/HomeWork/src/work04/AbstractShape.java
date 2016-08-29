package work04;

public abstract class AbstractShape {
	private double area;
	private double perimeter;
	
	public double getArea() {
		if(0.0 == this.area){
			this.calculateArea();
		}
		return area;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	public double getPerimeter() {
		if(0.0 == this.perimeter){
			this.calculatePerimeter();
		}
		return perimeter;
	}
	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
	//抽象方法，具体图形给出具体计算方法
	abstract protected void calculateArea();
	abstract protected void calculatePerimeter();
}
