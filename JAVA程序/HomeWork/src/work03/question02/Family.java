package work03.question02;

public class Family {
	public void viewExterior() {
		System.out.println("�ۿ�����"+this.exterior);
	}
	@SuppressWarnings("unused")
	private void getBankbook() {
		System.out.println("��ȡ���۱�"+this.bankbook);
	}
	protected void callPhone() {
		System.out.println(this.phone + ":��绰��");
	}
	private String exterior;
	public Family(String exterior, String bankbook, String phone) {
		super();
		this.exterior = exterior;
		this.bankbook = bankbook;
		this.phone = phone;
	}
	private String bankbook;
	private String phone;
}
