/**
 * 
 */
package cn.itcast.list.demo;

import java.util.ArrayList;
import java.util.Iterator;

import cn.itcast.p.bean.Person;

/**
 * @author Agrin
 *
 */
public class ArrayListTest_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		singleDemo();
		ArrayList arr1 = new ArrayList();
		arr1.add(new Person("ll-1", 21));
		arr1.add(new Person("ll-2", 22));
		arr1.add(new Person("ll-3", 23));
		arr1.add(new Person("ll-4", 24));
		arr1.add(new Person("ll-3", 23));
		arr1.add(new Person("ll-4", 24));
		singleDemo_2(arr1);
	}

	public static void singleDemo_2(ArrayList arr) {
		// TODO 自动生成的方法存根
		System.out.println(arr);
		arr = getSingleElement(arr);
		System.out.println(arr);	
	}

	/**
	 * 
	 */
	private static void singleDemo() {
		ArrayList arr = new ArrayList();
		arr.add("ab1");
		arr.add("ab2");
		arr.add("ab3");
		arr.add("ab2");
		arr.add("ab5");
		System.out.println(arr);
		arr = getSingleElement(arr);
		System.out.println(arr);		
	}

	public static ArrayList getSingleElement(ArrayList arr) {
		// TODO 自动生成的方法存根
		ArrayList temp = new ArrayList();
		
		for(Iterator it = arr.iterator();it.hasNext();){
			Object  obj = it.next();
			
			if (!temp.contains(obj)) {
				temp.add(obj);
			}
		}
		
		return temp;
	}

}
