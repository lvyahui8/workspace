package work04;

public class Question04Test {

	public static void main(String[] args) {
		
		AbstractShape [] shapes = {
			new Rect(10.0, 20.0),
			new Square(20.0),
			new Circle(5.0)
		};
		
		printGeometryInfo(shapes);
	}

	private static void printGeometryInfo(AbstractShape[] shapes) {
		for (int i = 0; i < shapes.length; i++) {
			AbstractShape shape = shapes[i];
			System.out.println(shape.getArea());
			System.out.println(shape.getPerimeter());
		}
	}

}
