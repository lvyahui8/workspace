package cn.itcast.collection.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class InteratorDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Collection coll = new ArrayList();
		
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		coll.add("abc4");
		
		//	使用Collection的iterator()方法。获取迭代器中的对象
		
//		Iterator  it = coll.iterator();
//		
//		while(it.hasNext()){	//先判断迭代器中是否还有元素
//			System.out.println(it.next());
//		}
//		System.out.println(it);
		//	上一种循环之后it还在占用内存，下面改用for循环
		for(Iterator it = coll.iterator();it.hasNext(); ){
			System.out.println(it.next());
		}

		System.out.println(coll);
	}
}
