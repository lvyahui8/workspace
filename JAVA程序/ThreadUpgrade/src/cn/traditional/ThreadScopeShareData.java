package cn.traditional;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareData {
//	private static int data = 0;
	private static Map<Thread,Integer> threadData = new HashMap<Thread,Integer>();
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
						int data = new Random().nextInt();
						System.out.println(Thread.currentThread().getName()+
								" has put data:"+data);
						threadData.put(Thread.currentThread(), data);
						new A().getData();
						new B().getData();
					}
			}).start();
		}
	}
	
	static class A{
		public int getData(){
			int data = threadData.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName()+
				" get data:"+data);
			return data;
		}
	}
	static class B{
		public int getData(){
			int data = threadData.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName()+
				" get data:"+data);
			return data;
		}
	}
}
