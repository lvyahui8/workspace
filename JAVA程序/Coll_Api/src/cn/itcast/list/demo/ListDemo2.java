package cn.itcast.list.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		List list = new ArrayList();
//		show(list);
		
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		
/*		for(Iterator it = list.iterator();it.hasNext();){
			Object obj =  it.next();// java.util.ConcurrentModificationException
			if("abc2"==obj){
				list.add("abc5");	//	�����޸��쳣���ڵ���������ʹ�ü��Ϸ����������ϣ����������ʹ�� Iterator���ӽӿ�ListIterator��
			}
			else{
				System.out.println(obj);
			}
		}*/
		ListIterator it = list.listIterator();
		//	ListIterator�ӿڷ������������ڵ��������Ĺ����в����޸ļ���
		//	ֻ��list���Ͼ��иõ�������
		for (/*ListIterator it = list.listIterator()*/; it.hasNext();) {
			Object obj = it.next();
			if (obj.equals("abc2")) {
				it.set("abc7");
			} else {
				System.out.println(obj);					
			}
		}
		System.out.println(list);
		
		//	��������������б�
		for(/*ListIterator it = list.listIterator()*/;it.hasPrevious(); ){
			System.out.println(it.previous());
		}
	}

	private static void show(List list) {
		// TODO �Զ����ɵķ������
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");
		
		for(Iterator it = list .iterator();it.hasNext();){
			System.out.println(it.next());
		}
		
	}

}
