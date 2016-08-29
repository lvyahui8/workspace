package com.meybosoft.microerp.domain;
import com.easyjf.dbo.annotation.Table;
import com.easyjf.dbo.annotation.OneToOne;;
@Table(tableName="DeliveryDetail")
public class DeliveryDetail{
private Long id;
@OneToOne(column="order_id")
private OrderInfo order;
@OneToOne(column="parent_id")
private Delivery parent;
private java.math.BigDecimal backAmount;
private Integer backBottle;
private Integer backWater;
private String intro;
private Integer status;
public Integer getBackBottle() {
	return backBottle;
}
public void setBackBottle(Integer backBottle) {
	this.backBottle = backBottle;
}
public Integer getBackWater() {
	return backWater;
}
public void setBackWater(Integer backWater) {
	this.backWater = backWater;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getIntro() {
	return intro;
}
public void setIntro(String intro) {
	this.intro = intro;
}
public OrderInfo getOrder() {
	return order;
}
public void setOrder(OrderInfo order) {
	this.order = order;
}
public Delivery getParent() {
	return parent;
}
public void setParent(Delivery parent) {
	this.parent = parent;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public java.math.BigDecimal getBackAmount() {
	return backAmount;
}
public void setBackAmount(java.math.BigDecimal backAmount) {
	this.backAmount = backAmount;
}

public boolean equals(Object obj) {
	if((obj==null)||(! (obj instanceof DeliveryDetail)))return false;		
	DeliveryDetail o=(DeliveryDetail)obj;
	if(this.id!=null && (o.getId()!=null))return this.id.equals(o.getId());
	return super.equals(obj);
}
}
