package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.SystemLog;

public class SystemLogDaoTest extends BaseEasyDBODaoTest{
	//�����Ƿ��ܱ�������
	public void testAdd(){
		SystemLog obj = new SystemLog();
		obj.setId(1);
		obj.setUserName("ëΰ");
		obj.setIp("10.0.0.138");
		obj.setIntro("���");
		obj.setVdate(new java.util.Date());
		assertTrue("��������ʧ��",this.dao.save(obj));
	}
	//�����Ƿ��ܶ�ȡ������
	public void testRead(){
		SystemLog obj = (SystemLog) this.dao.get(SystemLog.class,1);
		assertNotNull("ָ�����ݲ�����",obj);
	}
	//�����Ƿ��ܸ�������
	public void testUpdate(){
		SystemLog obj = (SystemLog) this.dao.get(SystemLog.class, 1);
		assertNotNull(obj);
		obj.setUserName("��������");
		obj.setIntro("�¼��");
		obj.setVdate(new java.util.Date());
		assertTrue("��������ʧ��",this.dao.update(obj));
	}
	//���Ա����Ƿ�������
	public void testQuery(){
		java.util.List list = this.dao.query(SystemLog.class, "1=1");
		assertTrue("��������Ϊ��",list.size()>0);
	}
	//�����Ƿ���ɾ����������
	public void testDel(){
		SystemLog obj = (SystemLog) this.dao.get(SystemLog.class, 1);
		assertNotNull("����Ϊ��", obj);
		assertTrue("ɾ������ʧ��",this.dao.del(obj));
	}
}
