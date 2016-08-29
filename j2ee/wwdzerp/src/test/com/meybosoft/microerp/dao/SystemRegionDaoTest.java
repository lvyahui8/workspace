package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.SystemRegion;

public class SystemRegionDaoTest extends BaseEasyDBODaoTest {
	public void testAdd(){
		
		SystemRegion parent = new SystemRegion();
		parent.setSn("0000000");
		
		SystemRegion parent1 = new SystemRegion();
		parent1.setId(379l);
		parent1.setSn("0000035");
		parent1.setParent(parent);
		parent1.setInputTime(new java.util.Date());
		parent1.setInputUser("毛伟");
		parent1.setTitle("美国");
		parent1.setLev(new Integer(1));	//指明是国外
		
		SystemRegion obj = new SystemRegion();
		obj.setId(380l);
		obj.setSn("0000035000001");
		obj.setInputTime(new java.util.Date());
		obj.setInputUser("毛伟");
		obj.setTitle("纽约");
		obj.setLev(new Integer(1));	//指明是国外
		obj.setParent(parent1);	//得到父级编号
		
		parent1.getChildren().add(obj); //通过父得到子
				
		assertTrue("保存数据失败",this.dao.save(parent1));
	}
	//测试是否能读取出数据
	public void testRead(){
		SystemRegion obj = (SystemRegion) this.dao.getBy(SystemRegion.class, "title", "纽约");
		assertNotNull("无法读取出数据",obj);
		assertEquals("数据不匹配", "0000035", obj.getParent().getSn());
	}
	//测试是否能更新数据
	public void testUpdate(){
		SystemRegion obj = (SystemRegion) this.dao.getBy(SystemRegion.class, "id", "379");
		assertNotNull("数据为空", obj);
		obj.setInputTime(new java.util.Date());		
		obj.setTitle("法国");
		System.out.println(obj.getChildren().size());
		assertTrue("更新数据失败",this.dao.update(obj));
	}
	//测试表中数据是否为空
	public void testQuery(){
		java.util.List list = this.dao.query(SystemRegion.class, "lev=1",null,0,15);
		assertTrue("表中无数据",list.size()>0);
		assertTrue(list.size()<=15);
		String s="";
		for(int i=0;i<list.size();i++)
		{
			SystemRegion region=(SystemRegion)list.get(i);
			s+=region+"\n";
		}
		System.out.println(s);
	}
	//测试是否可以删除指定数据
	public void testDel(){
		SystemRegion obj = (SystemRegion) this.dao.getBy(SystemRegion.class, "sn","0000035");
		assertNotNull("数据为空", obj);
		assertTrue("删除失败",this.dao.del(obj));
	}
}
