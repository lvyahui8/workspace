package cn.itcast.list.demo;

import java.util.ArrayList;
import java.util.Iterator;

import cn.itcast.p.bean.Person;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList arr1 = new ArrayList();
		arr1.add(new Person("ll-1", 21));
		arr1.add(new Person("ll-2", 22));
		arr1.add(new Person("ll-3", 23));
		arr1.add(new Person("ll-4", 24));
		
		Iterator it = arr1.iterator();
		
		while(it.hasNext()){
//			Person p = (Person)it.next();
//			System.out.println(p.getName()+"  "+p.getAge());
			System.out.println(((Person)it.next()).getName());
			
		
		}
	}

}
