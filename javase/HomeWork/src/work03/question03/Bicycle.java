package work03.question03;
public class Bicycle {
//�����ǣ���Ʒ�ơ���ɫ��
	private int number;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Bicycle(int number, String color) {
		super();
		this.number = number;
		this.color = color;
	}
	private String color;
	public void start(){
		System.out.println("����");
	}
	public void stop(){
		System.out.println("ͣ��");
	}
}
