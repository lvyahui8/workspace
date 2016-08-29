package com.meybosoft.microerp.domain;

//产品信息

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.meybosoft.microerp.system.SystemUser;
import com.easyjf.dbo.annotation.Table;
import com.easyjf.dbo.annotation.TableField;
import com.easyjf.dbo.annotation.OneToOne;
@Table(tableName="Product")
public class Product implements Serializable {
	
	private Long id;

	private String sn;	//编号

	private String title;//名称
	@OneToOne(column="customer_id",type=Vendor.class)
	private Vendor vendor;//供货商

	private String types;//类别

	private String dir;//目录

	private String unit;//计量单位

	private BigDecimal buyPrice;//进货价格

	private BigDecimal salePrice;//销售价格

	private String pic;//产品图片
	
	private String intro;//产品简介

	private String remark;//备注
	@OneToOne(column="systemUser_id",type=SystemUser.class)
	private SystemUser inputUser;//录入人

	private Date inputTime;//录入时间

	private Integer status;//状态

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}
	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	
	public Date getInputTime() {
		return inputTime;
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}	

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public SystemUser getInputUser() {
		return inputUser;
	}

	public void setInputUser(SystemUser inputUser) {
		this.inputUser = inputUser;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

}
