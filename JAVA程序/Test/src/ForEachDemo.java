

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ForEachDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		List list = new ArrayList();
		list.add("ab1");
		list.add("ab2");
		list.add("ab3");
		show(list);
	}

	private static void show(Collection coll) {
		// TODO �Զ����ɵķ������
		//	forEachѭ��������ѭ������ͼ���
		for(Object obj : coll){
			System.out.println(obj);
		}
	}

}
