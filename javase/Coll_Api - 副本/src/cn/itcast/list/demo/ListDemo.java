package cn.itcast.list.demo;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		List list = new ArrayList();
		show(list);
	}

	public static void show(List list) {
		// TODO �Զ����ɵķ������
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");
		
		System.out.println(list);
		//	����Ԫ��
		list.add(1,"abc7");
		
		System.out.println(list);
		//	ɾ��Ԫ��
		System.out.println("remove:"+list.remove(3));
		
		//	��ȡԪ��
		
		System.out.println("element:"+list.get(2));
		
		System.out.println(list);
	}

}
