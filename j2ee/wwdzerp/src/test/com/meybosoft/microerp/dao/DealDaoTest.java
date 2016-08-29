package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.Deal;
import com.meybosoft.microerp.domain.OrderInfo;

//���Խ���
public class DealDaoTest extends BaseEasyDBODaoTest{
	//���������Ƿ��ܱ���
	public void testAdd(){
		Deal obj = new Deal();
		obj.setId(1l);
		obj.setSum(new java.math.BigDecimal(10));
		
		Customer cu = new Customer();
		cu.setSn("sn");
		cu.setTitle("title");
		assertTrue("����ͻ�ʧ��", this.dao.save(cu));
		obj.setCustomer(cu);
		
		OrderInfo ord = new OrderInfo();
		ord.setSn("sn");
		ord.setAmount(new java.math.BigDecimal(6787));
		assertTrue("����ͻ�ʧ��", this.dao.save(ord));
		obj.setOrder(ord);
		
		assertTrue("�޷���������", this.dao.save(obj));
	}
	//���Զ�ȡ������
	public void testRead(){
		Deal obj = (Deal) this.dao.get(Deal.class, 1);
		assertNotNull("û���������",obj);
	}
	//�����Ƿ��ܸ�������
	public void testUpdate(){
		Deal obj = (Deal) this.dao.get(Deal.class, 1);
		obj.setSum(new java.math.BigDecimal(532432423));
		obj.setDealType(3444444);
		assertTrue("��������ʧ��",this.dao.update(obj));
	}
	//���Ա����Ƿ�������
	public void testQuery(){
		java.util.List list = this.dao.query(Deal.class, "1=1");
		assertNotNull(list);
		assertTrue("����������",list.size()>0);
		assertTrue("����ͬһ��",list.get(0).getClass()==Deal.class);
	}
	//�����Ƿ���ɾ������
	public void testDel(){
		Deal obj = (Deal) this.dao.get(Deal.class, 1);
		assertNotNull("����Ϊ��", obj);
		assertTrue("ɾ���ͻ���Ϣʧ��", this.dao.del(obj.getCustomer()));
		assertTrue("ɾ��������Ϣʧ��", this.dao.del(obj.getOrder()));
		assertTrue("ɾ��ʧ��",this.dao.del(obj));
	}
	
}