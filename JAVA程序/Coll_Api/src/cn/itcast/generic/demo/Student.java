package cn.itcast.generic.demo;

import cn.itcast.p.bean.Person;

public class Student extends Person {

	public Student(String name, int age) {
		super(name, age);
		// TODO 自动生成的构造函数存根
	}

	public Student() {
		super();
		// TODO 自动生成的构造函数存根
	}
	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return this.getName()+"..学生.."+this.getAge();
	}
}
