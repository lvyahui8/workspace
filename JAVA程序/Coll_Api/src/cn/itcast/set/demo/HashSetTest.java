package cn.itcast.set.demo;

import java.util.HashSet;
import java.util.Iterator;

import cn.itcast.p.bean.Person;

public class HashSetTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		HashSet hs = new HashSet();
		/*
		 * HashSet集合数据结构是哈希表
		 * 使用元素的hashCode方法来确定位置，位置相同会调用equals方法来确定是否相同
		 * 所以要保证自定义对象不同年，需要重写hashCode  equals方法
		 */
		hs.add(new Person("yi1",11));
		hs.add(new Person("yi4",14));
		hs.add(new Person("yi3",13));
		hs.add(new Person("yi4",14));
		
		for(Iterator it = hs.iterator();it.hasNext();){
			Person p = (Person)it.next();
			System.out.println(p.getName()+"..."+p.getAge());
		}
	}

}
