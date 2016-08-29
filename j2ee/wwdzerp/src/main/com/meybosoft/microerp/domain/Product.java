package com.meybosoft.microerp.domain;

//��Ʒ��Ϣ

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

	private String sn;	//���

	private String title;//����
	@OneToOne(column="customer_id",type=Vendor.class)
	private Vendor vendor;//������

	private String types;//���

	private String dir;//Ŀ¼

	private String unit;//������λ

	private BigDecimal buyPrice;//�����۸�

	private BigDecimal salePrice;//���ۼ۸�

	private String pic;//��ƷͼƬ
	
	private String intro;//��Ʒ���

	private String remark;//��ע
	@OneToOne(column="systemUser_id",type=SystemUser.class)
	private SystemUser inputUser;//¼����

	private Date inputTime;//¼��ʱ��

	private Integer status;//״̬

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
