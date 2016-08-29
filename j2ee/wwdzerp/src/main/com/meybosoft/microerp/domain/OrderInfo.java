package com.meybosoft.microerp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import com.easyjf.dbo.annotation.*;

@Table(tableName = "OrderInfo")
public class OrderInfo implements Serializable {

	private Long id;//����id
	private String sn;// �������
	private Date vdate;//��������
	private Date requireDate;//��������
	private String payType;//֧����ʽ
	private String linkMan;//��ϵ��
	private String tel;//�绰
	private String address;//��ַ
	private String requirement;//��������
	private String remark;//��ע
	private BigDecimal amount=new BigDecimal(0);//�����ܽ��
	private String handPerson;//������
	private String inputUser;//¼����
	private Date inputTime;//¼��ʱ��
	private String opUser;//������
	private String opIntro;//�������
	private Date opTime;//����ʱ��
	private Integer status;//����״̬
	private Integer paymentStatus;//֧��״̬

	@OneToOne(column = "customer_id", type = Customer.class)
	private Customer customer;//һ��һ������������Ӧ�Ŀͻ�

	@ManyToOne(column = "order_id", fieldType=java.util.TreeSet.class,type = OrderDetail.class)
	private Set<OrderDetail> children = new java.util.TreeSet<OrderDetail>();//һ�Զ�����������������ϸ��Ϣ
	
	//������Ϣ
	private BigDecimal invoiceSum;//��Ʊ��
	private BigDecimal realSum;//ʵ�ʽ��
	private BigDecimal managerFee;//�������
	private BigDecimal workTip;//�����
	private Integer donateTickt;//��Ʊ��
	private Integer donateMachine;//������

	private Integer types;//��������
	@OneToOne(column="payment_id")
	private Payment payment;//֧����Ϣ
	
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
