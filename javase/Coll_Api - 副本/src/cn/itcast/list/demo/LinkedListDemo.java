package cn.itcast.list.demo;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		LinkedList link = new LinkedList();
		link.addFirst("abc1");
		link.addFirst("abc2");
		link.addFirst("abc3");
		link.addFirst("abc4");
//		System.out.println(link);
//		System.out.println(link.getFirst());//��ȡͷ����ɾ��
//		System.out.println(link.getFirst());
		
//		System.out.println(link.removeFirst());//ȡͷɾ��
//		System.out.println(link.removeFirst());
		
		for(;!link.isEmpty();){
			System.out.println(link.removeFirst());//ȡɾ
		}
//		for(Iterator it = link.iterator();it.hasNext();){
//			System.out.println(it.next());
//		}
	}

}
