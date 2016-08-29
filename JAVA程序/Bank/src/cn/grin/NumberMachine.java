package cn.grin;

public class NumberMachine {
	private NumberManager commonManager = new NumberManager();
	private NumberManager expressManager = new NumberManager();
	private NumberManager vipManager = new NumberManager();
	
	public NumberManager getCommonManager() {
		return commonManager;
	}
	public NumberManager getExpressManager() {
		return expressManager;
	}
	public NumberManager getVipManager() {
		return vipManager;
	}
	
	
	
	private NumberMachine(){
	}
	private static NumberMachine nm = new NumberMachine();
	public static NumberMachine getInstance(){
		return nm;
	}
}
