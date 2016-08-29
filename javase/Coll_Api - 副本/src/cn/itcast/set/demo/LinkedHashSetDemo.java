package cn.itcast.set.demo;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		LinkedHashSet lhs = new LinkedHashSet();
		lhs.add("nih1");
		lhs.add("nih2");
		lhs.add("nih3");
		lhs.add("nih4");
		lhs.add("nih5");
		
		for(Iterator it = lhs.iterator();it.hasNext();){
			System.out.println(it.next());
		}
	}

}
