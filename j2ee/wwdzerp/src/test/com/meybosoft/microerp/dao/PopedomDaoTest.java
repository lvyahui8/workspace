package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.Popedom;

public class PopedomDaoTest extends BaseEasyDBODaoTest{
	//测试是否能保存数据
	public void testAdd(){
		//父权限
		Popedom parent = new Popedom();
		parent.setId(1);
		parent.setTitle("父标题");
		parent.setIntro("父简介");
		//子权限
		Popedom obj = new Popedom();
		obj.setId(111);
		obj.setTitle("子标题");
		obj.setIntro("子简介");
		obj.setParent(parent);
		parent.getChildren().add(obj);//指明父权限的子权限是obj
		
		assertTrue("保存父对象失败",this.dao.save(parent));
	}
	//测试是否能读取到父对象和子对象
	public void testRead(){
		Popedom obj = (Popedom) this.dao.get(Popedom.class, 111);
		assertNotNull("子对象不存在",obj);
		assertNotNull("父对象不存在",obj.getParent());
		assertEquals("子对象数据有误",111l,obj.getId());
		assertEquals("父对象数据有误", 1l, obj.getParent().getId());
	}
	//测试是否能更新数据
	public void testUpdate(){
		Popedom obj = (Popedom)this.dao.getBy(Popedom.class, "id", "111");
		assertNotNull("子对象不存在",obj);
		obj.setTitle("更改后的子标题");
		obj.setIntro("更改后的子简介");
		assertTrue("更新子对象失败",this.dao.update(obj));
		obj.getParent().setTitle("更新后的父标题");
		assertTrue("更新父对象失败",this.dao.update(obj));
	}
	//测试数据表中数据是否为空
	public void testQuery(){
		java.util.List list = this.dao.query(Popedom.class, "1=1");
		assertTrue("表中数据为空",list.size()>0);
		assertTrue("类型不匹配", list.get(0).getClass() == Popedom.class);
		for(int i=0; i<list.size(); i++){
			Popedom pop = (Popedom) list.get(i);
			System.out.println(pop.getTitle());
		}
	}
	//测试是否能删除指定数据
	public void testDel(){
		Popedom obj = (Popedom) this.dao.get(Popedom.class, 1);
		assertNotNull("子对象不存在",obj);
		assertTrue("删除数据失败",this.dao.del(obj));
		//删除父对象同时也删除了子对象
	}

}
