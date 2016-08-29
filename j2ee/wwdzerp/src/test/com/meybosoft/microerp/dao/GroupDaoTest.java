package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.Group;

public class GroupDaoTest extends BaseEasyDBODaoTest{
	//测试是否能保存数据
	public void testAdd(){
		Group obj = new Group();
		obj.setId(1);
		obj.setIntro(444520);
		obj.setTitle("第一个标题");
		assertTrue("保存数据失败",this.dao.save(obj));
	}
	//测试是否能读取数据
	public void testRead(){
		Group obj = (Group) this.dao.get(Group.class, 1);
		assertNotNull("数据为空",obj);
	}
	//测试是否能更新数据
	public void testUpdate(){
		Group obj = (Group) this.dao.get(Group.class, 1);
		obj.setTitle("更新了这个标题");
		obj.setIntro(43534);
		assertTrue("无法更新数据",this.dao.update(obj));
	}
	//测试表中数据是否为空
	public void testQuery(){
		java.util.List list = this.dao.query(Group.class, "1=1");
		assertTrue("表数据为空",list.size()>0);
	}
	//测试是否能删除指定数据
	public void testDel(){
		Group obj = (Group) this.dao.get(Group.class, 1);
		assertNotNull("数据为空", obj);
		assertTrue("无法删除指定数据",this.dao.del(obj));
	}
}