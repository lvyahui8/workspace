package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.domain.Customer;

public class CustomerDaoTest extends BaseEasyDBODaoTest{
	//�����Ƿ��ܱ�������
	public void testAdd(){
		//����������
		Customer parent = new Customer();	
		parent.setId(1l);
		parent.setSn("�����");		
		parent.setTitle("������");
		
		//�����Ӷ���
		Customer obj = new Customer();
		obj.setId(123l);
		obj.setSn("�ӱ��");
		obj.setTitle("�ӱ���");
		obj.setParent(parent);
		parent.getChildren().add(obj);
		
		
		assertTrue("�޷����游�������ݣ�", dao.save(parent));
		//assertTrue("�޷������Ӷ�������",this.dao.save(obj));
	}
	//�����Ƿ��ܶ�ȡ������
	public void testRead() {
		Customer obj = (Customer) this.dao.get(Customer.class,123);		
		assertNotNull(obj);
		assertEquals("��Ų����!", "�����", obj.getParent().getSn());
		assertEquals("��Ų����!", "�ӱ��", obj.getSn());
	}
	//�����Ƿ��ܸ�������
	public void testUpdate() {
		Customer obj = (Customer) this.dao.get(Customer.class, 123);
		assertNotNull("����Ϊ��",obj);
		obj.setTitle("�µ��ӱ���");
		obj.getParent().setTitle("�µĸ�����");
		assertTrue("�����Ӷ�������ʧ��", this.dao.update(obj));	
		assertTrue("���游��������ʧ��", this.dao.update(obj.getParent()));
	}
	public void testQuery(){
		java.util.List list=this.dao.query(Customer.class,"1=1");
	
		assertNotNull(list);
		assertTrue("�б���û������!",list.size()>0);
		assertTrue("���Ͳ�ƥ��!",list.get(0).getClass() == Customer.class);	
	}
	public void testDel() {
		Customer obj = (Customer) this.dao.get(Customer.class, 123);
		assertNotNull("�Ӷ���Ϊ�գ�",obj);
		assertTrue("ɾ���Ӷ�������ʧ��", this.dao.del(obj));
		assertTrue("ɾ������������ʧ��", this.dao.del(obj.getParent()));
		
	}	
}
