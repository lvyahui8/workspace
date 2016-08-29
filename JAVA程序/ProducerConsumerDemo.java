/*
多生产者，多消费者问题
if		判断标记：值判断一次，会导致不该进行的线程进行了，出现了数据紊乱错误
while	判断标记：解决了线程获取执行权之后，是否真的需要执行
notify		只唤醒一个线程，如果本方唤醒本方，没有意义，而且如果在while判断标记中，可能会出现死锁。
notifyAll	解决了，本反线程一定会唤醒对方线程
*/
class Resource {
    private String name;
	private int count;
	private boolean flag = false;
	public synchronized void set(String name){
		while (this.flag) {		//换成while  某个线程醒来之后会再一次判断标记。因为在次线程等待期间，有其他线程hi修改标记。
		    try{this.wait();}catch(InterruptedException e){}
		}
		this.name = count+name;
		count++;
		System.out.println(Thread.currentThread().getName()+"  &&&&Produ&&&&  "+this.name);
		this.flag = true;
		this.notifyAll();		//	唤醒this线程池中所有线程。保证每次必定唤醒一个对方线程，防止出现死锁。
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
		    r.set("绝味");
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
