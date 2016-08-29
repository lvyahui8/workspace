package study;

/*
 * Java开启线程的方式，2种。
 * 1、继承Thread类，覆盖run方法
 * 
 * 2、实现Runnable接口
 */

class MyThread01 extends Thread{

	@Override
	public void run() {
		//线程任务
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("子线程");
		}
	}
	
}

class MyTask implements Runnable{

	@Override
	public void run() {
		// 线程任务
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("子线程");
		}
	}
	
}
public class ThreadTest {

	public static void main(String[] args) {
		
//		new MyThread01().start();//开启了一个子线程
		
		new Thread(new MyTask()).start();//第二种开启线程的方法
		
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("主线程");
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