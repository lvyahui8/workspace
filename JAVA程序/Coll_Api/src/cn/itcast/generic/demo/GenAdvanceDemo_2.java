package cn.itcast.generic.demo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import cn.itcast.p.bean.Person;

public class GenAdvanceDemo_2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TreeSet<Worker> arr_3 = new TreeSet<Worker>();
		
		arr_3.add(new Worker("liLy1",11));
		arr_3.add(new Worker("liLy2",12));
		arr_3.add(new Worker("liLy3",13));
		

		TreeSet<Student> arr_4 = new TreeSet<Student>(new CompByName());
		
		arr_4.add(new Student("kk2",22));
		arr_4.add(new Student("zk1",21));
		arr_4.add(new Student("kk3",23));
		
		TreeSet<Person> arr_5 = new TreeSet<Person>(new CompByName());
		
		arr_5.add(new Person("nih1",21));
		arr_5.add(new Person("nih2",23));
		arr_5.add(new Person("nih3",22));
		arr_5.addAll(arr_4);
		for (Iterator<Person>iterator = arr_5.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}
}

/*
 * class TreeSet<E>{
 * 		Tree(Comparator<? super E> comp);
 *		什么时候使用下限，通常对集合中的元素进行取出操作。
 * }
 */
class CompByName implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO 自动生成的方法存根
		int temp = o1.getName().compareTo(o2.getName());
		return 0 == temp ? o1.getAge() - o2.getAge() : temp;
	}
	
}

class CompByStuName implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO 自动生成的方法存根
		int temp = o1.getName().compareTo(o2.getName());
		return 0 == temp ? o1.getAge() - o2.getAge() : temp;
	}
	
}
