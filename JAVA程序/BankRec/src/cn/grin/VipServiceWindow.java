package cn.grin;

public class VipServiceWindow extends CommomServiceWindow{

	public VipServiceWindow(int windowID) {
		super(windowID);
		this.setType(CustomerType.VIP);
	}
	
	public void work(){
		Integer number = nm.getVipManager().fetchServiceNumber();
		System.out.println(windowName+"获取"+CustomerType.VIP+"任务");
		if(null== number ){
			System.out.println(windowName+"没有取到"+CustomerType.VIP+"任务");
			super.work();
		}
		else{
			service(number,CustomerType.VIP,getSerivceTime());
		}
	}

}
