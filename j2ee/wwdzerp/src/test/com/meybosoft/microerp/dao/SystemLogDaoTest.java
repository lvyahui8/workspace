package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.SystemLog;

public class SystemLogDaoTest extends BaseEasyDBODaoTest{
	//测试是否能保存数据
	public void testAdd(){
		SystemLog obj = new SystemLog();
		obj.setId(1);
		obj.setUserName("毛伟");
		obj.setIp("10.0.0.138");
		obj.setIntro("简介");
		obj.setVdate(new java.util.Date());
		assertTrue("保存数据失败",this.dao.save(obj));
	}
	//测试是否能读取出数据
	public void testRead(){
		SystemLog obj = (SystemLog) this.dao.get(SystemLog.class,1);
		assertNotNull("指定数据不存在",obj);
	}
	//测试是否能更新数据
	public void testUpdate(){
		SystemLog obj = (SystemLog) this.dao.get(SystemLog.class, 1);
		assertNotNull(obj);
		obj.setUserName("金麦草软件");
		obj.setIntro("新简介");
		obj.setVdate(new java.util.Date());
		assertTrue("更新数据失败",this.dao.update(obj));
	}
	//测试表中是否有数据
	public void testQuery(){
		java.util.List list = this.dao.query(SystemLog.class, "1=1");
		assertTrue("表中数据为空",list.size()>0);
	}
	//测试是否能删除表中数据
	public void testDel(){
		SystemLog obj = (SystemLog) this.dao.get(SystemLog.class, 1);
		assertNotNull("数据为空", obj);
		assertTrue("删除数据失败",this.dao.del(obj));
	}
}
