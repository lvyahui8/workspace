package com.meybosoft.microerp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.easyjf.dbo.annotation.OneToOne;
import com.easyjf.dbo.annotation.Table;
import com.easyjf.dbo.annotation.TableField;
@Table(tableName="CustomerPrice")
public class CustomerPrice implements Serializable {

	private Long id;
	
	@OneToOne(column="customer_id",type=Customer.class)
	private Customer customer;
	
	@OneToOne(column="product_id",type=Product.class)
	private Product product;
	

	private BigDecimal price;
	

	private String unit;		

	private Date vdate;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Date getVdate() {
		return vdate;
	}
	public void setVdate(Date vdate) {
		this.vdate = vdate;
	}
}
