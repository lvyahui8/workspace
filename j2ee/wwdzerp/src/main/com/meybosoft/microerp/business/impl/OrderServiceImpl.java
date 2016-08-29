package com.meybosoft.microerp.business.impl;


import java.util.Collection;


import com.easyjf.util.Assert;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.CustomerService;
import com.meybosoft.microerp.business.LogicException;
import com.meybosoft.microerp.business.OrderService;
import com.meybosoft.microerp.business.WaterTicketService;
import com.meybosoft.microerp.domain.OrderDetail;
import com.meybosoft.microerp.domain.OrderInfo;


public class OrderServiceImpl extends AbstractDAOServiceSupport implements
		OrderService {
	private WaterTicketService ticketService;

	private CustomerService customerService;

	private static final java.text.Format format = new java.text.SimpleDateFormat(
			"yyMMddHHmmss");

	public boolean addOrder(OrderInfo order) {
		Assert.notNull(order);
		if (order.getSn() == null)
			throw new LogicException("订单编号不能为空！");
		if (getOrderBySn(order.getSn()) != null)
			throw new LogicException("订单编号已经存在！");
		return this.dao.save(order);
	}

	public boolean addOrderDetail(OrderDetail detail) {
		Assert.notNull(detail);
		return this.dao.save(detail);
	}

	public boolean delOrder(OrderInfo order) {
		Assert.notNull(order);
		return this.dao.del(order);
	}

	public boolean delOrderDetail(OrderDetail detail) {
		Assert.notNull(detail);
		return this.dao.del(detail);
	}

	public OrderInfo getOrder(Long id) {
		Assert.notNull(id);
		return (OrderInfo) this.dao.getBy(OrderInfo.class, "id", id);
	}

	

	public boolean confirmOrder(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean excludeTicketSn(OrderInfo order, String sns) {
		// TODO Auto-generated method stub
		return false;
	}

	public OrderInfo getLastOrder(Integer types) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderDetail getLastOrderDetail(OrderInfo order) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderInfo getOrderBySn(String sn) {
		// TODO Auto-generated method stub
		return null;
	}

	public IPageList queryOrder(String scope, Collection paras, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateOrder(OrderInfo order) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateOrderDetail(OrderDetail detail) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setTicketService(WaterTicketService ticketService) {
		this.ticketService = ticketService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
