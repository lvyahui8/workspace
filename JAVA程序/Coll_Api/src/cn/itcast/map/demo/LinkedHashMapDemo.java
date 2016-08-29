package cn.itcast.map.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		HashMap<Integer,String> hm = new LinkedHashMap<Integer,String>();
		hm.put(8, "nihao_1");
		hm.put(11, "nihao_4");
		hm.put(9, "nihao_2");
		hm.put(10, "nihao_3");
		
		for (Iterator<Map.Entry<Integer,String>>iterator = hm.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<Integer, String> me = iterator.next();
			System.out.println(me.getKey()+"..."+me.getValue());
		}
	}

}
