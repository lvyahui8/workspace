package com.meybosoft.microerp.domain;

import java.util.Date;

import com.easyjf.dbo.annotation.OneToOne;
import com.easyjf.dbo.annotation.Table;
//ˮƱ��Ϣ
@Table(tableName="WaterTicket")
public class WaterTicket {
private Long id;//����
private Long sn;//���
@OneToOne(column="product_id")
private Product product;//��Ʒ
@OneToOne(column="customer_id")
private Customer customer;//����ͻ�
private Integer status;//״̬,-1��ʾ��棬0��ʾ���۳���2��ʾ�ѻ���
private Date vdate;//
private Date backDate;
@OneToOne(column="consumer_id")
private Customer consumer;//������
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
