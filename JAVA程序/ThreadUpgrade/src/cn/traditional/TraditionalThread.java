package cn.traditional;

public class TraditionalThread {//传统线程

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		Thread thread1 = new Thread("mythread"){
//			public void run(){
//				while(true){
//					try {
//						Thread.sleep(500);
//					} catch (InterruptedException e) {
//						// TODO 自动生成的 catch 块
//						e.printStackTrace();
//					}
//					System.out.println(""+Thread.currentThread().getName());
//				}
//			}
//		};
//		thread1.start();
//		
//		Thread thread2 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO 自动生成的方法存根
//				
//			}
//		});
//		thread2.start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				System.out.println("Runnable 方法");
			}
		}) {
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				System.out.println("Thread子类 方法");
				super.run();
			}
		}.start();
	}

}
