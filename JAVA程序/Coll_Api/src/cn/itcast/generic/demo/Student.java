package cn.itcast.generic.demo;

import cn.itcast.p.bean.Person;

public class Student extends Person {

	public Student(String name, int age) {
		super(name, age);
		// TODO �Զ����ɵĹ��캯�����
	}

	public Student() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	@Override
	public String toString() {
		// TODO �Զ����ɵķ������
		return this.getName()+"..ѧ��.."+this.getAge();
	}
}
