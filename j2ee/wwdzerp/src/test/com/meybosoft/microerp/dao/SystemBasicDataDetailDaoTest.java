package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.SystemDictionary;
import com.meybosoft.microerp.system.SystemDictionaryDetail;

//�����ֵ�ֵ
public class SystemBasicDataDetailDaoTest extends BaseEasyDBODaoTest {
	public void testAdd()
	{
		SystemDictionaryDetail obj=new SystemDictionaryDetail();
		obj.setId(123l);
		obj.setTitle("����");
		
		//�õ�һ��������
		SystemDictionary parent = new SystemDictionary();
		parent.setSn("sn");
		assertTrue("���游����ʧ��", this.dao.save(parent));
		obj.setParent(parent);

		assertTrue("�޷���������!",this.dao.save(obj));
	}
	public void testRead()
	{
		SystemDictionaryDetail obj=(SystemDictionaryDetail)this.dao.get(SystemDictionaryDetail.class, 123l);		
		assertNotNull(obj);
		assertNotNull(obj.getParent());
		assertEquals("���ⲻ���!","����",obj.getTitle());
		assertEquals("����Ŵ���", "sn" ,obj.getParent().getSn());
	}
	public void testUpdate() {	
		SystemDictionaryDetail obj=(SystemDictionaryDetail)this.dao.get(SystemDictionaryDetail.class, 123l);	
		assertNotNull(obj);
		assertFalse("�±���".equals(obj.getTitle()));
		obj.setTitle("�±���");
		this.dao.update(obj);
		SystemDictionaryDetail obj1=(SystemDictionaryDetail)this.dao.get(SystemDictionaryDetail.class,123l);
		assertTrue("�±���".equals(obj1.getTitle()));	
	}
	public void testDel()
	{
		SystemDictionaryDetail obj=(SystemDictionaryDetail)this.dao.get(SystemDictionaryDetail.class, 123l);
		assertNotNull("����Ϊ��", obj);
		assertTrue("ɾ���Ӷ��󲻳ɹ���",this.dao.del(obj));
		assertTrue("ɾ�������󲻳ɹ���",this.dao.del(obj.getParent()));
	}
}
