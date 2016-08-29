package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.SystemDept;
import com.meybosoft.microerp.system.SystemUser;

public class SystemUserDaoTest extends BaseEasyDBODaoTest{
	//测试是否可以保存数据
	public void testAdd(){
		SystemUser obj = new SystemUser();
		obj.setId(1l);
		obj.setUserName("毛伟");
		obj.setPassword("13251114955");
		obj.setEmail("ksmwly@163.com");
		obj.setTel("52745244");
		obj.setInputTime(new java.util.Date());
		
		SystemDept sy = new SystemDept();
		sy.setSn("sn");
		assertTrue("添加部门失败", this.dao.save(sy));
		obj.setBelongDept(sy);
		
		assertTrue("保存数据失败",this.dao.save(obj));
	}
	//测试是否能读取出数据
	public void testRead(){
		SystemUser obj = (SystemUser) this.dao.get(SystemUser.class, 1);
		assertNotNull("无法读取出数据",obj);
	}
	//测试是否能更新数据
	public void testUpdate(){
		SystemUser obj = (SystemUser) this.dao.get(SystemUser.class, 1);
		assertNotNull("无法记取出数据",obj);
		obj.setPassword("1234567890");
		obj.setEmail("mwlovexmy@163.com");
		obj.setTel("52671163");
		obj.setInputTime(new java.util.Date());
		assertTrue("无法更新数据",this.dao.update(obj));
	}
	//测试表中有无数据
	public void testQuery(){
		java.util.List list = this.dao.query(SystemUser.class, "1=1");
		assertTrue("表中无数据",list.size()>0);
	}
	//测试是否可以删除指定数据
	public void testDel(){
		SystemUser obj = (SystemUser) this.dao.get(SystemUser.class, 1);
		assertTrue("删除部门失败", this.dao.del(obj.getBelongDept()));
		assertTrue("删除数据失败",this.dao.del(obj));
	}
}

