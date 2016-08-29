package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.SystemDept;
import com.meybosoft.microerp.system.SystemUser;

public class SystemUserDaoTest extends BaseEasyDBODaoTest{
	//�����Ƿ���Ա�������
	public void testAdd(){
		SystemUser obj = new SystemUser();
		obj.setId(1l);
		obj.setUserName("ëΰ");
		obj.setPassword("13251114955");
		obj.setEmail("ksmwly@163.com");
		obj.setTel("52745244");
		obj.setInputTime(new java.util.Date());
		
		SystemDept sy = new SystemDept();
		sy.setSn("sn");
		assertTrue("��Ӳ���ʧ��", this.dao.save(sy));
		obj.setBelongDept(sy);
		
		assertTrue("��������ʧ��",this.dao.save(obj));
	}
	//�����Ƿ��ܶ�ȡ������
	public void testRead(){
		SystemUser obj = (SystemUser) this.dao.get(SystemUser.class, 1);
		assertNotNull("�޷���ȡ������",obj);
	}
	//�����Ƿ��ܸ�������
	public void testUpdate(){
		SystemUser obj = (SystemUser) this.dao.get(SystemUser.class, 1);
		assertNotNull("�޷���ȡ������",obj);
		obj.setPassword("1234567890");
		obj.setEmail("mwlovexmy@163.com");
		obj.setTel("52671163");
		obj.setInputTime(new java.util.Date());
		assertTrue("�޷���������",this.dao.update(obj));
	}
	//���Ա�����������
	public void testQuery(){
		java.util.List list = this.dao.query(SystemUser.class, "1=1");
		assertTrue("����������",list.size()>0);
	}
	//�����Ƿ����ɾ��ָ������
	public void testDel(){
		SystemUser obj = (SystemUser) this.dao.get(SystemUser.class, 1);
		assertTrue("ɾ������ʧ��", this.dao.del(obj.getBelongDept()));
		assertTrue("ɾ������ʧ��",this.dao.del(obj));
	}
}

