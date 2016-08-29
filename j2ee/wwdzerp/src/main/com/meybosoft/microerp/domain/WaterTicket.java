package com.meybosoft.microerp.domain;

import java.util.Date;

import com.easyjf.dbo.annotation.OneToOne;
import com.easyjf.dbo.annotation.Table;
//水票信息
@Table(tableName="WaterTicket")
public class WaterTicket {
private Long id;//主键
private Long sn;//编号
@OneToOne(column="product_id")
private Product product;//产品
@OneToOne(column="customer_id")
private Customer customer;//购买客户
private Integer status;//状态,-1表示库存，0表示已售出，2表示已回收
private Date vdate;//
private Date backDate;
@OneToOne(column="consumer_id")
private Customer consumer;//消费者
public Date getBackDate() {
	return backDate;
}
public void setBackDate(Date backDate) {
	this.backDate = backDate;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public Long getSn() {
	return sn;
}
public void setSn(Long sn) {
	this.sn = sn;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public Date getVdate() {
	return vdate;
}
public void setVdate(Date vdate) {
	this.vdate = vdate;
}
public Customer getConsumer() {
	return consumer;
}
public void setConsumer(Customer consumer) {
	this.consumer = consumer;
}

}
