import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

import static java.util.Collections.sort;//��̬�������������о�̬������ ����̬�������߾�̬������

//import static java.lang.System.out;//����������������Ϊprintln���Ǿ�̬�ģ�����Ҫ����
import static java.lang.System.*;	//	��������һ��out�Ķ���
// 1.5��������ԣ���̬����
public class StaticImportDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		List<String> list = new ArrayList<String>();
		
		list.add("list_1");
		list.add("list_2");
		list.add("list_3");
		list.add("list_4");
		
		out.println(list);
		
		sort(list);
		
		out.println(list);
	}

}
