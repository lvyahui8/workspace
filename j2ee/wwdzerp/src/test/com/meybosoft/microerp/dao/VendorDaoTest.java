package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.domain.Vendor;

//��������������Ϣ
public class VendorDaoTest extends BaseEasyDBODaoTest {
	
	public void testAdd(){
		Vendor obj = new Vendor();
		obj.setId(1l);
		obj.setSn("sn");
		obj.setTitle("title");
		assertTrue("�޷���������������Ϣ", this.dao.save(obj));
	}
	
	public void testRead(){
		Vendor obj = (Vendor) this.dao.getBy(Vendor.class, "id", 1);
		assertNotNull("����Ϊ��", obj);
		assertEquals("��������", "sn", obj.getSn() );
	}
	public void testUpdate(){
		Vendor obj = (Vendor) this.dao.getBy(Vendor.class, "id", 1);
		assertNotNull("����Ϊ��", obj);
		obj.setTitle("new title");
		obj.setInputTime(new java.util.Date());
		assertTrue("����ʧ��", this.dao.update(obj));
	}
	
	public void testQuery(){
		java.util.Collection<Integer> paras = new java.util.ArrayList<Integer>();
		paras.add(1);
		java.util.List list = this.dao.query(Vendor.class, "id>=?", paras, 0, 15);
		assertNotNull("��ѯʧ��", list.size()>0);
		assertTrue("���Ͳ�ƥ��", list.get(0).getClass() == Vendor.class);
		for(int i=0; i<list.size(); i++){
			Vendor obj = (Vendor) list.get(i);
			System.out.println(obj.getTitle());
		}
	}
	
	public void testDel(){
		Vendor obj = (Vendor) this.dao.getBy(Vendor.class, "id", 1);
		assertNotNull("����Ϊ��", obj);
		assertTrue("ɾ������ʧ��", this.dao.del(obj));
	}
}
