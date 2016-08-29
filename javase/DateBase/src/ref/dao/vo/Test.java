package ref.dao.vo;

import java.sql.Timestamp;

public class Test {
	public long id;
	public long score;
	public long money;
	public String Phone;
	public Timestamp createDate;
	public Test() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", score=" + score + ", money=" + money
				+ ", Phone=" + Phone + ", createDate=" + createDate + "]";
	}
	
}
