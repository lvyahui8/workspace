package cn.itcast.map.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import cn.itcast.generic.demo.Student;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		/*
		 * ��ѧ�������ѧ���Ĺ�����ͨ������ֵ�洢��map������
		 * 
		 */
		HashMap<Student,String> hm = new HashMap<Student,String>();
		hm.put(new Student("kk_1",21), "����");
		hm.put(new Student("kk_2",22), "�Ϻ�");
		hm.put(new Student("kk_3",23), "����");
		hm.put(new Student("kk_4",24), "���");
		hm.put(new Student("kk_4",24), "�¼���");
		
//		Set<Student> keySet = hm.keySet();
		
		for (Iterator<Student>iterator = hm.keySet().iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			String value = hm.get(student);
			System.out.println(student.getName()+"..."+student.getAge()+"..."+value);
			
		}
	}

}
