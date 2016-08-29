package com.dolu.Thread;

import java.util.concurrent.locks.*;

class BoundedBuffer {
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
//			System.out.println(Thread.currentThread().getName() + "--����--" + x);
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
//			System.out.println(Thread.currentThread().getName() + "--����-" + x);
			if (++takeptr == items.length)
				takeptr = 0;
			--count;
			notFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}
}

class Game implements Runnable {
	private char ch = '��';
	private BoundedBuffer  buffer = new BoundedBuffer();
	public void run() {
		show();
	}

	private void show() {
		// TODO �Զ����ɵķ������
		for (int i = 0; i < 6; i++) {
			try {
				buffer.put(i);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

public class ThreadTest_1 {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Game g = new Game();
		Thread t1 = new Thread(g);
		Thread t2 = new Thread(g);
		t1.start();
		t2.start();

	}
}
