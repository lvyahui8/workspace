package com.meybosoft.microerp.domain;

import java.util.Date;
import com.easyjf.dbo.annotation.Table;
import com.easyjf.dbo.annotation.ManyToOne;
@Table(tableName="Delivery")
public class Delivery {
private Long id;
private String sn;
private Date vdate;
private String carno;
private String deliver;
private String appointer;
private String sender;
private String auditing;
private String intro;
@ManyToOne(column="parent_id",fieldType=java.util.HashSet.class,type=DeliveryDetail.class)
private java.util.Set children=new java.util.HashSet();
private Integer status;

public String getSn() {
	return sn;
}
public void setSn(String sn) {
	this.sn = sn;
}
public String getAppointer() {
	return appointer;
}
public void setAppointer(String appointer) {
	this.appointer = appointer;
}
public String getAuditing() {
	return auditing;
}
public void setAuditing(String auditing) {
	this.auditing = auditing;
}
public String getCarno() {
	return carno;
}
public void setCarno(String carno) {
	this.carno = carno;
}
public java.util.Set getChildren() {
	return children;
}
public void setChildren(java.util.Set children) {
	this.children = children;
}
public String getDeliver() {
	return deliver;
}
public void setDeliver(String deliver) {
	this.deliver = deliver;
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
public String getSender() {
	return sender;
}
public void setSender(String sender) {
	this.sender = sender;
}
public Date getVdate() {
	return vdate;
}
public void setVdate(Date vdate) {
	this.vdate = vdate;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
}
