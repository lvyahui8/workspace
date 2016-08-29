package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.Role;

public class RoleDaoTest extends BaseEasyDBODaoTest{
	//�����Ƿ��ܱ�������
	public void testAdd(){
		Role obj = new Role();
		obj.setId(1l);
		obj.setSn("���");
		obj.setIntro("���ǵ�һ�����");
		obj.setTitle("���ǵ�һ������");
		obj.setStatus(342);
		assertTrue("�޷���������",this.dao.save(obj));
	}
	//�����Ƿ��ܶ�ȡ������
	public void testRead(){
		Role obj = (Role) this.dao.get(Role.class, 1);
		assertNotNull("ָ�������ڱ��в�����",obj);
	}
	//�����Ƿ��ܸ�������
	public void testUpdate(){
		Role obj = (Role) this.dao.get(Role.class, 1);
		obj.setTitle("���º�ĵ�һ������");
		obj.setIntro("���º�ļ��");
		assertTrue("��������ʧ��",this.dao.update(obj));
	}
	//���Ա��Ƿ������ݴ���
	public void testQuery(){
		java.util.List list = this.dao.query(Role.class, "1=1");
		assertNotNull("��������Ϊ��",list.size()>0);
		assertTrue("���Ͳ�ƥ��", list.get(0).getClass() == Role.class);
	}
	//�����Ƿ���ɾ��ָ������
	public void testDel(){
		Role obj = (Role) this.dao.get(Role.class, 1);
		assertNotNull("����Ϊ��", obj);
		assertNotNull("ɾ������ʧ��",this.dao.del(obj));
	}
}
