package cn.itcast.list.demo;


public class LinkedTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		QueueLink q = new QueueLink();
		q.input("abc1");
		q.input("abc2");
		q.input("abc3");
		q.input("abc4");
		System.out.println(q.getFont());
		System.out.println(q.getRear());
		while(!q.isEmpty()){
			System.out.println(q.out());
		}
	}
	
}
