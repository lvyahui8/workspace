package com.sldll.cms.vo;

import java.sql.Timestamp;

public class OrderForm {
	public String id;
	public String dishes_id;
	public String vip_id;
	public Integer count;
	public String groups;
	public Timestamp createDate;
	public OrderForm() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDishes_id() {
		return dishes_id;
	}
	public void setDishes_id(String dishes_id) {
		this.dishes_id = dishes_id;
	}
	public String getVip_id() {
		return vip_id;
	}
	public void setVip_id(String vip_id) {
		this.vip_id = vip_id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "OrderForm [id=" + id + ", dishes_id=" + dishes_id + ", vip_id="
				+ vip_id + ", count=" + count + ", groups=" + groups
				+ ", createDate=" + createDate + "]";
	}
	
}
