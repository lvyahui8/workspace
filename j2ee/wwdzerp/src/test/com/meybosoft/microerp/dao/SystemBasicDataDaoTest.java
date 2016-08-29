package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.SystemDictionary;
import com.meybosoft.microerp.system.SystemDictionaryDetail;

public class SystemBasicDataDaoTest extends BaseEasyDBODaoTest {
	public void testAdd()
	{
		SystemDictionary obj=new SystemDictionary();
		obj.setId(1l);
		obj.setSn("test");
		obj.setTitle("标题");
		obj.setIntro("这是简介");
		
		SystemDictionaryDetail c=new SystemDictionaryDetail();
		c.setTitle("t");
		c.setTvalue("1");
		c.setParent(obj); //字典值的父级为obj
		
		SystemDictionaryDetail c1=new SystemDictionaryDetail();
		c1.setTitle("男");
		c1.setTvalue("man");
		c1.setParent(obj); //字典值的父级为obj
		
		obj.getChildren().add(c); //字典的字典值为c
		obj.getChildren().add(c1);//字典的字典值为c
		
		assertTrue("无法保存数据!",this.dao.save(obj));
	}
	public void testRead()
	{			
		SystemDictionary obj=(SystemDictionary)this.dao.getBy(SystemDictionary.class,"sn","test");
		assertNotNull(obj);
		assertEquals("编号不相等!","标题",obj.getTitle());
		assertNotNull("字段为空",obj.getChildren());
		assertTrue("为空",obj.getChildren().size()>0);
		for(int i=0;i<obj.getChildren().size();i++)
		{
			java.util.Iterator it=obj.getChildren().iterator();
			while(it.hasNext())
			{
				SystemDictionaryDetail c=(SystemDictionaryDetail)it.next();			
			}
		}
	}
	public void testUpdate() {	
		SystemDictionary obj=(SystemDictionary)this.dao.getBy(SystemDictionary.class, "sn","test");	
		assertNotNull(obj);
		assertFalse("新标题".equals(obj.getTitle()));
		obj.setTitle("新标题");
		this.dao.update(obj);
		SystemDictionary obj1=(SystemDictionary)this.dao.getBy(SystemDictionary.class, "sn","test");
		assertTrue("新标题".equals(obj1.getTitle()));	
	}
	public void testQuery(){
		java.util.List list = this.dao.query(SystemDictionary.class, "1=1");
		assertTrue("数据为空",list.size()>0);		
	}
	public void testDel()
	{
		SystemDictionary obj=(SystemDictionary)this.dao.get(SystemDictionary.class, 1l);
		assertNotNull("数据为空", obj);
		assertTrue("删除不成功！",this.dao.del(obj));
	}
}
