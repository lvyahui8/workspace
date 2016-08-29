package cn.upgrade;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	public static void main(String[] args) {
		demo_2();
	}

	//定时器演示
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
		//因为线程池的大小可变，可以多个被进行，某个任务完了，就会被删除
		System.out.println("10 个任务提交完了");
	}

	public static void demo_1() {
		ExecutorService threadPool =  Executors.newFixedThreadPool(3);//新建一个固定的线程池，池中可以放3 个线程
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
		//因为线程池的大小为3，所以每次只有3个任务被进行，某个任务完了，就补充一个进来
		System.out.println("10 个任务提交完了");
		threadPool.shutdown();//保证任务完成之后结束程序
//		threadPool.shutdownNow();//立马结束池中线程
	}

}
