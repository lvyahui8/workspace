/*
	ͬ��������������this��
	����������ͬ��������ͬ������ʹ��ͬһ�������������Ա���һЩ��ȫ���⡣

	��̬ͬ����������������ص��ڴ�ʱ��.class��������ʱ����
*/


class Ticket implements Runnable{//extends Thread{
    private static int num = 100;
	boolean flag = true;
	public  void run(){
		if (flag) {
		    while(true){
//				synchronized(this.getClass()){	//	Ticket.class��	// ���.class���������һ�ַ�����
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
