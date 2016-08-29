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
	
	//单个线程访问性能演示
	public static void efficiencyDemo() {
		long startTime = System.currentTimeMillis();
		int i ;
		for( i = 0;i<100000000;i++){
			getInstance();
		}
		long time = System.currentTimeMillis() - startTime;
		System.out.println("取得"+i+"次单例对象，耗时:"+time);
	}
	
	//多线程访问安全问题和效率演示
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
					System.out.println("线程"+task+"完成访问");
					cdAnswer.countDown();
				}
			});
		}
		
		long startTime = System.currentTimeMillis();
		System.out.println(threadCount+"个线程开始访问单例");
		cdOrder.countDown();
		try {
			cdAnswer.await();
			System.out.println(threadCount+"个线程访问单例完成，耗时"+(System.currentTimeMillis()-startTime)+"毫秒");
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		threadPool.shutdown();
	}

}
