package com.meybosoft.microerp.business.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import com.easyjf.web.tools.DbPageList;
import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.DeliveryService;
import com.meybosoft.microerp.business.LogicException;
import com.meybosoft.microerp.business.OrderService;
import com.meybosoft.microerp.domain.Delivery;
import com.meybosoft.microerp.domain.DeliveryDetail;
import com.meybosoft.microerp.domain.OrderInfo;

public class DeliveryServiceImpl extends AbstractDAOServiceSupport implements
		DeliveryService {
	private static final java.text.Format format = new java.text.SimpleDateFormat(
			"yyMMddHHmmss");

	private OrderService orderService;

	public boolean addDelivery(Delivery delivery) {
		return this.dao.save(delivery);
	}

	public boolean addDeliveryDetail(DeliveryDetail detail) {
		return this.dao.save(detail);
	}

	public boolean delDelivery(Delivery delivery) {

		return this.dao.del(delivery);
	}

	public boolean delDeliveryDetail(DeliveryDetail detail) {
		return this.dao.del(detail);
	}

	public Delivery getDelivery(Long id) {
		return (Delivery) this.dao.get(Delivery.class, id);
	}

	public Delivery getLastDelivery() {
		List list = this.dao.query(Delivery.class,
				"status<0 order by vdate desc");
		Delivery d = null;
		if (list != null && list.size() > 0) {
			d = (Delivery) list.get(0);
		} else {
			d = new Delivery();
			d.setSn(geDeliverySN());
			d.setVdate(new java.util.Date());
			d.setStatus(-1);
			addDelivery(d);
		}
		return d;
	}

	public String geDeliverySN() {
		return format.format(new java.util.Date());
	}

	public IPageList queryDelivery(String scope, Collection paras,
			int currentPage, int pageSize) {
		DbPageList pageList = new DbPageList(Delivery.class, scope, paras, dao);
		pageList.doList(currentPage, pageSize);
		return pageList;
	}

	public boolean updateDeliverDetail(DeliveryDetail detail) {		
		boolean ret=this.dao.update(detail);
		if(detail.getBackBottle()!=null && detail.getBackBottle().intValue()>0)
		{
			OrderInfo order=orderService.getOrder(detail.getOrder().getId());
			order.getCustomer().setBalanceBarrel(order.getCustomer().getBalanceBarrel().intValue()-detail.getBackBottle().intValue());
			ret&=dao.update(order.getCustomer());
		}		
		return ret;
	}

	public boolean updateDelivery(Delivery delivery) {
		return this.dao.update(delivery);
	}

	public boolean appointOrder(Delivery delivery, Long orderId, String intro) {
		OrderInfo order = orderService.getOrder(orderId);
		if (order != null && order.getStatus().intValue() == 0) {
			DeliveryDetail detail = new DeliveryDetail();
			detail.setOrder(order);
			detail.setParent(delivery);
			detail.setStatus(0);
			detail.setIntro(intro);
			detail.setBackAmount(new BigDecimal("0"));
			addDeliveryDetail(detail);
			order.setStatus(new Integer(2));
			return orderService.updateOrder(order);
		} else
			throw new LogicException("指定的定单不存在，或者是已经派过单！");
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
}
