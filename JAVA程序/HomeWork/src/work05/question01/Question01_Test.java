package work05.question01;

public class Question01_Test {

	public static void main(String[] args) {
		Vehicle vs [] = {
				new Car(),
				new Motorbike()
		};
		for (int i = 0; i < vs.length; i++) {
			System.out.println(vs[i].noOfWheels());
		}
	}

}
