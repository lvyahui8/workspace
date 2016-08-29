package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.domain.Vendor;

//测试生产厂家信息
public class VendorDaoTest extends BaseEasyDBODaoTest {
	
	public void testAdd(){
		Vendor obj = new Vendor();
		obj.setId(1l);
		obj.setSn("sn");
		obj.setTitle("title");
		assertTrue("无法保存生产厂家信息", this.dao.save(obj));
	}
	
	public void testRead(){
		Vendor obj = (Vendor) this.dao.getBy(Vendor.class, "id", 1);
		assertNotNull("数据为空", obj);
		assertEquals("数据有误", "sn", obj.getSn() );
	}
	public void testUpdate(){
		Vendor obj = (Vendor) this.dao.getBy(Vendor.class, "id", 1);
		assertNotNull("数据为空", obj);
		obj.setTitle("new title");
		obj.setInputTime(new java.util.Date());
		assertTrue("更新失败", this.dao.update(obj));
	}
	
	public void testQuery(){
		java.util.Collection<Integer> paras = new java.util.ArrayList<Integer>();
		paras.add(1);
		java.util.List list = this.dao.query(Vendor.class, "id>=?", paras, 0, 15);
		assertNotNull("查询失败", list.size()>0);
		assertTrue("类型不匹配", list.get(0).getClass() == Vendor.class);
		for(int i=0; i<list.size(); i++){
			Vendor obj = (Vendor) list.get(i);
			System.out.println(obj.getTitle());
		}
	}
	
	public void testDel(){
		Vendor obj = (Vendor) this.dao.getBy(Vendor.class, "id", 1);
		assertNotNull("数据为空", obj);
		assertTrue("删除数据失败", this.dao.del(obj));
	}
}
