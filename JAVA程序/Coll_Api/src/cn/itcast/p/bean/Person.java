package cn.itcast.p.bean;

public class Person implements Comparable{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person(){
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		// TODO 自动生成的方法存根
		System.out.println("hashCode");
		return name.hashCode()+this.age*3;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO 自动生成的方法存根
		System.out.println("equals");
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Person)) {
			throw new ClassCastException("类型错误");
		}
		return this.name == ((Person)obj).name && this.age == ((Person)obj).age;
	}
	
	public String toString(){
		return name+"...toString..."+age;
	}

	@Override
	public int compareTo(Object o) {
		// TODO 自动生成的方法存根
		if (!(o instanceof Person)) {
			throw new ClassCastException();
		}
		
		Person p = (Person)o;
		
//		if (this.age>p.age) {
//			return -1;
//		}
//		else if (this.age<p.age) {
//			return 1;
//		}
//		else{
//			return this.name.compareTo(p.name);
//		}
		int temp = this.age - p.age;
		return 0==temp ? this.name.compareTo(p.name) : temp;
	}
	
}
