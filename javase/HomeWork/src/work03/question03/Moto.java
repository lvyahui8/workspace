package work03.question03;

public class Moto extends Bicycle {

	public Moto(int number, String color) {
		super(number, color);
	}

	public void travel(){
		System.out.println("���г���ʻ��");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			//
			e.printStackTrace();
		}
	}
}
