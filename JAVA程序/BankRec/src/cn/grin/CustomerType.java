package cn.grin;

public enum CustomerType {
	COMMOM,EXPRESS,VIP;
	public String toString(){
		String name = null;
		switch (this) {
		case COMMOM:
			name = "��ͨ";
			break;
		case EXPRESS:
			name = "����";
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
