package cn.itcast.set.demo;

import java.util.HashSet;
import java.util.Iterator;

import cn.itcast.p.bean.Person;

public class HashSetTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		HashSet hs = new HashSet();
		/*
		 * HashSet�������ݽṹ�ǹ�ϣ��
		 * ʹ��Ԫ�ص�hashCode������ȷ��λ�ã�λ����ͬ�����equals������ȷ���Ƿ���ͬ
		 * ����Ҫ��֤�Զ������ͬ�꣬��Ҫ��дhashCode  equals����
		 */
		hs.add(new Person("yi1",11));
		hs.add(new Person("yi4",14));
		hs.add(new Person("yi3",13));
		hs.add(new Person("yi4",14));
		
		for(Iterator it = hs.iterator();it.hasNext();){
			Person p = (Person)it.next();
			System.out.println(p.getName()+"..."+p.getAge());
		}
	}

}
