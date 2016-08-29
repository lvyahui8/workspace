package yuyi.model;

import java.lang.reflect.Constructor;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SingletonTest {

	public static void main(String[] args) {
//		threadSafetyDemo();
//		efficiencyDemo();
		reflectSingleDemo("yuyi.model.GeneralSluggardSingleton");
	}
	
	
	public static void reflectSingleDemo(String className) {
		try {
			Class<?> clazz = Class.forName(className);
			
			Constructor<?> con = clazz.getDeclaredConstructor((Class<?>)null);
			con.setAccessible(true);
			
			for (int i = 0; i < 10; i++) {
				con.newInstance((Object[])null);
			}
		} catch (ReflectiveOperationException  e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void getInstance(){
//		GeneralSluggardSingleton.getInstance();
		ImproveSluggardSingleton.getInstance();
	}
	
	//�����̷߳���������ʾ
	public static void efficiencyDemo() {
		long startTime = System.currentTimeMillis();
		int i ;
		for( i = 0;i<100000000;i++){
			getInstance();
		}
		long time = System.currentTimeMillis() - startTime;
		System.out.println("ȡ��"+i+"�ε������󣬺�ʱ:"+time);
	}
	
	//���̷߳��ʰ�ȫ�����Ч����ʾ
	public static void threadSafetyDemo() {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		int threadCount = 500;
		final CyclicBarrier cb = new CyclicBarrier(threadCount);
		final CountDownLatch cdOrder = new CountDownLatch(1);
		final CountDownLatch cdAnswer = new CountDownLatch(threadCount);
		
		for(int i=0;i<threadCount;i++){
			final int task = i;
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						cdOrder.await();
						Thread.sleep((long)(Math.random()*1000));
						cb.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
					getInstance();
					System.out.println("�߳�"+task+"��ɷ���");
					cdAnswer.countDown();
				}
			});
		}
		
		long startTime = System.currentTimeMillis();
		System.out.println(threadCount+"���߳̿�ʼ���ʵ���");
		cdOrder.countDown();
		try {
			cdAnswer.await();
			System.out.println(threadCount+"���̷߳��ʵ�����ɣ���ʱ"+(System.currentTimeMillis()-startTime)+"����");
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		threadPool.shutdown();
	}

}
