package cn.grin;

import java.util.Random;
import java.util.concurrent.Executors;

public class CommomServiceWindow {
	protected CustomerType type = CustomerType.COMMOM;
	protected int windowID = 1;
	protected NumberMachine nm = NumberMachine.getInstance();
	protected String windowName = null;
	public CommomServiceWindow(int windowID){
		this.windowID = windowID;
	}
	
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
				windowName = "��"+windowID+"��"+type+"����";
				while(true){
					work();
				}
			}
		});
	}

	protected void work() {
		Integer number = nm.getCommonManager().fetchServiceNumber();
		System.out.println(windowName+"��ȡ"+CustomerType.COMMOM+"����");
		if(null == number){
			System.out.println(windowName+"û��ȡ��"+CustomerType.COMMOM+"������Ϣһ����");
			rest();
		}
		else{
			service(number,CustomerType.COMMOM,type == CustomerType.EXPRESS ? Constants.MIN_SERVICE_TIME : getSerivceTime());
		}
		
	}


	protected void rest() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	protected void service(Integer number,CustomerType custType,long severTime) {
		System.out.println(windowName+"����Ϊ��"+number+"��"+custType+"�ͻ�����");
		
		try {
			Thread.sleep(severTime);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		System.out.println(windowName+"Ϊ��"+number+"��"+custType+"�ͻ���ɷ��񣬺�ʱ"+severTime/1000+"��");
	}

	protected long getSerivceTime() {
		long maxRand = Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME;
		long severTime = new Random().nextInt((int)maxRand) + 1 + Constants.MIN_SERVICE_TIME;
		return severTime;
	}
	
	private void vipServer() {
		String windowName = "��"+windowID+"��"+type+"����";
		Integer number = nm.getVipManager().fetchServiceNumber();
		System.out.println(windowName+"��ȡVIP����");
		if(null == number){
			System.out.println(windowName + "û��ȡ��VIP����");
			work();
			rest();
		}
		else{
			System.out.println(windowName+"����Ϊ��"+number+"��vip�ͻ�����");
			long beginTime = System.currentTimeMillis();
			long severTime = getSerivceTime();
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
