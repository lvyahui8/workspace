package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.SystemDictionary;
import com.meybosoft.microerp.system.SystemDictionaryDetail;

public class SystemBasicDataDaoTest extends BaseEasyDBODaoTest {
	public void testAdd()
	{
		SystemDictionary obj=new SystemDictionary();
		obj.setId(1l);
		obj.setSn("test");
		obj.setTitle("����");
		obj.setIntro("���Ǽ��");
		
		SystemDictionaryDetail c=new SystemDictionaryDetail();
		c.setTitle("t");
		c.setTvalue("1");
		c.setParent(obj); //�ֵ�ֵ�ĸ���Ϊobj
		
		SystemDictionaryDetail c1=new SystemDictionaryDetail();
		c1.setTitle("��");
		c1.setTvalue("man");
		c1.setParent(obj); //�ֵ�ֵ�ĸ���Ϊobj
		
		obj.getChildren().add(c); //�ֵ���ֵ�ֵΪc
		obj.getChildren().add(c1);//�ֵ���ֵ�ֵΪc
		
		assertTrue("�޷���������!",this.dao.save(obj));
	}
	public void testRead()
	{			
		SystemDictionary obj=(SystemDictionary)this.dao.getBy(SystemDictionary.class,"sn","test");
		assertNotNull(obj);
		assertEquals("��Ų����!","����",obj.getTitle());
		assertNotNull("�ֶ�Ϊ��",obj.getChildren());
		assertTrue("Ϊ��",obj.getChildren().size()>0);
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
		assertFalse("�±���".equals(obj.getTitle()));
		obj.setTitle("�±���");
		this.dao.update(obj);
		SystemDictionary obj1=(SystemDictionary)this.dao.getBy(SystemDictionary.class, "sn","test");
		assertTrue("�±���".equals(obj1.getTitle()));	
	}
	public void testQuery(){
		java.util.List list = this.dao.query(SystemDictionary.class, "1=1");
		assertTrue("����Ϊ��",list.size()>0);		
	}
	public void testDel()
	{
		SystemDictionary obj=(SystemDictionary)this.dao.get(SystemDictionary.class, 1l);
		assertNotNull("����Ϊ��", obj);
		assertTrue("ɾ�����ɹ���",this.dao.del(obj));
	}
}
