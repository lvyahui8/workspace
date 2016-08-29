package cn.grin;

public class ExpressServiceWindow extends CommomServiceWindow{
	public ExpressServiceWindow(int windowID) {
		super(windowID);
		this.setType(CustomerType.EXPRESS);
	}

	protected void work(){
		Integer number = nm.getExpressManager().fetchServiceNumber();
		System.out.println(windowName+"获取"+CustomerType.EXPRESS+"任务");
		if(null== number ){
			System.out.println(windowName+"没有取到"+CustomerType.EXPRESS+"任务");
			super.work();
		}
		else{
			service(number,CustomerType.EXPRESS,Constants.MIN_SERVICE_TIME);
		}
	}
}
