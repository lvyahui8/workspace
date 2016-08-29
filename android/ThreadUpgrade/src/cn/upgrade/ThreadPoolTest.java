package cn.upgrade;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	public static void main(String[] args) {
		demo_2();
	}

	//��ʱ����ʾ
	public static void demo_3() {
		
		Executors.newScheduledThreadPool(3).schedule(new Runnable(){
			public void run(){
				for(int j = 0;j<10;j++){
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+ " : "+j +" run ");
				}
			}
		}, 2, TimeUnit.SECONDS);
		
	}

	public static void demo_2() {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			final int task = i ;
			threadPool.execute(new Runnable(){
				public void run(){
					for(int j = 0;j<10;j++){
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+ " : "+j +" run "+ task);
					}
				}
			});
		}
		//��Ϊ�̳߳صĴ�С�ɱ䣬���Զ�������У�ĳ���������ˣ��ͻᱻɾ��
		System.out.println("10 �������ύ����");
	}

	public static void demo_1() {
		ExecutorService threadPool =  Executors.newFixedThreadPool(3);//�½�һ���̶����̳߳أ����п��Է�3 ���߳�
		for(int i=0;i<10;i++){
			final int task = i ;
			threadPool.execute(new Runnable(){
				public void run(){
					for(int j = 0;j<10;j++){
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+ " : "+j +" run "+ task);
					}
				}
			});
		}
		//��Ϊ�̳߳صĴ�СΪ3������ÿ��ֻ��3�����񱻽��У�ĳ���������ˣ��Ͳ���һ������
		System.out.println("10 �������ύ����");
		threadPool.shutdown();//��֤�������֮���������
//		threadPool.shutdownNow();//������������߳�
	}

}
