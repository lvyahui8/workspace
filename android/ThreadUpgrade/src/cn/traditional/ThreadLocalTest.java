package cn.traditional;

import java.util.Random;
class MyThreadScopeData{
	
	private MyThreadScopeData(){}

	public static  MyThreadScopeData getInstance(){
		MyThreadScopeData mtsd = map.get();
		if(null == mtsd){
			mtsd = new MyThreadScopeData();
			map.set(mtsd);
		}
		return mtsd;
	}
	private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
public class ThreadLocalTest {
//	private static int data = 0;
//	private static Map<Thread,Integer> threadData = new HashMap<Thread,Integer>();
	private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
						int data = new Random().nextInt();
						System.out.println(Thread.currentThread().getName()+
								" has put data:"+data);
						x.set( data);
//						MyThreadScopeData currentdata = new MyThreadScopeData();
//						currentdata.setName("name"+data);
//						currentdata.setAge(data);
//						myData.set(currentdata);
						MyThreadScopeData.getInstance().setName("name"+data);;
						MyThreadScopeData.getInstance().setAge(data);
						new A().getData();
						new B().getData();
					}
			}).start();
		}
	}
	
	static class A{
		public int getData(){
			int data = x.get();
//			System.out.println(Thread.currentThread().getName()+
//				" get data:"+data);
//			System.out.println(Thread.currentThread().getName()+
//					" get data:"+myData.get().getName()+":"+myData.get().getAge());
			MyThreadScopeData mtsd = MyThreadScopeData.getInstance();
			System.out.println(Thread.currentThread().getName()+
					" get data:"+mtsd.getName()+":"+mtsd.getAge());
			
			return data;
		}
	}
	static class B{
		public int getData(){
			int data = x.get();
//			System.out.println(Thread.currentThread().getName()+
//				" get data:"+data);
//			System.out.println(Thread.currentThread().getName()+
//				" get data:"+myData.get().getName()+":"+myData.get().getAge());
			MyThreadScopeData mtsd = MyThreadScopeData.getInstance();
			System.out.println(Thread.currentThread().getName()+
					" get data:"+mtsd.getName()+":"+mtsd.getAge());
			return data;
		}
	}
}
