package cn.itcast.generic.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import cn.itcast.p.bean.Person;

public class GenAdvanceDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
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
//	Collection<Person> arr = new Collection<Worker>();//这样是不行的，泛型要保持一致，有继承关系也不行。
	/*
	 * ? extends E  :  上限    表示可以接受所有E，或继承于E的对象，？是E的子类。一般用于存元素
	 * ? super E  :    下限   表示可以接受所有E，或者派生出E的对象，E是？的子类。一般用于
	 */
/*	private static void interatorCollection(Collection<? extends Person> arr) {   
		// TODO 自动生成的方法存根			//			这叫泛型的限定，且是上限
		for (Iterator<? extends Person>iterator = arr.iterator(); iterator.hasNext();) {
			Person p = iterator.next();
			System.out.println(p.getName()+"..."+p.getAge());
//			? it = iterator.next();//这样不行
		}
	}*/
	private static void interatorCollection(Collection<? super Student> arr) {   
		// TODO 自动生成的方法存根			//			这叫泛型的限定，且是下限
		for (Iterator<? super Student>iterator = arr.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
//			? it = iterator.next();//这样不行
		}
	}
	
/*	private static void interatorCollection(Collection<?通配符，未知类型> arr) {
		// TODO 自动生成的方法存根
		for (Iterator<?>iterator = arr.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
//			? it = iterator.next();//这样不行
		}
	}
*/
	
//	private static <T> void interatorCollection(Collection<T> coll) {
//		for (Iterator<T>iterator = coll.iterator(); iterator.hasNext();) {
//			System.out.println(iterator.next());
//			T it = iterator.next();//这样是可以的
//		}
//	}

}


class MyCollection<E>{
	public void add(E e){
		
	}
	public void addAll(MyCollection<? extends E> coll){
		
	}
}
