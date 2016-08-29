package cn.grin;

public enum CustomerType {
	COMMOM,EXPRESS,VIP;
	public String toString(){
		String name = null;
		switch (this) {
		case COMMOM:
			name = "ÆÕÍ¨";
			break;
		case EXPRESS:
			name = "¿ìËÙ";
			break;
		case VIP:
			name = name();
			break;
		default:
			break;
		}
		return name;
	}
}
