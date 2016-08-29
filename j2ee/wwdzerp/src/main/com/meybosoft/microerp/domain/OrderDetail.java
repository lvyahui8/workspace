package com.meybosoft.microerp.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.easyjf.dbo.annotation.*;

@Table(tableName = "OrderDetail")
public class OrderDetail implements Comparable {

	private Long id;

	@OneToOne(column = "order_id", type = OrderInfo.class)
	private OrderInfo order;

	@OneToOne(column = "product_id", type = Product.class)
	private Product product;


	private String types;


	private Double num;


	private Float width;


	private Float height;


	private BigDecimal price;


	private BigDecimal amount;


	private String unit;


	private Integer status;


	private Integer sequence;


	private Integer unitType;


	private Date vdate;

	private String intro;
	
	private Integer beginSn;
	private Integer endSn;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}



	public Double getNum() {
		return num;
	}

	public void setNum(Double num) {
		this.num = num;
	}

	public OrderInfo getOrder() {
		return order;
	}

	public void setOrder(OrderInfo order) {
		this.order = order;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getUnitType() {
		return unitType;
	}

	public void setUnitType(Integer unitType) {
		this.unitType = unitType;
	}

	public Date getVdate() {
		return vdate;
	}

	public void setVdate(Date vdate) {
		this.vdate = vdate;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public int hashCode() {	
		return id==null?super.hashCode():id.hashCode();
	}
	
	public Integer getBeginSn() {
		return beginSn;
	}

	public void setBeginSn(Integer beginSn) {
		this.beginSn = beginSn;
	}

	public Integer getEndSn() {
		return endSn;
	}

	public void setEndSn(Integer endSn) {
		this.endSn = endSn;
	}

	public boolean equals(Object obj) {
		if((obj==null)||(! (obj instanceof OrderDetail)))return false;		
		OrderDetail o=(OrderDetail)obj;
		if(this.id!=null && (o.getId()!=null))return this.id.equals(o.getId());
		return super.equals(obj);
	}

	public int compareTo(Object o) {
		OrderDetail m = (OrderDetail) o;	
		if(this.sequence==null)return 1;
		if(m.sequence==null)return -1;
		return (this.sequence.intValue() - m.sequence.intValue());
	}
}
