package com.meybosoft.microerp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import com.easyjf.dbo.annotation.*;

@Table(tableName = "OrderInfo")
public class OrderInfo implements Serializable {

	private Long id;//主键id
	private String sn;// 定单编号
	private Date vdate;//定单日期
	private Date requireDate;//交付日期
	private String payType;//支付方式
	private String linkMan;//联系人
	private String tel;//电话
	private String address;//地址
	private String requirement;//需求描述
	private String remark;//备注
	private BigDecimal amount=new BigDecimal(0);//订单总金额
	private String handPerson;//经手人
	private String inputUser;//录入人
	private Date inputTime;//录入时间
	private String opUser;//操作人
	private String opIntro;//操作简介
	private Date opTime;//操作时间
	private Integer status;//订单状态
	private Integer paymentStatus;//支付状态

	@OneToOne(column = "customer_id", type = Customer.class)
	private Customer customer;//一对一关联，定单对应的客户

	@ManyToOne(column = "order_id", fieldType=java.util.TreeSet.class,type = OrderDetail.class)
	private Set<OrderDetail> children = new java.util.TreeSet<OrderDetail>();//一对多关联，定单下面的详细信息
	
	//附加信息
	private BigDecimal invoiceSum;//发票金额　
	private BigDecimal realSum;//实际金额
	private BigDecimal managerFee;//管理费用
	private BigDecimal workTip;//劳务费
	private Integer donateTickt;//赠票数
	private Integer donateMachine;//赠机数

	private Integer types;//订单类型
	@OneToOne(column="payment_id")
	private Payment payment;//支付信息
	
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Set<OrderDetail> getChildren() {
		return children;
	}

	public void setChildren(Set<OrderDetail> children) {
		this.children = children;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getHandPerson() {
		return handPerson;
	}

	public void setHandPerson(String handPerson) {
		this.handPerson = handPerson;
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

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getOpIntro() {
		return opIntro;
	}

	public void setOpIntro(String opIntro) {
		this.opIntro = opIntro;
	}

	public Date getOpTime() {
		return opTime;
	}

	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}

	public String getOpUser() {
		return opUser;
	}

	public void setOpUser(String opUser) {
		this.opUser = opUser;
	}

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer payment) {
		this.paymentStatus = payment;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getRequireDate() {
		return requireDate;
	}

	public void setRequireDate(Date requireDate) {
		this.requireDate = requireDate;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getVdate() {
		return vdate;
	}

	public void setVdate(Date vdate) {
		this.vdate = vdate;
	}

	public Integer getDonateMachine() {
		return donateMachine;
	}

	public void setDonateMachine(Integer donateMachine) {
		this.donateMachine = donateMachine;
	}

	public Integer getDonateTickt() {
		return donateTickt;
	}

	public void setDonateTickt(Integer donateTickt) {
		this.donateTickt = donateTickt;
	}

	public BigDecimal getInvoiceSum() {
		return invoiceSum;
	}

	public void setInvoiceSum(BigDecimal invoiceSum) {
		this.invoiceSum = invoiceSum;
	}

	public BigDecimal getManagerFee() {
		return managerFee;
	}

	public void setManagerFee(BigDecimal managerFee) {
		this.managerFee = managerFee;
	}

	public BigDecimal getRealSum() {
		return realSum;
	}

	public void setRealSum(BigDecimal realSum) {
		this.realSum = realSum;
	}

	public BigDecimal getWorkTip() {
		return workTip;
	}

	public void setWorkTip(BigDecimal workTip) {
		this.workTip = workTip;
	}

	public Integer getTypes() {
		return types;
	}

	public void setTypes(Integer types) {
		this.types = types;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
