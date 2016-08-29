/*
等待/唤醒机制。
涉及方法

1.wait();		//	让线程处于冻结状态，被wait的线程会被存储到线程池中，线程池有很多个，用对应的锁来区分。
2.notify();		//	用于唤醒线程池中的一个线程(任意)。
3.notifyAll();	//	唤醒线程池中的所有线程（让所有线程具备CPU的执行资格）；

//	这些方法都必须用于同步中
//	因为这些都是用于操作线程状态的方法
//	必须要明确到底操作的是哪个锁上的线程，即，把必须要这样用   锁.wait();,锁.notify();,锁.notifyAll();
*/
class  Resource {
    private String	name;
	private String	sex;
	boolean	flag = false;
	private static final Resource s = new Resource();
	private Resource(){}
	public static Resource getInstance(){
		return s;
	}

	public synchronized void set(String name,String sex){
		if (this.flag) {
				//	锁.wait();(监视器.wait(),所以wait也是一种监视器方法)
			try{this.wait();}catch(InterruptedException e){}
		}
		this.name = name;
		this.sex  = sex;
		this.flag = true;
		this.notify();
	}
	public synchronized void outInfo(){
		if (!this.flag){
			try{this.wait();}catch(Exception e){}
		}
		System.out.println(this.name+" # "+this.sex);
		this.flag = false;
		this.notify();
	}

}

class Input implements Runnable{
	Resource r = Resource.getInstance();
    public void run(){
		int	x	=	0;
		while (true) {
			if (0 == x) {
				r.set("张三","男");
			}
			else {
				r.set("李四","女****");
			}
			x = (x+1)%2;
		}
	}
}

class Output implements Runnable{
	Resource r = Resource.getInstance();
    public void run(){
		while (true) {
			r.outInfo();
		}
	}
}

class  ResourceDemo
{
	public static void main(String[] args) 
	{
		Input	in	=	new Input();
		Output	out	=	new	Output();

		Thread	t1	=	new	Thread(in);
		Thread	t2	=	new	Thread(out);

		t1.start();
		t2.start();
	}
}
