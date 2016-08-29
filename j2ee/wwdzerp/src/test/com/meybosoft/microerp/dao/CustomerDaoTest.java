package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.domain.Customer;

public class CustomerDaoTest extends BaseEasyDBODaoTest{
	//测试是否能保存数据
	public void testAdd(){
		//创建父对象
		Customer parent = new Customer();	
		parent.setId(1l);
		parent.setSn("父编号");		
		parent.setTitle("父标题");
		
		//创建子对象
		Customer obj = new Customer();
		obj.setId(123l);
		obj.setSn("子编号");
		obj.setTitle("子标题");
		obj.setParent(parent);
		parent.getChildren().add(obj);
		
		
		assertTrue("无法保存父对象数据！", dao.save(parent));
		//assertTrue("无法保存子对象数据",this.dao.save(obj));
	}
	//测试是否能读取到数据
	public void testRead() {
		Customer obj = (Customer) this.dao.get(Customer.class,123);		
		assertNotNull(obj);
		assertEquals("编号不相等!", "父编号", obj.getParent().getSn());
		assertEquals("编号不相等!", "子编号", obj.getSn());
	}
	//测试是否能更新数据
	public void testUpdate() {
		Customer obj = (Customer) this.dao.get(Customer.class, 123);
		assertNotNull("数据为空",obj);
		obj.setTitle("新的子标题");
		obj.getParent().setTitle("新的父标题");
		assertTrue("保存子对象数据失败", this.dao.update(obj));	
		assertTrue("保存父对象数据失败", this.dao.update(obj.getParent()));
	}
	public void testQuery(){
		java.util.List list=this.dao.query(Customer.class,"1=1");
	
		assertNotNull(list);
		assertTrue("列表中没有数据!",list.size()>0);
		assertTrue("类型不匹配!",list.get(0).getClass() == Customer.class);	
	}
	public void testDel() {
		Customer obj = (Customer) this.dao.get(Customer.class, 123);
		assertNotNull("子对象为空！",obj);
		assertTrue("删除子对象数据失败", this.dao.del(obj));
		assertTrue("删除父对象数据失败", this.dao.del(obj.getParent()));
		
	}	
}
