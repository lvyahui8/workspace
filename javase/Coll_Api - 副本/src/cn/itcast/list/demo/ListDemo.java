package cn.itcast.list.demo;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		List list = new ArrayList();
		show(list);
	}

	public static void show(List list) {
		// TODO 自动生成的方法存根
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");
		
		System.out.println(list);
		//	插入元素
		list.add(1,"abc7");
		
		System.out.println(list);
		//	删除元素
		System.out.println("remove:"+list.remove(3));
		
		//	获取元素
		
		System.out.println("element:"+list.get(2));
		
		System.out.println(list);
	}

}
