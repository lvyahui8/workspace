package cn.itcast.set.demo;

import java.util.Iterator;
import java.util.TreeSet;

import cn.itcast.p.bean.Person;

public class TreeSetDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//	TreeSet���Ͽ��ԶԼ����� ��Ԫ������
//		TreeSet ts = new TreeSet();
		TreeSet ts = new TreeSet(new ComparatorByName());	//	ʹ�ñȽ���
	/*	ts.add("ab2");
		ts.add("ab1");
		ts.add("ab4");
		ts.add("ab3");
		ts.add("ab5");*/
		
		ts.add(new Person("yili_1",11));
		ts.add(new Person("yili_2",12));
		ts.add(new Person("yili_3",16));
		ts.add(new Person("yili_4",14));
		ts.add(new Person("yili_5",15));
		ts.add(new Person("yili_6",16));
		ts.add(new Person("yili_7",17));
		for(Iterator it = ts.iterator();it.hasNext();){
			Person p = (Person)it.next();
			System.out.println(p.getName()+"..."+p.getAge());
		}
	}

}
