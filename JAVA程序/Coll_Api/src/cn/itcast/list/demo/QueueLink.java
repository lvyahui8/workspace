package cn.itcast.list.demo;
import java.util.LinkedList;

public class QueueLink{
	private LinkedList link;
	 
	public QueueLink() {
		// TODO 自动生成的构造函数存根
		link = new LinkedList();
	}
	/**
	 * 队列的添加元素的功能
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

