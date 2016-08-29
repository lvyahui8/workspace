package day02;

public class Test extends Thread implements Runnable , Cloneable{
	int a;
	int b;
	int d;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	@Override
	public String toString() {
		return "Test [a=" + a + ", b=" + b + ", d=" + d + "]";
	}
	public Test(int a) {
		super();
		this.a = a;
	}
	public Test(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	public Test(int a, int b, int d) {
		super();
		this.a = a;
		this.b = b;
		this.d = d;
	}
	
	//HashSet
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + d;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (d != other.d)
			return false;
		return true;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}	
	
	
}
