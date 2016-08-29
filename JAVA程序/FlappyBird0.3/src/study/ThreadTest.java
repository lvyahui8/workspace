package study;

/*
 * Java�����̵߳ķ�ʽ��2�֡�
 * 1���̳�Thread�࣬����run����
 * 
 * 2��ʵ��Runnable�ӿ�
 */

class MyThread01 extends Thread{

	@Override
	public void run() {
		//�߳�����
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("���߳�");
		}
	}
	
}

class MyTask implements Runnable{

	@Override
	public void run() {
		// �߳�����
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("���߳�");
		}
	}
	
}
public class ThreadTest {

	public static void main(String[] args) {
		
//		new MyThread01().start();//������һ�����߳�
		
		new Thread(new MyTask()).start();//�ڶ��ֿ����̵߳ķ���
		
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("���߳�");
		}
	}

}

/*
class Thread  implements Runnable{

	Runnable target = null;
	
	public Thread(){
	}
	
	public Thread(Runnable target){
		this.target = target;
	}
	
	@Override
	public void run() {
		if(target!=null){
			target.run();
		}
	}
	
	public void start(){
		//.......
		run();
		//........
	}
	//...
}
*/