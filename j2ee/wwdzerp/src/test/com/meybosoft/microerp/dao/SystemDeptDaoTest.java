package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.SystemDept;

public class SystemDeptDaoTest extends BaseEasyDBODaoTest{
	//测试是否能保存数据
	public void testAdd(){
		SystemDept obj = new SystemDept();
		obj.setId(1);
		obj.setSn("编号one");
		obj.setTitle("标题");
		obj.setAddress("重庆市开县人民政府");
		obj.setTel("13251114955");
		obj.setEmail("ksmwly@163.com");
		assertTrue("保存数据失败",this.dao.save(obj));
	}
	//测试是否能读取出数据
	public void testRead(){
		SystemDept obj = (SystemDept) this.dao.get(SystemDept.class, 1);
		assertNotNull("读取数据失败",obj);
		assertEquals("客户电话有误","13251114955",obj.getTel());
	}
	//测试是否能更新数据
	public void testUpdate(){
		SystemDept obj = (SystemDept) this.dao.get(SystemDept.class, 1);
		assertNotNull("无客户资料",obj);
		obj.setSn("编号一");
		obj.setAddress("金麦草科技");
		assertTrue("更新客户资料失败",this.dao.update(obj));
	}
	//测试表中是否有客户数据
	public void testQuery(){
		java.util.List list = this.dao.query(SystemDept.class, "1=1");
		assertTrue("表中无数据",list.size()>0);
		for(int i=0; i<list.size(); i++){
			SystemDept obj = (SystemDept) list.get(i);
			System.out.println("客户电邮为:" + obj.getEmail());
		}
	}
	//测试是否能删除客户资料
	public void testDel(){
		SystemDept obj = (SystemDept) this.dao.getBy(SystemDept.class, "tel","13251114955");
		assertNotNull(obj);
		assertTrue("删除失败",this.dao.del(obj));
	}
}
