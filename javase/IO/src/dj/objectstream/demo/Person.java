package dj.objectstream.demo;

import java.io.Serializable;

public class Person implements Serializable/*给被序列化的类加入ID号，用于判断文件的对象和类文件是否是同一个版本*/{
	/*ANY-ACCESS-MODIFIER*/
	/*
	 * transient:非静态数据不想被序列化，可以用这个关键字修饰
	 */
	private static final long serialVersionUID = 9725L;//自己显示声明ID号
	transient String name = null;
	static String age = null;	// 静态成员是与对象分离的，将对象写到文件里时 ，静态成员没有写进去
	public Person() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Person(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
