package com.meybosoft.microerp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.meybosoft.microerp.system.SystemUser;
import com.easyjf.dbo.annotation.*;
/**
 * 交易信息
 * @author 毛伟
 *
 */
@Table(tableName="DealInfo")
public class Deal implements Serializable {

private Long id;//主键
@OneToOne(column="customer_id",type=Customer.class,lazy=false)
private Customer customer;//客户
@OneToOne(column="order_id",type=OrderInfo.class,lazy=false)
private OrderInfo order;//订单

private BigDecimal sum;//金额

private Date vdate;//交易日期
@OneToOne(column="systemuser_id",type=Staff.class,lazy=false)
private Staff staff;//交易发生人

private Integer dealType;//交易类型

private Integer payType;//支付方式

private Payment payment;//支付信息,null表示未付

private Date inputTime;//输入时间

private SystemUser inputUser;//输入人

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
public Integer getDealType() {
	return dealType;
}
public void setDealType(Integer dealType) {
	this.dealType = dealType;
}
public Date getInputTime() {
	return inputTime;
}
public void setInputTime(Date inputTime) {
	this.inputTime = inputTime;
}
public SystemUser getInputUser() {
	return inputUser;
}
public void setInputUser(SystemUser inputUser) {
	this.inputUser = inputUser;
}
public OrderInfo getOrder() {
	return order;
}
public void setOrder(OrderInfo order) {
	this.order = order;
}
public Payment getPayment() {
	return payment;
}
public void setPayment(Payment payment) {
	this.payment = payment;
}
public Integer getPayType() {
	return payType;
}
public void setPayType(Integer payType) {
	this.payType = payType;
}
public Staff getStaff() {
	return staff;
}
public void setStaff(Staff staff) {
	this.staff = staff;
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
}
