package cn.agrin;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.agrin.Lamp.Color;

public class LightControl {
	private static final LightControl lc = new LightControl();
	public static LightControl getInstance(){
		return lc;
	}
	Lamp lamps [] = {
			null,null,null,null,
			null,null,null,null
	};
	private int count = 0;
	private LightControl() {

	}
	private boolean start = false;
	public boolean addLamp(Lamp lamp){
//System.out.println("����������һ����"+count);
		boolean result = true;
		if(lamps.length-1 == count){
			lamps[count] = lamp;
//System.out.println("��װ����");
			if(false == start){
				start();
//System.out.println("����������");
				start = true;
			}
			result = false;
		}
		else{
			lamps[count++] = lamp;
		}
		return result;
	}
	
	
	private int currentLamp = 0;
	private void start() {
		// TODO �Զ����ɵķ������
		timer.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
//				Road [] roads = DemoClient.getInstance().getRoads();
				LightControl.this.lamps[currentLamp].setLight(Color.RED);
				LightControl.this.lamps[currentLamp+4].setLight(Color.RED);
				
				currentLamp = (currentLamp + 1)%4;
				
				LightControl.this.lamps[currentLamp].setLight(Color.YELLOW);
				LightControl.this.lamps[currentLamp+4].setLight(Color.YELLOW);
				
				try {
					Thread.sleep(Lamp.YEOOLW_TIME*1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				LightControl.this.lamps[currentLamp].setLight(Color.GREEN);
				LightControl.this.lamps[currentLamp+4].setLight(Color.GREEN);
//				roads[currentLamp/2+1].updateWaitCars();
//				roads[currentLamp/2+3].updateWaitCars();
//System.out.println("֪ͨ�ڣ�"+(currentLamp/2+1)+"���͵ڣ�"+(currentLamp/2+3)+"����·�ϵĳ�����");

					
			}
		}, Lamp.RED_TIME, Lamp.RED_TIME, TimeUnit.SECONDS);
	}

	ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
	
}