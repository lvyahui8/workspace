package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.domain.OrderDetail;
import com.meybosoft.microerp.domain.OrderInfo;
import com.meybosoft.microerp.domain.Product;

public class OrderDetailDaoTest extends BaseEasyDBODaoTest{
	//����д������
	public void testAdd(){
		OrderDetail obj = new OrderDetail();
		obj.setId(1l);
		obj.setNum(53243.6d);
		obj.setPrice(new java.math.BigDecimal(49.4));
		obj.setAmount(new java.math.BigDecimal(23));
		
		OrderInfo ord = new OrderInfo();
		ord.setSn("sn");
		ord.setAmount(new java.math.BigDecimal(45));
		assertTrue("���涨����Ϣʧ��", this.dao.save(ord));
		obj.setOrder(ord);
		
		Product pro = new Product();
		pro.setSn("sn");
		pro.setBuyPrice(new java.math.BigDecimal(523));
		pro.setSalePrice(new java.math.BigDecimal(352));
		assertTrue("�����Ʒ��Ϣʧ��", this.dao.save(pro));
		obj.setProduct(pro);
		
		assertTrue("��������ʧ��",dao.save(obj));
	}
	//���Զ�ȡ������
	public void testRead(){
		OrderDetail obj = (OrderDetail) this.dao.get(OrderDetail.class, 1);
		assertNotNull("û���������",obj);
	}
	//�����ܷ��������
	public void testUpdate(){
		OrderDetail obj = (OrderDetail) this.dao.get(OrderDetail.class, 1);
		obj.setNum(100.4d);
		//obj.setTitle("��д��ı���");
		assertNotNull("��������ʧ��",dao.update(obj));
	}
	//���Ա�����������
	public void testQuery(){
		java.util.List list = this.dao.query(OrderDetail.class, "1=1");
		assertTrue("����Ϊ��",list.size()>0);
	}
	//�����ܷ�ɾ������
	public void testDel(){
		OrderDetail obj = (OrderDetail) this.dao.get(OrderDetail.class, 1);
		assertNotNull("����Ϊ��", obj);
		assertTrue("ɾ��ʧ��",dao.del(obj));
		assertTrue("ɾ����������ʧ��", this.dao.del(obj.getOrder()));
		assertTrue("ɾ����Ʒ����ʧ��", this.dao.del(obj.getProduct()));
		
		
	}
}