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
		String windowName = "��"+windowID+"��"+type+"����";
		Integer number = nm.getCommonManager().fetchServiceNumber();
		System.out.println(windowName+"��ȡ��ͨ����");
		if(null == number){
			System.out.println(windowName+"û��ȡ����ͨ������Ϣһ����");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		else{
			System.out.println(windowName+"����Ϊ��"+number+"����ͨ�ͻ�����");
			long beginTime = System.currentTimeMillis();
			long maxRand = Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME;
			long severTime = new Random().nextInt((int)maxRand) + 1 + Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(severTime);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			long costTime = System.currentTimeMillis() - beginTime;
			System.out.println(windowName+"Ϊ��"+number+"��"+"��ͨ"+"�ͻ���ɷ��񣬺�ʱ"+costTime/1000+"��");
		}
	}
	private void expressServer() {
		String windowName = "��"+windowID+"��"+type+"����";
		Integer number = nm.getExpressManager().fetchServiceNumber();
		System.out.println(windowName+"��ȡ��������");
		if(null == number){
			System.out.println(windowName+"û��ȡ����������");
			commonServer();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		else{
			System.out.println(windowName+"����Ϊ��"+number+"�ſ��ٿͻ�����");
			try {
				Thread.sleep(Constants.MIN_SERVICE_TIME);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			System.out.println(windowName+"Ϊ��"+number+"��"+"����"+"�ͻ���ɷ��񣬺�ʱ"+Constants.MIN_SERVICE_TIME/1000+"��");
		}
	}
	private void vipServer() {
		String windowName = "��"+windowID+"��"+type+"����";
		Integer number = nm.getVipManager().fetchServiceNumber();
		System.out.println(windowName+"��ȡVIP����");
		if(null == number){
			System.out.println(windowName + "û��ȡ��VIP����");
			commonServer();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		else{
			System.out.println(windowName+"����Ϊ��"+number+"��vip�ͻ�����");
			long beginTime = System.currentTimeMillis();
			long maxRand = Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME;
			long severTime = new Random().nextInt((int)maxRand) + 1 + Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(severTime);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			long costTime = System.currentTimeMillis() - beginTime;
			System.out.println(windowName+"Ϊ��"+number+"��"+"VIP"+"�ͻ���ɷ��񣬺�ʱ"+costTime/1000+"��");
		}
	}
}
