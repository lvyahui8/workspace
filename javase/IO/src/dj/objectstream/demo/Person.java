package dj.objectstream.demo;

import java.io.Serializable;

public class Person implements Serializable/*�������л��������ID�ţ������ж��ļ��Ķ�������ļ��Ƿ���ͬһ���汾*/{
	/*ANY-ACCESS-MODIFIER*/
	/*
	 * transient:�Ǿ�̬���ݲ��뱻���л�������������ؼ�������
	 */
	private static final long serialVersionUID = 9725L;//�Լ���ʾ����ID��
	transient String name = null;
	static String age = null;	// ��̬��Ա����������ģ�������д���ļ���ʱ ����̬��Աû��д��ȥ
	public Person() {
		super();
		// TODO �Զ����ɵĹ��캯�����
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
