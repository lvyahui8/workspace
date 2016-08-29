package work03.question03;
public class Bicycle {
//属性是：车品牌、颜色。
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
		System.out.println("启动");
	}
	public void stop(){
		System.out.println("停车");
	}
}
