

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ForEachDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		List list = new ArrayList();
		list.add("ab1");
		list.add("ab2");
		list.add("ab3");
		show(list);
	}

	private static void show(Collection coll) {
		// TODO 自动生成的方法存根
		//	forEach循环，可以循环数组和集合
		for(Object obj : coll){
			System.out.println(obj);
		}
	}

}
