/*
	ͬ��������������this��
	����������ͬ��������ͬ������ʹ��ͬһ�������������Ա���һЩ��ȫ���⡣

	��̬ͬ����������������ص��ڴ�ʱ��.class��������ʱ����
	����Ƕ��ʹ��������ɽ�������
*/


class Ticket implements Runnable{//extends Thread{
    private static int num = 1000;
	boolean flag = true;
	Object obj = new Object();
	public  void run(){
		if (flag) {
		    while(true){
//				synchronized(this.getClass()){	//	Ticket.class��	// ���.class���������һ�ַ�����
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
