package com.meybosoft.microerp.business;

import java.util.List;
import java.util.Set;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.impl.OrderServiceImpl;
import com.meybosoft.microerp.business.impl.ProductServiceImpl;
import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.OrderDetail;
import com.meybosoft.microerp.domain.OrderInfo;
import com.meybosoft.microerp.domain.Product;

import junit.framework.TestCase;

public class OrderServiceTest extends TestCase {
	private OrderService service;
	private CustomerService service1;
	private ProductService service2;

	@Override
	protected void setUp() throws Exception {
		service = new OrderServiceImpl();
		service2 = new ProductServiceImpl();
		super.setUp();
	}
	//测试是否可以新添定单
	public void testAddOrder(){
		OrderInfo ord = new OrderInfo();
		ord.setSn(null);
		ord.setVdate(new java.util.Date());
		try{
			service.addOrder(ord);
			fail("编号不能为空");	
		}
		catch(LogicException e){
		}
		ord.setId(new Long(1));
		ord.setSn("定单编号");
		ord.setVdate(new java.util.Date());
		ord.setLinkMan("毛伟");
		assertTrue("增加定单失败", service.addOrder(ord));
		
		OrderInfo ord2 = new OrderInfo();
		ord2.setSn("定单编号");
		try{
			service.addOrder(ord2);
			fail("不能添加编号相同的定单!");
		}
		catch(LogicException e){
		}
	}
	//测试是否可以修改订单信息
	public void testUpdateOrder(){
		OrderInfo ord =  service.getOrder(1l);
		assertNotNull("定单数据不存在", ord);
		ord.setLinkMan("毛正伟");
		ord.setTel("13251114955");
		assertTrue("更新定单失败", service.updateOrder(ord));		
	}
	//测试是否可以根据id得到订单信息
	public void testGetOrderId(){
		OrderInfo ord = service.getOrder(1l);
		assertNotNull("订单不存在",ord);
		
	}
	//测试是否可以根据sn得到订单信息
	public void testGetOrderSn(){
		OrderInfo ord = service.getOrderBySn("订单编号");
		assertNotNull("订单不存在",ord);
	}
	//测试是否可以根据查询条件查询订单信息
	public void testQueryOrder(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add(10);
		paras.add(100);
		paras.add(new java.util.Date());
		IPageList pageList= service.queryOrder("id>? and id<? and vdata>?", paras, 0, 15);
		assertNotNull("查询失败",pageList);
	}	
	//测试是否可以删除订单信息
	public void testDelOrder(){
		OrderInfo ord = service.getOrderBySn("订单编号");
		assertNotNull("订单不存在", ord);
		assertNull("删除订单失败", service.delOrder(ord));
	}
	//测试是否可以添加订单详细列表对象
	public void testAddOrderDetail(){
		OrderDetail detail = new OrderDetail();
		detail.setId(new Long(1));
		detail.setTypes("化工");
		detail.setUnit("平方米");
		detail.setAmount(new java.math.BigDecimal(3));
		detail.setTypes("化工");
		detail.setUnit("平方米");
		detail.setAmount(new java.math.BigDecimal(3));
		
		OrderInfo order = service.getOrder(1l);
		assertNotNull("父(定单)为空", order);
		detail.setOrder(order);
		Product prd = service2.getProduct(1l);
		assertNotNull("父(产品)为空", prd);
		detail.setProduct(prd);	

		assertTrue("产品添加失败",service.addOrderDetail(detail));	
	}
	//测试是否可以修改订单详细列表对象
	public void testUpdateOrderDetail(){
		OrderInfo order = service.getOrder(1l);
		java.util.Iterator<OrderDetail> it = order.getChildren().iterator();
		OrderDetail detail=it.next();
		detail.setNum(23.32);
		detail.setWidth(23.3f);
		assertTrue("修改失败", service.updateOrderDetail(it.next()));
		
	}
	//测试是否要以删除订单详细列表对象
	public void testDelOrderDetail(){
		OrderInfo order = service.getOrder(1l);		
		java.util.Iterator<OrderDetail> it=order.getChildren().iterator();
		while(it.hasNext())
		assertTrue("删除失败", service.delOrderDetail(it.next()));
	}
}
