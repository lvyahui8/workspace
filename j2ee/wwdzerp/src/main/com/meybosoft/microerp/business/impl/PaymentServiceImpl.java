package com.meybosoft.microerp.business.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.easyjf.util.Assert;
import com.easyjf.web.tools.DbPageList;
import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.CustomerService;
import com.meybosoft.microerp.business.OrderService;
import com.meybosoft.microerp.business.PaymentService;
import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.OrderInfo;
import com.meybosoft.microerp.domain.Payment;

public class PaymentServiceImpl extends AbstractDAOServiceSupport implements
		PaymentService {	
	private OrderService orderService; 
	private CustomerService customerService;
	//添加一笔支付信息
	public boolean addPayment(Payment pay) {
		Assert.notNull(pay);		
		return this.dao.save(pay);
	}
	//删除一笔支付信息
	public boolean delPayment(Payment pay) {	
		return this.dao.del(pay);
	}
	//通过ID得到一笔支付信息
	public Payment getPayment(Long id) {	
		return (Payment)this.dao.get(Payment.class, id);
	}
	//得到一笔定单下的所有支付信息
	public List getOrderPayment(OrderInfo order) {
		java.util.Collection paras=new java.util.ArrayList();
		paras.add(order.getId());
		return this.dao.query(Payment.class, "order_id=?",paras);
	}
	//得到一个客户的所有支付信息
	public List getCustomerPayment(Customer customer) {
		java.util.Collection paras=new java.util.ArrayList();
		paras.add(customer.getId());
		return this.dao.query(Payment.class, "customer_id=?",paras);
	}
	//自定义查询支付信息
	public IPageList queryPayment(String scope, Collection paras, int currentPage, int pageSize) {		
		DbPageList pageList=new DbPageList(Payment.class,scope,paras,dao);
		pageList.doList(currentPage, pageSize);	
		return pageList;
	}
	//更新支付信息
	public boolean updatePayment(Payment pay) {
		Assert.notNull(pay);
		return this.dao.update(pay);
	}
	public IPageList queryCustomerDebt(Customer customer)
	{
		Collection paras=new  ArrayList();
		paras.add(customer.getId());
		return orderService.queryOrder("paymentStatus="+PAYTYPE_NONE+" and customer_id=?", paras, 1,-1);
	}
	
	public boolean pay(Payment payment, String orders) {
		// TODO Auto-generated method stub
		return false;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
}
