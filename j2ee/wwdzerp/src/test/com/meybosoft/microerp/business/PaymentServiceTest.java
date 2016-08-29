package com.meybosoft.microerp.business;

import java.util.List;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.impl.CustomerServiceImpl;
import com.meybosoft.microerp.business.impl.OrderServiceImpl;
import com.meybosoft.microerp.business.impl.PaymentServiceImpl;
import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.OrderInfo;
import com.meybosoft.microerp.domain.Payment;

import junit.framework.TestCase;

public class PaymentServiceTest extends TestCase {
	private PaymentService service;
	private CustomerService service1;
	private OrderService service2;
	
	@Override
	protected void setUp() throws Exception {
		service = new PaymentServiceImpl();
		service1 = new CustomerServiceImpl();
		service2 = new OrderServiceImpl();
		super.setUp();
	}
	//测试是否可以添加一笔支付信息
	public void testAddPayment(){
		Payment pay = new Payment();
		pay.setId(1l);
		pay.setVdate(new java.util.Date());
		pay.setSum(new java.math.BigDecimal(10));
	
		Customer parent_cu = service1.getCustomer(1l);
		assertNotNull("父对象(客户)为空", parent_cu);	
		pay.setCustomer(parent_cu);
		
		OrderInfo parent_or = service2.getOrder(1l);
		assertNotNull("父对象(产品)为空", parent_or);		
		
		assertTrue("添加一笔支付信息失败", service.addPayment(pay));

	}
	//测试是否可以修改一笔支付信息
	public void testUpdatePayment(){
		Payment pay = service.getPayment(1l);
		assertNotNull("支付信息不存在",pay);
		pay.setSum(new java.math.BigDecimal(12));
		assertTrue("修改支付信息失败",service.updatePayment(pay));	
	}
	//测试是否可以通过id查询一笔支付信息
	public void testGetPayment(){
		Payment pay = service.getPayment(1l);
		assertNotNull(pay);
		assertEquals("客户编号有误", "test", pay.getCustomer().getSn());
		
		Payment payment = service.getPayment(234l);
		assertNull("指定ID的支付信息不存在",payment);
	}
	//测试是否可以返回一笔订单的所有支付信息
	public void testGetPayment_OrderInfo(){
		OrderInfo order = service2.getOrder(1l);
		java.util.List list = service.getOrderPayment(order);
		assertNotNull("该笔定单下无支付信息", list);
		assertTrue("类型不匹配", list.get(0).getClass() == Payment.class);
		for(int i=0; i<list.size(); i++){
			Payment pay = (Payment) list.get(i);
			System.out.println(pay.getSum());
		}
		
		//java.util.List list = service.getPayment(ord);
		//assertNotNull("该笔定单下无支付信息", list);
	}
	//测试是否可以返回一个客户的所有支付信息
	public void testGetPayment_Customer(){
		Customer cust = service1.getCustomerBySn("test");		
		java.util.List list = service.getCustomerPayment(cust);
		assertNotNull("读取该客户支付信息失败", list);
		assertTrue("类型不匹配", list.get(0).getClass() == Payment.class);
		for(int i=0; i<list.size(); i++){
			Payment pay = (Payment) list.get(i);
			System.out.println(pay.getSum());
		}
	}
	//测试是否可以根据查询条件查询支付信息
	public void testQueryPayment(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add(5);
		IPageList pageList  = service.queryPayment("vdate>?", paras, 0, 15);
		List list=pageList.getResult();
		assertNotNull("读取该客户支付信息失败", list);		
		assertTrue("类型不匹配", list.get(0).getClass() == Payment.class);
		for(int i=0; i<list.size(); i++){
			Payment pay = (Payment) list.get(i);
			System.out.println(pay.getSum());
		}
	}
	//测试是否可以删除一笔支付信息
	public void testDelPayment(){
		Payment pay = service.getPayment(1l);
		assertNotNull("无支付信息", pay);
		assertTrue("删除失败", service.delPayment(pay));
		
	}
}