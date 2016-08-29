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
	//�����Ƿ����������
	public void testAddOrder(){
		OrderInfo ord = new OrderInfo();
		ord.setSn(null);
		ord.setVdate(new java.util.Date());
		try{
			service.addOrder(ord);
			fail("��Ų���Ϊ��");	
		}
		catch(LogicException e){
		}
		ord.setId(new Long(1));
		ord.setSn("�������");
		ord.setVdate(new java.util.Date());
		ord.setLinkMan("ëΰ");
		assertTrue("���Ӷ���ʧ��", service.addOrder(ord));
		
		OrderInfo ord2 = new OrderInfo();
		ord2.setSn("�������");
		try{
			service.addOrder(ord2);
			fail("������ӱ����ͬ�Ķ���!");
		}
		catch(LogicException e){
		}
	}
	//�����Ƿ�����޸Ķ�����Ϣ
	public void testUpdateOrder(){
		OrderInfo ord =  service.getOrder(1l);
		assertNotNull("�������ݲ�����", ord);
		ord.setLinkMan("ë��ΰ");
		ord.setTel("13251114955");
		assertTrue("���¶���ʧ��", service.updateOrder(ord));		
	}
	//�����Ƿ���Ը���id�õ�������Ϣ
	public void testGetOrderId(){
		OrderInfo ord = service.getOrder(1l);
		assertNotNull("����������",ord);
		
	}
	//�����Ƿ���Ը���sn�õ�������Ϣ
	public void testGetOrderSn(){
		OrderInfo ord = service.getOrderBySn("�������");
		assertNotNull("����������",ord);
	}
	//�����Ƿ���Ը��ݲ�ѯ������ѯ������Ϣ
	public void testQueryOrder(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add(10);
		paras.add(100);
		paras.add(new java.util.Date());
		IPageList pageList= service.queryOrder("id>? and id<? and vdata>?", paras, 0, 15);
		assertNotNull("��ѯʧ��",pageList);
	}	
	//�����Ƿ����ɾ��������Ϣ
	public void testDelOrder(){
		OrderInfo ord = service.getOrderBySn("�������");
		assertNotNull("����������", ord);
		assertNull("ɾ������ʧ��", service.delOrder(ord));
	}
	//�����Ƿ������Ӷ�����ϸ�б����
	public void testAddOrderDetail(){
		OrderDetail detail = new OrderDetail();
		detail.setId(new Long(1));
		detail.setTypes("����");
		detail.setUnit("ƽ����");
		detail.setAmount(new java.math.BigDecimal(3));
		detail.setTypes("����");
		detail.setUnit("ƽ����");
		detail.setAmount(new java.math.BigDecimal(3));
		
		OrderInfo order = service.getOrder(1l);
		assertNotNull("��(����)Ϊ��", order);
		detail.setOrder(order);
		Product prd = service2.getProduct(1l);
		assertNotNull("��(��Ʒ)Ϊ��", prd);
		detail.setProduct(prd);	

		assertTrue("��Ʒ���ʧ��",service.addOrderDetail(detail));	
	}
	//�����Ƿ�����޸Ķ�����ϸ�б����
	public void testUpdateOrderDetail(){
		OrderInfo order = service.getOrder(1l);
		java.util.Iterator<OrderDetail> it = order.getChildren().iterator();
		OrderDetail detail=it.next();
		detail.setNum(23.32);
		detail.setWidth(23.3f);
		assertTrue("�޸�ʧ��", service.updateOrderDetail(it.next()));
		
	}
	//�����Ƿ�Ҫ��ɾ��������ϸ�б����
	public void testDelOrderDetail(){
		OrderInfo order = service.getOrder(1l);		
		java.util.Iterator<OrderDetail> it=order.getChildren().iterator();
		while(it.hasNext())
		assertTrue("ɾ��ʧ��", service.delOrderDetail(it.next()));
	}
}
