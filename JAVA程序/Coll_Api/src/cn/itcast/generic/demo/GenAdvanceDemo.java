package cn.itcast.generic.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import cn.itcast.p.bean.Person;

public class GenAdvanceDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
/*		ArrayList<String> arr_1 = new ArrayList<String>();
		
		arr_1.add("abc1");
		arr_1.add("abc2");
		interatorCollection(arr_1);
		
		ArrayList<Integer> arr_2 = new ArrayList<Integer>();
		
		arr_2.add(2);
		arr_2.add(3);
		
		interatorCollection(arr_2);*/
		
		ArrayList<Worker> arr_3 = new ArrayList<Worker>();
		
		arr_3.add(new Worker("liLy1",11));
		arr_3.add(new Worker("liLy2",12));
		arr_3.add(new Worker("liLy3",13));
		
//		interatorCollection(arr_3);
		
		ArrayList<Student> arr_4 = new ArrayList<Student>();
		
		arr_4.add(new Student("kk1",21));
		arr_4.add(new Student("kk2",22));
		arr_4.add(new Student("kk3",23));
		
		interatorCollection(arr_4);
		
		ArrayList<Person> arr_5 = new ArrayList<Person>();
		
		arr_5.add(new Person("nih1",21));
		arr_5.add(new Person("nih2",22));
		arr_5.add(new Person("nih3",23));
		
		interatorCollection(arr_5);
	}
//	Collection<Person> arr = new Collection<Worker>();//�����ǲ��еģ�����Ҫ����һ�£��м̳й�ϵҲ���С�
	/*
	 * ? extends E  :  ����    ��ʾ���Խ�������E����̳���E�Ķ��󣬣���E�����ࡣһ�����ڴ�Ԫ��
	 * ? super E  :    ����   ��ʾ���Խ�������E������������E�Ķ���E�ǣ������ࡣһ������
	 */
/*	private static void interatorCollection(Collection<? extends Person> arr) {   
		// TODO �Զ����ɵķ������			//			��з��͵��޶�����������
		for (Iterator<? extends Person>iterator = arr.iterator(); iterator.hasNext();) {
			Person p = iterator.next();
			System.out.println(p.getName()+"..."+p.getAge());
//			? it = iterator.next();//��������
		}
	}*/
	private static void interatorCollection(Collection<? super Student> arr) {   
		// TODO �Զ����ɵķ������			//			��з��͵��޶�����������
		for (Iterator<? super Student>iterator = arr.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
//			? it = iterator.next();//��������
		}
	}
	
/*	private static void interatorCollection(Collection<?ͨ�����δ֪����> arr) {
		// TODO �Զ����ɵķ������
		for (Iterator<?>iterator = arr.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
//			? it = iterator.next();//��������
		}
	}
*/
	
//	private static <T> void interatorCollection(Collection<T> coll) {
//		for (Iterator<T>iterator = coll.iterator(); iterator.hasNext();) {
//			System.out.println(iterator.next());
//			T it = iterator.next();//�����ǿ��Ե�
//		}
//	}

}


class MyCollection<E>{
	public void add(E e){
		
	}
	public void addAll(MyCollection<? extends E> coll){
		
	}
}
