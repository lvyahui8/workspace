/*
JDK1.5֮��ͬ��������װ����������
��������������ʽ�������嵽������
����ʽ���������ʵ����

����������һ�����Ҷ����������

*/
import	java.util.concurrent.locks.*;
class Resource {
    private String name;
	private int count;
	private boolean flag = false;
	Lock	lock	=	new	ReentrantLock();
	Condition	consumer_con	=	lock.newCondition();
	Condition	producer_con	=	lock.newCondition();
	public  void set(String name){
		lock.lock();
		try {
		    while (this.flag) {		//	����while  ĳ���߳�����֮�����һ���жϱ�ǡ���Ϊ�ڴ��̵߳ȴ��ڼ䣬�������߳�hi�޸ı�ǡ�
				try{producer_con.await();}catch(InterruptedException e){}
			}
			this.name = count+name;
			count++;
			System.out.println(Thread.currentThread().getName()+"  &&&&Produ&&&&  "+this.name);
			this.flag = true;
			consumer_con.signal();
		}
		finally {
		    lock.unlock();
		}
	}
	public  void out(){
		lock.lock();
		try {
		    	while (!this.flag) {
				try{consumer_con.await();}catch(InterruptedException e){}
			}
			System.out.println(Thread.currentThread().getName()+"  ........Consu........  "+this.name);
			this.flag = false;
			producer_con.signalAll();
		}
		finally {
		    lock.unlock();
		}

	}
}

class Producer implements Runnable {
    private Resource r;
	Producer(Resource r){
		this.r = r;
	}
	public void run(){
		while (true) {
		    r.set("��ζ");
		}
	}

}

class Consumer implements Runnable {
    private Resource r;
	Consumer(Resource r){
		this.r = r;
	}
	public void run(){
		while (true) {
		    r.out();
		}
	}

}

class InterfaceLock 
{
	public static void main(String[] args) 
	{
		Resource	r	=	new	Resource();
		Producer	pro	=	new	Producer(r);
		Consumer	con	=	new	Consumer(r);
		Thread	t0	=	new	Thread(pro);
		Thread	t1	=	new	Thread(pro);
		Thread	t2	=	new	Thread(con);
		Thread	t3	=	new	Thread(con);
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
}
