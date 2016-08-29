package com.sldll.cms.vo;

import java.sql.Timestamp;

public class Vip {
	public String id;
	public String name;
	public String sex;
	public String phone;
	public Integer state;
	public Integer score;
	public Timestamp createDate;
	
	public Vip() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Vip [id=" + id + ", name=" + name + ", sex=" + sex + ", phone="
				+ phone + ", state=" + state + ", score=" + score
				+ ", createDate=" + createDate + "]";
	}
	
	
	
}
