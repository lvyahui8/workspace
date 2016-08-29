/*
 * 需要写一个程序，一个线程运行十次，回到主线程运行100次，
 * 在回到那个线程运行10次，在回到主线程运行100次。如此反复
 */
package cn.traditional;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		final Lock lock = new ReentrantLock();
		final Condition subThread = lock.newCondition();
		final Condition mainThread  = lock.newCondition();
		
		Thread t = new Thread(){
			public void run(){
				int i = 0;
				while (true) {
//					synchronized (ThreadTest.class) {
						i++;
						lock.lock();
						if (i % 11 == 0) {
							i = 1;
							try {
								mainThread.signal();
								subThread.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							finally{
								lock.unlock();
							}
							
						}
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
						System.out.println("次线程执行了" + i + "次");
//					}
				}
			}
		};
		t.start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		int n = 0;
		while(true){
//			synchronized (ThreadTest.class) {
				lock.lock();
				n++;
				if(n%101 == 0){
					n = 1;
					try {
						subThread.signal();
						mainThread.await();
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					finally{
						lock.unlock();
					}
				}
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				System.out.println("主线程执行了"+n+"次");
//			}
		}
	}

}
