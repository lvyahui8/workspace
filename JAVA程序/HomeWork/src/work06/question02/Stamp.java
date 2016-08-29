package work06.question02;


public class Stamp {
	private int value;
	private int count;

	public Stamp() {
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	protected Stamp(int value, int count) {
		super();
		this.value = value;
		this.count = count;
	}
	

	
}