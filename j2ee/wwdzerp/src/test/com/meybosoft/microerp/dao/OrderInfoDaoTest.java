package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.OrderDetail;
import com.meybosoft.microerp.domain.OrderInfo;

public class OrderInfoDaoTest extends BaseEasyDBODaoTest{
	public void testAdd(){
		OrderInfo obj = new OrderInfo();
		obj.setId(1l);
		obj.setSn("c001");
		obj.setAmount(new java.math.BigDecimal(23));
		
		Customer cu = new Customer();
		cu.setSn("sn");
		cu.setTitle("title");
		assertTrue("�޷�����ͻ���Ϣ", this.dao.save(cu));
		obj.setCustomer(cu);
		
		OrderDetail ord = new OrderDetail();
		ord.setPrice(new java.math.BigDecimal(3254));
		ord.setAmount(new java.math.BigDecimal(565));
		ord.setOrder(obj);
		//assertTrue("�޷����涨����ϸ��Ϣ", this.dao.save(ord));
		
		obj.getChildren().add(ord);
		assertTrue("�����޷�����",dao.save(obj));
	}
	
	public void testRead(){
		OrderInfo obj = (OrderInfo) this.dao.getBy(OrderInfo.class, "sn", "c001");
		java.util.Iterator it=obj.getChildren().iterator();		
		assertNotNull("������Ϊ��",obj);
		assertEquals("�����ֵ�����","c001",obj.getSn());		
	}
	
	public void testUpdate(){
		OrderInfo obj = (OrderInfo) this.dao.get(OrderInfo.class, "1");
		assertNotNull("����Ϊ��",obj);
		assertTrue("���Ͳ�ƥ��", obj.getClass() == OrderInfo.class);
		obj.setTel("13251114955");
		assertTrue("��������ʧ��!", this.dao.update(obj));
		OrderInfo p2 = (OrderInfo) this.dao.getBy(OrderInfo.class, "tel","13251114955");
		assertEquals("���������źŲ����!", obj.getSn(), p2.getSn());
	}

	public void testQuery()
	{
		java.util.List list=this.dao.query(OrderInfo.class,"1=1");
		assertNotNull(list);
		assertTrue("�б���û������!",list.size()>0);
		assertTrue("���Ͳ�ƥ��!",list.get(0).getClass()==OrderInfo.class);				
	}
	
	public void testDel() {
		OrderInfo obj = (OrderInfo) this.dao.get(OrderInfo.class, 1);
		assertNotNull("����Ϊ�գ�",obj);
		
		assertTrue("ɾ���ͻ���Ϣʧ��", this.dao.del(obj.getCustomer()));
		//ɾ������,�����µĶ�����ϸ�б���Զ�ɾ��
		assertTrue("ɾ��������Ϣʧ��", this.dao.del(obj));
		
		OrderInfo p2 = (OrderInfo) this.dao.get(OrderInfo.class, "1");
		assertNull("���ݲ�Ϊ��", p2);
	}
}
