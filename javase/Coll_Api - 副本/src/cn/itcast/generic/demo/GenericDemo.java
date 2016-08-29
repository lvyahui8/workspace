package cn.itcast.generic.demo;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ArrayList<String> arr = new ArrayList<String>();
		
		arr.add("lili_1");
		arr.add("lili_2");
		arr.add("lili_3");
		arr.add("lili_4");
//		arr.add(8);
		for (Iterator<String> iterator = arr.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		
		for(Object obj : arr){
			System.out.println(obj);
		}
	}
}
