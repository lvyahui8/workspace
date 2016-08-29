package com.sldll.cms.vo;

import java.math.BigDecimal;

public class Dishes {
	public String id;
	public String name;
	public Integer category;
	public BigDecimal price;
	
	public Dishes() {
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

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {//xxx  setXxx  getXxx
		this.price = price;
	}

	@Override
	public String toString() {
		return "Dishes [id=" + id + ", name=" + name + ", category=" + category
				+ ", money=" + price + "]";
	}
	
	
}
