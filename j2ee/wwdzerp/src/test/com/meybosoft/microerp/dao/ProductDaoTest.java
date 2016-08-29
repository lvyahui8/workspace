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
		p.setTitle("回归水1");
		p.setSalePrice(new java.math.BigDecimal(34.2));
		p.setBuyPrice(new java.math.BigDecimal(45.2));
		
		SystemUser user = new SystemUser();
		user.setUserName("录入人");
		assertTrue("添加员工信息失败", this.dao.save(user));
		p.setInputUser(user);
		
		assertTrue("无法保存数据！", dao.save(p));
	}

	public void testRead() {
		Product p = (Product) this.dao.get(Product.class, "1");
		assertNotNull("数据为空", p);
		assertEquals("编号不相等!", "tx001", p.getSn());
	}

	public void testUpdate() {
		Product p = (Product) this.dao.get(Product.class, "1");
		assertNotNull(p);
		p.setTitle("新的产品");
		assertTrue("保存数据失败!", this.dao.update(p));
		Product p2 = (Product) this.dao.getBy(Product.class, "title", "新的产品");
		assertEquals("两个产品ID号不相等!", p.getSn(), p2.getSn());
	}
	public void testQuery()
	{
		java.util.List list=this.dao.query(Product.class,"1=1");
		assertNotNull(list);
		assertTrue("列表中没有数据!",list.size()>0);
		assertTrue("类型不匹配!",list.get(0).getClass()==Product.class);
	}
	public void testDel() {
		Product p = (Product) this.dao.get(Product.class, "1");
		assertNotNull(p);
		assertTrue("删除员工信息失败", this.dao.del(p.getInputUser()));
		assertTrue("删除数据失败", this.dao.del(p));
		
		Product p2 = (Product) this.dao.get(Product.class, "p001");
		assertNull("数据还没被删除", p2);
	}	
}
