		package com.meybosoft.microerp.domain;
//记录客户的基本资料

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.easyjf.dbo.annotation.*;
@Table(tableName="Customer")
public class Customer implements Serializable {

	private Long id;

	private String sn;	

	private String title;
	
	private String types;

	private String leader;

	private String linkMan;

	private String tel;

	private String address;

	private String province;

	private String city;

	private String town;	

	private String zip;

	private String fax;
	
	private String email;

	private String homePage;

	private String source;

	private String rank;

	private String intro;

	private String remark;

	private String inputUser;

	private Date inputTime;

	private Integer status;	
	@OneToOne(column="parent_id",lazy=false,type=Customer.class)
	private Customer parent;
	@ManyToOne(column = "parent_id", fieldType=java.util.HashSet.class,type = Customer.class,lazy=false)
	private java.util.Set<Customer> children=new java.util.HashSet<Customer>();
	private BigDecimal balance;	
	private Integer ticketNum;	
	private BigDecimal debt;	
	private Integer balanceBarrel;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public java.util.Set<Customer> getChildren() {
		return children;
	}

	public void setChildren(java.util.Set<Customer> children) {
		this.children = children;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public Date getInputTime() {
		return inputTime;
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	public String getInputUser() {
		return inputUser;
	}

	public void setInputUser(String inputUser) {
		this.inputUser = inputUser;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public Customer getParent() {
		return parent;
	}

	public void setParent(Customer parent) {
		this.parent = parent;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Integer getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(Integer ticketNum) {
		this.ticketNum = ticketNum;
	}

	public BigDecimal getDebt() {
		return debt;
	}

	public void setDebt(BigDecimal debt) {
		this.debt = debt;
	}

	public Integer getBalanceBarrel() {
		return balanceBarrel;
	}

	public void setBalanceBarrel(Integer balanceBarrel) {
		this.balanceBarrel = balanceBarrel;
	}

}
