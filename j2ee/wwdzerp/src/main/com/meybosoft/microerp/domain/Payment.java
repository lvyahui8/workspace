package com.meybosoft.microerp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.easyjf.dbo.annotation.*;
@Table(tableName="Payment")
public class Payment implements Serializable {
private Long id;
private Date vdate;//支付日期
private BigDecimal sum=new BigDecimal(0);//金额 
@OneToOne(column="customer_id",type=Customer.class)
private Customer customer;//客户
@OneToOne(column="waterTicket_id")
private Product waterTicket;//水票支付
private BigDecimal price=new BigDecimal(0);//水票价格
private Integer num;//水票数量
private BigDecimal diffSum=new BigDecimal(0);//本次差价
private String payUser;//支付人
private String opUser;//收款人
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}

public BigDecimal getSum() {
	return sum;
}
public void setSum(BigDecimal sum) {
	this.sum = sum;
}
public Date getVdate() {
	return vdate;
}
public void setVdate(Date vdate) {
	this.vdate = vdate;
}

public String getOpUser() {
	return opUser;
}
public void setOpUser(String opUser) {
	this.opUser = opUser;
}
public String getPayUser() {
	return payUser;
}
public void setPayUser(String payUser) {
	this.payUser = payUser;
}
public Integer getNum() {
	return num;
}
public void setNum(Integer num) {
	this.num = num;
}
public BigDecimal getPrice() {
	return price;
}
public void setPrice(BigDecimal price) {
	this.price = price;
}
public Product getWaterTicket() {
	return waterTicket;
}
public void setWaterTicket(Product waterTicket) {
	this.waterTicket = waterTicket;
}
public BigDecimal getDiffSum() {
	return diffSum;
}
public void setDiffSum(BigDecimal diffSum) {
	this.diffSum = diffSum;
}

}
