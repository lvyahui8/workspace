package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.Role;

public class RoleDaoTest extends BaseEasyDBODaoTest{
	//测试是否能保存数据
	public void testAdd(){
		Role obj = new Role();
		obj.setId(1l);
		obj.setSn("编号");
		obj.setIntro("这是第一个简介");
		obj.setTitle("这是第一个标题");
		obj.setStatus(342);
		assertTrue("无法保存数据",this.dao.save(obj));
	}
	//测试是否能读取出数据
	public void testRead(){
		Role obj = (Role) this.dao.get(Role.class, 1);
		assertNotNull("指定数据在表中不存在",obj);
	}
	//测试是否能更新数据
	public void testUpdate(){
		Role obj = (Role) this.dao.get(Role.class, 1);
		obj.setTitle("更新后的第一个标题");
		obj.setIntro("更新后的简介");
		assertTrue("更新数据失败",this.dao.update(obj));
	}
	//测试表是否有数据存在
	public void testQuery(){
		java.util.List list = this.dao.query(Role.class, "1=1");
		assertNotNull("表中数据为空",list.size()>0);
		assertTrue("类型不匹配", list.get(0).getClass() == Role.class);
	}
	//测试是否能删除指定数据
	public void testDel(){
		Role obj = (Role) this.dao.get(Role.class, 1);
		assertNotNull("数据为空", obj);
		assertNotNull("删除数据失败",this.dao.del(obj));
	}
}
