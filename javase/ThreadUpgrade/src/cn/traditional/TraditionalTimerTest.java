package cn.traditional;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {
	
	public static int i = 0;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
//		new Timer().schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				// TODO �Զ����ɵķ������
//				System.out.println("bombing");
//			}
//		}, 10000,3000);//10��֮��ը��֮��ÿ3��һ��
		
		class MyTimerTask extends TimerTask{
			long [] timer = {2000,3000};
			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				System.out.println("bombing");
				new Timer().schedule(new MyTimerTask(), timer[i = (i +1)%2]);
			}
		}
		
		new Timer().schedule(new MyTimerTask(), 2000);//10��֮��ը��֮��ÿ3��һ��
		
		while (true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}

}
