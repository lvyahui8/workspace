package cn.itcast.collection.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class InteratorDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Collection coll = new ArrayList();
		
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		coll.add("abc4");
		
		//	ʹ��Collection��iterator()��������ȡ�������еĶ���
		
//		Iterator  it = coll.iterator();
//		
//		while(it.hasNext()){	//���жϵ��������Ƿ���Ԫ��
//			System.out.println(it.next());
//		}
//		System.out.println(it);
		//	��һ��ѭ��֮��it����ռ���ڴ棬�������forѭ��
		for(Iterator it = coll.iterator();it.hasNext(); ){
			System.out.println(it.next());
		}

		System.out.println(coll);
	}
}
