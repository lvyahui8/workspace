package cn.itcast.map.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer, String>();
		for (int i = 0; i < 6; i++) {
			map.put(i, "Stu_"+i);
		}
		map.put(4, "xinlp");
		System.out.println(map);
		
		System.out.println("key has 4?:"+map.containsKey(4));
		System.out.println("value has \"Stu_1\"?:"
				+map.containsValue("Stu_1"));
		/*
		 * KeySet方法演示
		 * 先通过KeySet方法获取所有Key再通过get(key)方法获得值
		 */
		Set<Integer> keySet = map.keySet();
		
		for (Iterator<Integer> iterator = keySet.iterator(); iterator.hasNext();) {
			Integer key =  iterator.next();
			String value = map.get(key);
			System.out.println(key+".."+value);
		}
		/*
		 * entrySet方法演示
		 * 该方法将键和值的映射关系作为对象存储 到Map.Entry集合中
		 */
		Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
		
		for (Iterator<Map.Entry<Integer,String>> iterator = entrySet.iterator(); iterator.hasNext();) {
			Map.Entry<Integer, String> entry =  iterator.next();
			System.out.println(entry.getKey()+"....."+entry.getValue());
		}
		/*
		 * values方法演示
		 */
		Collection<String> coll = map.values();
		for(Object obj : coll){
			System.out.println(obj);
		}
		for (Iterator<String> iterator = coll.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
//(e1.getKey()==null ? e2.getKey()==null : e1.getKey().equals(e2.getKey()))  && (e1.getValue()==null ? e2.getValue()==null : e1.getValue().equals(e2.getValue()))

	}
}
interface MyMap{
	/*省略public static */interface MyEntry{//内部接口
		void method();
	}
}

class imp implements MyMap.MyEntry{

	@Override
	public void method() {
		// TODO 自动生成的方法存根
		
	}
	
}
class Outer{
	static class Inner{
		void show(){
			
		}
	}
}
