package cn.itcast.generic.demo;

import java.util.Iterator;
import java.util.TreeSet;

import cn.itcast.p.bean.Person;

public class GenericDemo2 {

	public static void main(String[] args) {
		TreeSet<Person> ts = new TreeSet<Person>();
		
		ts.add(new Person("kk_1",1));
		ts.add(new Person("kk_2",2));
		ts.add(new Person("kk_3",3));
		ts.add(new Person("kk_4",4));
		ts.add(new Person("kk_5",5));
		
		Iterator<Person> it = ts.iterator();
		
		while (it.hasNext()) {
			Person person = it.next();
			System.out.println(person);
		}
	}

}
