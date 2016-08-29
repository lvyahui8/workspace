package cn.itcast.set.demo;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		HashSet hs = new HashSet();
		
		hs.add("sd1");
		hs.add("sd2");
		hs.add("sd3");
		hs.add("sd4");
		hs.add("sd1");
		hs.add("sd2");
		hs.add("sd3");
		hs.add("sd4");
		for(Iterator it = hs.iterator();it.hasNext();){
			System.out.println(it.next());
		}
	}

}
