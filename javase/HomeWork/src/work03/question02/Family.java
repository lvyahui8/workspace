package work03.question02;

public class Family {
	public void viewExterior() {
		System.out.println("观看房屋"+this.exterior);
	}
	@SuppressWarnings("unused")
	private void getBankbook() {
		System.out.println("或取存折本"+this.bankbook);
	}
	protected void callPhone() {
		System.out.println(this.phone + ":打电话中");
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
