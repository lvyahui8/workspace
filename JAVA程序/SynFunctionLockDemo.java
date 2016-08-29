/*
	同步函数的锁就是this。
	可以做到让同步代码块和同步函数使用同一把锁，这样可以避免一些安全问题。

	静态同步函数的锁是类加载到内存时的.class对象（运行时对象）
*/


class Ticket implements Runnable{//extends Thread{
    private static int num = 100;
	boolean flag = true;
	public  void run(){
		if (flag) {
		    while(true){
//				synchronized(this.getClass()){	//	Ticket.class；	// 或得.class对象的另外一种方法。
				synchronized(this){
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
		else {
		    while (true) {
		        this.show();
		    }
		}
	}
//	private static synchronized boolean show(){
	private synchronized boolean show(){
		if (num>0) {
			try {
				Thread.sleep(10);
			}
			catch (Exception ex) {
			}
			System.out.println(Thread.currentThread().getName()+".......sale"+num--);
			return true;
		}
		else {
		    return false;
		}
	}
}

class SynFunctionLockDemo 
{
	public static void main(String[] args) 
	{
		Ticket	t	=	new	Ticket();
		Thread	t1	=	new	Thread(t);
		Thread	t2	=	new	Thread(t);
//		Thread	t3	=	new	Thread(t);
//		Thread	t4	=	new	Thread(t);
		t1.start();
		try {
			Thread.sleep(10);
		}
		catch (Exception ex) {
		}
		t.flag = false;
		t2.start();
//		t3.start();
//		t4.start();

	}
}
