package cn.grin;

import java.util.Random;
import java.util.concurrent.Executors;

public class ServiceWindow {
	private CustomerType type = CustomerType.COMMOM;
	private int windowID = 1;
	private NumberMachine nm = NumberMachine.getInstance();
	
	public void setType(CustomerType type) {
		this.type = type;
	}
	
	public void setWindowID(int windowID) {
		this.windowID = windowID;
	}
	
	public void start(){
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			@Override
			public void run() {
				while(true){
					
					switch(type){
					case COMMOM:{
						commonServer();
						break;
					}
					case EXPRESS:{
						expressServer();
						break;
					}
					case VIP:{
						vipServer();
						break;
					}
					default:
					}
				}
			}

		
		});
	}
	
	/**
	 * @param windowName
	 */
	private void commonServer() {
		String windowName = "第"+windowID+"号"+type+"窗口";
		Integer number = nm.getCommonManager().fetchServiceNumber();
		System.out.println(windowName+"获取普通任务");
		if(null == number){
			System.out.println(windowName+"没有取到普通任务，休息一秒钟");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		else{
			System.out.println(windowName+"正在为第"+number+"号普通客户服务");
			long beginTime = System.currentTimeMillis();
			long maxRand = Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME;
			long severTime = new Random().nextInt((int)maxRand) + 1 + Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(severTime);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			long costTime = System.currentTimeMillis() - beginTime;
			System.out.println(windowName+"为第"+number+"个"+"普通"+"客户完成服务，耗时"+costTime/1000+"秒");
		}
	}
	private void expressServer() {
		String windowName = "第"+windowID+"号"+type+"窗口";
		Integer number = nm.getExpressManager().fetchServiceNumber();
		System.out.println(windowName+"获取快速任务");
		if(null == number){
			System.out.println(windowName+"没有取到快速任务");
			commonServer();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		else{
			System.out.println(windowName+"正在为第"+number+"号快速客户服务");
			try {
				Thread.sleep(Constants.MIN_SERVICE_TIME);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.out.println(windowName+"为第"+number+"个"+"快速"+"客户完成服务，耗时"+Constants.MIN_SERVICE_TIME/1000+"秒");
		}
	}
	private void vipServer() {
		String windowName = "第"+windowID+"号"+type+"窗口";
		Integer number = nm.getVipManager().fetchServiceNumber();
		System.out.println(windowName+"获取VIP任务");
		if(null == number){
			System.out.println(windowName + "没有取到VIP任务");
			commonServer();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		else{
			System.out.println(windowName+"正在为第"+number+"号vip客户服务");
			long beginTime = System.currentTimeMillis();
			long maxRand = Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME;
			long severTime = new Random().nextInt((int)maxRand) + 1 + Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(severTime);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			long costTime = System.currentTimeMillis() - beginTime;
			System.out.println(windowName+"为第"+number+"个"+"VIP"+"客户完成服务，耗时"+costTime/1000+"秒");
		}
	}
}
