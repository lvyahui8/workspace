package work03.question01;

public class Student {
	public String getsNO() {
		return sNO;
	}
	public String getsName() {
		return sName;
	}
	public String getsSex() {
		return sSex;
	}
	public String getsAge() {
		return sAge;
	}
	public String getsJava() {
		return sJava;
	}
	public Student(String sNO, String sName, String sSex, String sAge,
			String sJava) {
		super();
		this.sNO = sNO;
		this.sName = sName;
		this.sSex = sSex;
		this.sAge = sAge;
		this.sJava = sJava;
	}
	
	String sNO;
	String sName;
	String sSex;
	String sAge;
	String sJava;
	@Override
	public String toString() {	
		return this.sNO+" "+this.sName+" "+this.sSex+"  "+this.sAge+" "+ this.sJava;
	}
	
}
