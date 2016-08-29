package work08.question01;

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

	public Student(String sNO, String sName, String sSex, String sAge) {
		super();
		this.sNO = sNO;
		this.sName = sName;
		this.sSex = sSex;
		this.sAge = sAge;
	}
	
	String sNO;
	String sName;
	String sSex;
	String sAge;

	@Override
	public String toString() {	
		return "["+this.sNO+" "+this.sName+" "+this.sSex+"  "+this.sAge+"]";
	}
	@Override
	public int hashCode() {
System.out.println("调用了对象:"+toString()+"的hashCode方法检验重复性");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sAge == null) ? 0 : sAge.hashCode());
		result = prime * result + ((sNO == null) ? 0 : sNO.hashCode());
		//result = prime * result + ((sName == null) ? 0 : sName.hashCode());
		result = prime * result + ((sSex == null) ? 0 : sSex.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
System.out.println("调用了对象:"+toString()+"的equals方法检验重复性");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (sAge == null) {
			if (other.sAge != null)
				return false;
		} else if (!sAge.equals(other.sAge))
			return false;
		if (sNO == null) {
			if (other.sNO != null)
				return false;
		} else if (!sNO.equals(other.sNO))
			return false;
		if (sName == null) {
			if (other.sName != null)
				return false;
		} else if (!sName.equals(other.sName))
			return false;
		if (sSex == null) {
			if (other.sSex != null)
				return false;
		} else if (!sSex.equals(other.sSex))
			return false;
		return true;
	}
	
	
}
