package cn.itcast.list.demo;
import java.util.LinkedList;

public class QueueLink{
	private LinkedList link;
	 
	public QueueLink() {
		// TODO �Զ����ɵĹ��캯�����
		link = new LinkedList();
	}
	/**
	 * ���е����Ԫ�صĹ���
	 * @param obj
	 */
	public void input(Object obj){
		link.addFirst(obj);
	}
	
	public Object getFont(){
		return link.getLast();
	}
	
	public Object getRear(){
		return link.getFirst();
	}
	public boolean isEmpty(){
		return link.isEmpty();
	}
	
	public Object out(){
		return link.removeLast();
	}
}

