/*
�������ߣ�������������
if		�жϱ�ǣ�ֵ�ж�һ�Σ��ᵼ�²��ý��е��߳̽����ˣ��������������Ҵ���
while	�жϱ�ǣ�������̻߳�ȡִ��Ȩ֮���Ƿ������Ҫִ��
notify		ֻ����һ���̣߳�����������ѱ�����û�����壬���������while�жϱ���У����ܻ����������
notifyAll	����ˣ������߳�һ���ỽ�ѶԷ��߳�
*/
class Resource {
    private String name;
	private int count;
	private boolean flag = false;
	public synchronized void set(String name){
		while (this.flag) {		//����while  ĳ���߳�����֮�����һ���жϱ�ǡ���Ϊ�ڴ��̵߳ȴ��ڼ䣬�������߳�hi�޸ı�ǡ�
		    try{this.wait();}catch(InterruptedException e){}
		}
		this.name = count+name;
		count++;
		System.out.println(Thread.currentThread().getName()+"  &&&&Produ&&&&  "+this.name);
		this.flag = true;
		this.notifyAll();		//	����this�̳߳��������̡߳���֤ÿ�αض�����һ���Է��̣߳���ֹ����������
	}
	public synchronized void out(){
		while (!this.flag) {
		    try{this.wait();}catch(InterruptedException e){}
		}
		System.out.println(Thread.currentThread().getName()+"  ........Consu........  "+this.name);
		this.flag = false;
		this.notifyAll();
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
class ProducerConsumerDemo 
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
