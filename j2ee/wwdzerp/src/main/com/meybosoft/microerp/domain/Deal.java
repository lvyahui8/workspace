package com.meybosoft.microerp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.meybosoft.microerp.system.SystemUser;
import com.easyjf.dbo.annotation.*;
/**
 * ������Ϣ
 * @author ëΰ
 *
 */
@Table(tableName="DealInfo")
public class Deal implements Serializable {

private Long id;//����
@OneToOne(column="customer_id",type=Customer.class,lazy=false)
private Customer customer;//�ͻ�
@OneToOne(column="order_id",type=OrderInfo.class,lazy=false)
private OrderInfo order;//����

private BigDecimal sum;//���

private Date vdate;//��������
@OneToOne(column="systemuser_id",type=Staff.class,lazy=false)
private Staff staff;//���׷�����

private Integer dealType;//��������

private Integer payType;//֧����ʽ

private Payment payment;//֧����Ϣ,null��ʾδ��

private Date inputTime;//����ʱ��

private SystemUser inputUser;//������

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
