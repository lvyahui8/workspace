package cn.grin;

public class VipServiceWindow extends CommomServiceWindow{

	public VipServiceWindow(int windowID) {
		super(windowID);
		this.setType(CustomerType.VIP);
	}
	
	public void work(){
		Integer number = nm.getVipManager().fetchServiceNumber();
		System.out.println(windowName+"��ȡ"+CustomerType.VIP+"����");
		if(null== number ){
			System.out.println(windowName+"û��ȡ��"+CustomerType.VIP+"����");
			super.work();
		}
		else{
			service(number,CustomerType.VIP,getSerivceTime());
		}
	}

}
