/*
	同步函数的锁就是this。
	可以做到让同步代码块和同步函数使用同一把锁，这样可以避免一些安全问题。

	静态同步函数的锁是类加载到内存时的.class对象（运行时对象）
	锁的嵌套使用容易造成进程死锁
*/


class Ticket implements Runnable{//extends Thread{
    private static int num = 1000;
	boolean flag = true;
	Object obj = new Object();
	public  void run(){
		if (flag) {
		    while(true){
//				synchronized(this.getClass()){	//	Ticket.class；	// 或得.class对象的另外一种方法。
				synchronized(obj){
					this.show();
				}
			}
		}
		else {
		    while (true) {
		        this.show();
		    }
		}
	}
//	private static synchronized boolean show(){
	private synchronized void show(){
		synchronized(obj){
			if (num>0) {
				try {
					Thread.sleep(10);
				}
				catch (Exception ex) {
				}
				System.out.println(Thread.currentThread().getName()+".......sale"+num--);
			}
		}
	}
}
class DeadLockDemo 
{
	public static void main(String[] args) 
	{
		Ticket	t	=	new	Ticket();
		Thread	t1	=	new	Thread(t);
		Thread	t2	=	new	Thread(t);
		t1.start();
		try {
			Thread.sleep(10);
		}
		catch (Exception ex) {
		}
		t.flag = false;
		t2.start();
	}
}
