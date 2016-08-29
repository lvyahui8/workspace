package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.OrderInfo;
import com.meybosoft.microerp.domain.Payment;

public class PaymentDaoTest extends BaseEasyDBODaoTest{
	//�����Ƿ��ܱ�������
	public void testAdd(){
		Payment obj = new Payment();
		obj.setId(1l);
		obj.setSum(new java.math.BigDecimal(3534));
		obj.setVdate(new java.util.Date());
		
		Customer cu = new Customer();
		cu.setSn("sn");
		cu.setTitle("title");
		assertTrue("����û���Ϣʧ��", this.dao.save(cu));
		obj.setCustomer(cu);
		
		OrderInfo ord = new OrderInfo();
		ord.setSn("sn");
		ord.setAmount(new java.math.BigDecimal(523));
		assertTrue("��Ӷ�����Ϣʧ��", this.dao.save(ord));
			
		assertTrue("�޷��洢����", this.dao.save(obj));
	}
	//���Զ�ȡ������
	public void testRead(){
		Payment obj = (Payment) this.dao.getBy(Payment.class, "id", 1);
		assertNotNull("�޷�ȡ������",obj);
		System.out.println(obj.getVdate());
	}
	//���Ը�������
	public void testUpdate(){
		Payment obj = (Payment) this.dao.get(Payment.class, 1);
		assertNotNull("ԭ���ݲ�����", obj);
		assertTrue("���Ͳ�ƥ��", obj.getClass() == Payment.class);
		obj.setSum(new java.math.BigDecimal(12345678));
		obj.setVdate(new java.util.Date());
		assertNotNull("��������ʧ��",dao.update(obj));
	}
	//���Ա�����������
	public void testQuery(){
		java.util.List list = this.dao.query(Payment.class, "1=1");
		assertTrue("����������",list.size()>0);
		for(int i=0; i<list.size(); i++){
			Payment p=(Payment)list.get(i);
			System.out.println(p.getSum());
		}
	}
	//�����Ƿ���ɾ������
	public void testDel(){
		Payment obj = (Payment) this.dao.get(Payment.class, 1);
		assertNotNull("����Ϊ��", obj);
		
		assertTrue("ɾ���ͻ�ʧ��", this.dao.del(obj.getCustomer()));
	//	assertTrue("ɾ������ʧ��", this.dao.del(obj.getOrder()));
		assertTrue("ɾ������ʧ��",this.dao.del(obj));
		
		assertNull("û�б�ɾ��", this.dao.get(Payment.class, 1));
	}
}
