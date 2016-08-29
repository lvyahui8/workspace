package cn.itcast.commons.test;

public class Person {
	String pid;
	String name;
	int age;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
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
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
