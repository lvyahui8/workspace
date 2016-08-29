package cn.grin;

public class ExpressServiceWindow extends CommomServiceWindow{
	public ExpressServiceWindow(int windowID) {
		super(windowID);
		this.setType(CustomerType.EXPRESS);
	}

	protected void work(){
		Integer number = nm.getExpressManager().fetchServiceNumber();
		System.out.println(windowName+"��ȡ"+CustomerType.EXPRESS+"����");
		if(null== number ){
			System.out.println(windowName+"û��ȡ��"+CustomerType.EXPRESS+"����");
			super.work();
		}
		else{
			service(number,CustomerType.EXPRESS,Constants.MIN_SERVICE_TIME);
		}
	}
}
