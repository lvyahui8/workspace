package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.SystemDictionary;
import com.meybosoft.microerp.system.SystemDictionaryDetail;

//测试字典值
public class SystemBasicDataDetailDaoTest extends BaseEasyDBODaoTest {
	public void testAdd()
	{
		SystemDictionaryDetail obj=new SystemDictionaryDetail();
		obj.setId(123l);
		obj.setTitle("标题");
		
		//得到一个父对象
		SystemDictionary parent = new SystemDictionary();
		parent.setSn("sn");
		assertTrue("保存父对象失败", this.dao.save(parent));
		obj.setParent(parent);

		assertTrue("无法保存数据!",this.dao.save(obj));
	}
	public void testRead()
	{
		SystemDictionaryDetail obj=(SystemDictionaryDetail)this.dao.get(SystemDictionaryDetail.class, 123l);		
		assertNotNull(obj);
		assertNotNull(obj.getParent());
		assertEquals("标题不相等!","标题",obj.getTitle());
		assertEquals("父编号错误", "sn" ,obj.getParent().getSn());
	}
	public void testUpdate() {	
		SystemDictionaryDetail obj=(SystemDictionaryDetail)this.dao.get(SystemDictionaryDetail.class, 123l);	
		assertNotNull(obj);
		assertFalse("新标题".equals(obj.getTitle()));
		obj.setTitle("新标题");
		this.dao.update(obj);
		SystemDictionaryDetail obj1=(SystemDictionaryDetail)this.dao.get(SystemDictionaryDetail.class,123l);
		assertTrue("新标题".equals(obj1.getTitle()));	
	}
	public void testDel()
	{
		SystemDictionaryDetail obj=(SystemDictionaryDetail)this.dao.get(SystemDictionaryDetail.class, 123l);
		assertNotNull("数据为空", obj);
		assertTrue("删除子对象不成功！",this.dao.del(obj));
		assertTrue("删除父对象不成功！",this.dao.del(obj.getParent()));
	}
}
