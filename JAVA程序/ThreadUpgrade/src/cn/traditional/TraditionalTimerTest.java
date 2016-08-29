package cn.traditional;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {
	
	public static int i = 0;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		new Timer().schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				// TODO 自动生成的方法存根
//				System.out.println("bombing");
//			}
//		}, 10000,3000);//10秒之后炸，之后每3秒一次
		
		class MyTimerTask extends TimerTask{
			long [] timer = {2000,3000};
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				System.out.println("bombing");
				new Timer().schedule(new MyTimerTask(), timer[i = (i +1)%2]);
			}
		}
		
		new Timer().schedule(new MyTimerTask(), 2000);//10秒之后炸，之后每3秒一次
		
		while (true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}
