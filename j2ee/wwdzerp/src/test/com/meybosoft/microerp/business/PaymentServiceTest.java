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
	//�����Ƿ�������һ��֧����Ϣ
	public void testAddPayment(){
		Payment pay = new Payment();
		pay.setId(1l);
		pay.setVdate(new java.util.Date());
		pay.setSum(new java.math.BigDecimal(10));
	
		Customer parent_cu = service1.getCustomer(1l);
		assertNotNull("������(�ͻ�)Ϊ��", parent_cu);	
		pay.setCustomer(parent_cu);
		
		OrderInfo parent_or = service2.getOrder(1l);
		assertNotNull("������(��Ʒ)Ϊ��", parent_or);		
		
		assertTrue("���һ��֧����Ϣʧ��", service.addPayment(pay));

	}
	//�����Ƿ�����޸�һ��֧����Ϣ
	public void testUpdatePayment(){
		Payment pay = service.getPayment(1l);
		assertNotNull("֧����Ϣ������",pay);
		pay.setSum(new java.math.BigDecimal(12));
		assertTrue("�޸�֧����Ϣʧ��",service.updatePayment(pay));	
	}
	//�����Ƿ����ͨ��id��ѯһ��֧����Ϣ
	public void testGetPayment(){
		Payment pay = service.getPayment(1l);
		assertNotNull(pay);
		assertEquals("�ͻ��������", "test", pay.getCustomer().getSn());
		
		Payment payment = service.getPayment(234l);
		assertNull("ָ��ID��֧����Ϣ������",payment);
	}
	//�����Ƿ���Է���һ�ʶ���������֧����Ϣ
	public void testGetPayment_OrderInfo(){
		OrderInfo order = service2.getOrder(1l);
		java.util.List list = service.getOrderPayment(order);
		assertNotNull("�ñʶ�������֧����Ϣ", list);
		assertTrue("���Ͳ�ƥ��", list.get(0).getClass() == Payment.class);
		for(int i=0; i<list.size(); i++){
			Payment pay = (Payment) list.get(i);
			System.out.println(pay.getSum());
		}
		
		//java.util.List list = service.getPayment(ord);
		//assertNotNull("�ñʶ�������֧����Ϣ", list);
	}
	//�����Ƿ���Է���һ���ͻ�������֧����Ϣ
	public void testGetPayment_Customer(){
		Customer cust = service1.getCustomerBySn("test");		
		java.util.List list = service.getCustomerPayment(cust);
		assertNotNull("��ȡ�ÿͻ�֧����Ϣʧ��", list);
		assertTrue("���Ͳ�ƥ��", list.get(0).getClass() == Payment.class);
		for(int i=0; i<list.size(); i++){
			Payment pay = (Payment) list.get(i);
			System.out.println(pay.getSum());
		}
	}
	//�����Ƿ���Ը��ݲ�ѯ������ѯ֧����Ϣ
	public void testQueryPayment(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add(5);
		IPageList pageList  = service.queryPayment("vdate>?", paras, 0, 15);
		List list=pageList.getResult();
		assertNotNull("��ȡ�ÿͻ�֧����Ϣʧ��", list);		
		assertTrue("���Ͳ�ƥ��", list.get(0).getClass() == Payment.class);
		for(int i=0; i<list.size(); i++){
			Payment pay = (Payment) list.get(i);
			System.out.println(pay.getSum());
		}
	}
	//�����Ƿ����ɾ��һ��֧����Ϣ
	public void testDelPayment(){
		Payment pay = service.getPayment(1l);
		assertNotNull("��֧����Ϣ", pay);
		assertTrue("ɾ��ʧ��", service.delPayment(pay));
		
	}
}