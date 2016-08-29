/*
 * ��Ҫдһ������һ���߳�����ʮ�Σ��ص����߳�����100�Σ�
 * �ڻص��Ǹ��߳�����10�Σ��ڻص����߳�����100�Ρ���˷���
 */
package cn.traditional;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}
						System.out.println("���߳�ִ����" + i + "��");
//					}
				}
			}
		};
		t.start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e1) {
			// TODO �Զ����ɵ� catch ��
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
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					finally{
						lock.unlock();
					}
				}
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				System.out.println("���߳�ִ����"+n+"��");
//			}
		}
	}

}
