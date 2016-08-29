package cn.itcast.collection.demo;

import java.util.ArrayList;
import java.util.Collection;

public class CollMethod_1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Collection	coll	=	new	ArrayList();
//		show(coll);
		Collection	c1	=	new	ArrayList();
		Collection	c2	=	new	ArrayList();
		show(c1,c2);
	}
	public static void show(Collection c1,Collection c2){
		c1.add("ab1");
		c1.add("ab2");
		c1.add("ab3");
		
		
		c2.add("ab1");
		c2.add("ab5");
		c2.add("ab6");
		System.out.println("c1:"+c1);
		System.out.println("c2:"+c2);
		//	addAll
//		c1.addAll(c2);
//		System.out.println("c1:"+c1);
		//	removeAll
//		boolean b = c1.removeAll(c2);
//		System.out.println("b == "+b);
//		System.out.println("c1:"+c1);
		
		//	containsAll
//		boolean b = c1.containsAll(c2);
//		System.out.println("b == "+b);
//		System.out.println("c1:"+c1);
		
		//	retainAll
		boolean b = c1.retainAll(c2);
		System.out.println("c1:"+c1);
	}
	public static void show(Collection coll){
		//	1、添加元素。add。
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		coll.add("abc4");
		System.out.println(coll);
		coll.remove("abc2");	//	集合的remove方法是会改变集合的长度
		System.out.println(coll);
		System.out.println(coll.contains("abcd5"));
		coll.clear();
		System.out.println(coll);
	}
}