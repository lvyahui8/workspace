package cn.itcast.generic.demo;

import cn.itcast.p.bean.Person;

public class Worker extends Person {

	public Worker() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}

	public Worker(String name, int age) {
		super(name, age);
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public String toString() {
		// TODO �Զ����ɵķ������
		return this.getName()+"..����.."+this.getAge();
	}

	
}
