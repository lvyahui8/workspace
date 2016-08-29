package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.domain.Product;
import com.meybosoft.microerp.domain.Vendor;
import com.meybosoft.microerp.system.SystemUser;

public class ProductDaoTest extends BaseEasyDBODaoTest {
	public void testAdd() {
		Product p = new Product();
		Vendor v = new Vendor();
		v.setSn("cu001");
		p.setId(1l);
		p.setSn("tx001");
		p.setVendor(v);
		p.setTitle("�ع�ˮ1");
		p.setSalePrice(new java.math.BigDecimal(34.2));
		p.setBuyPrice(new java.math.BigDecimal(45.2));
		
		SystemUser user = new SystemUser();
		user.setUserName("¼����");
		assertTrue("���Ա����Ϣʧ��", this.dao.save(user));
		p.setInputUser(user);
		
		assertTrue("�޷��������ݣ�", dao.save(p));
	}

	public void testRead() {
		Product p = (Product) this.dao.get(Product.class, "1");
		assertNotNull("����Ϊ��", p);
		assertEquals("��Ų����!", "tx001", p.getSn());
	}

	public void testUpdate() {
		Product p = (Product) this.dao.get(Product.class, "1");
		assertNotNull(p);
		p.setTitle("�µĲ�Ʒ");
		assertTrue("��������ʧ��!", this.dao.update(p));
		Product p2 = (Product) this.dao.getBy(Product.class, "title", "�µĲ�Ʒ");
		assertEquals("������ƷID�Ų����!", p.getSn(), p2.getSn());
	}
	public void testQuery()
	{
		java.util.List list=this.dao.query(Product.class,"1=1");
		assertNotNull(list);
		assertTrue("�б���û������!",list.size()>0);
		assertTrue("���Ͳ�ƥ��!",list.get(0).getClass()==Product.class);
	}
	public void testDel() {
		Product p = (Product) this.dao.get(Product.class, "1");
		assertNotNull(p);
		assertTrue("ɾ��Ա����Ϣʧ��", this.dao.del(p.getInputUser()));
		assertTrue("ɾ������ʧ��", this.dao.del(p));
		
		Product p2 = (Product) this.dao.get(Product.class, "p001");
		assertNull("���ݻ�û��ɾ��", p2);
	}	
}
