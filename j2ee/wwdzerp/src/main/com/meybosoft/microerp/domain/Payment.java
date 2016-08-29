package com.meybosoft.microerp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.easyjf.dbo.annotation.*;
@Table(tableName="Payment")
public class Payment implements Serializable {
private Long id;
private Date vdate;//֧������
private BigDecimal sum=new BigDecimal(0);//��� 
@OneToOne(column="customer_id",type=Customer.class)
private Customer customer;//�ͻ�
@OneToOne(column="waterTicket_id")
private Product waterTicket;//ˮƱ֧��
private BigDecimal price=new BigDecimal(0);//ˮƱ�۸�
private Integer num;//ˮƱ����
private BigDecimal diffSum=new BigDecimal(0);//���β��
private String payUser;//֧����
private String opUser;//�տ���
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
