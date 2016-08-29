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
		 * KeySet������ʾ
		 * ��ͨ��KeySet������ȡ����Key��ͨ��get(key)�������ֵ
		 */
		Set<Integer> keySet = map.keySet();
		
		for (Iterator<Integer> iterator = keySet.iterator(); iterator.hasNext();) {
			Integer key =  iterator.next();
			String value = map.get(key);
			System.out.println(key+".."+value);
		}
		/*
		 * entrySet������ʾ
		 * �÷���������ֵ��ӳ���ϵ��Ϊ����洢 ��Map.Entry������
		 */
		Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
		
		for (Iterator<Map.Entry<Integer,String>> iterator = entrySet.iterator(); iterator.hasNext();) {
			Map.Entry<Integer, String> entry =  iterator.next();
			System.out.println(entry.getKey()+"....."+entry.getValue());
		}
		/*
		 * values������ʾ
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
	/*ʡ��public static */interface MyEntry{//�ڲ��ӿ�
		void method();
	}
}

class imp implements MyMap.MyEntry{

	@Override
	public void method() {
		// TODO �Զ����ɵķ������
		
	}
	
}
class Outer{
	static class Inner{
		void show(){
			
		}
	}
}
