package cn.upgrade;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	
	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();

	final Object[] items = new Object[100];
	int putptr, takeptr, count;

	public void put(Object x) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length)
				notFull.await();
			items[putptr] = x;
			if (++putptr == items.length)
				putptr = 0;
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public Object take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0)
				notEmpty.await();
			Object x = items[takeptr];
			if (++takeptr == items.length)
				takeptr = 0;
			--count;
			notFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final LockTest lt = new LockTest();
		new Thread(put(lt),"生产线程1").start();
		new Thread(put(lt),"生产线程2").start();
		new Thread(get(lt),"消费线程1").start();
		new Thread(get(lt),"消费线程2").start();
		
	}

	private static Runnable get(final LockTest lt) {
		return new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						System.out.println(Thread.currentThread().getName()+"取得一个"+lt.take());
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		};
	}

	private static Runnable put(final LockTest lt) {
		return new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						lt.put("产品");
						System.out.println(Thread.currentThread().getName()+"生产了个产品");
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				
			}
		};
	}
}
