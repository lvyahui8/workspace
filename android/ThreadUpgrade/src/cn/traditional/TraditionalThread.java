package cn.traditional;

public class TraditionalThread {//��ͳ�߳�

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
//		Thread thread1 = new Thread("mythread"){
//			public void run(){
//				while(true){
//					try {
//						Thread.sleep(500);
//					} catch (InterruptedException e) {
//						// TODO �Զ����ɵ� catch ��
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
//				// TODO �Զ����ɵķ������
//				
//			}
//		});
//		thread2.start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				System.out.println("Runnable ����");
			}
		}) {
			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				System.out.println("Thread���� ����");
				super.run();
			}
		}.start();
	}

}
