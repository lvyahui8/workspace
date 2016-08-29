package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.Group;

public class GroupDaoTest extends BaseEasyDBODaoTest{
	//�����Ƿ��ܱ�������
	public void testAdd(){
		Group obj = new Group();
		obj.setId(1);
		obj.setIntro(444520);
		obj.setTitle("��һ������");
		assertTrue("��������ʧ��",this.dao.save(obj));
	}
	//�����Ƿ��ܶ�ȡ����
	public void testRead(){
		Group obj = (Group) this.dao.get(Group.class, 1);
		assertNotNull("����Ϊ��",obj);
	}
	//�����Ƿ��ܸ�������
	public void testUpdate(){
		Group obj = (Group) this.dao.get(Group.class, 1);
		obj.setTitle("�������������");
		obj.setIntro(43534);
		assertTrue("�޷���������",this.dao.update(obj));
	}
	//���Ա��������Ƿ�Ϊ��
	public void testQuery(){
		java.util.List list = this.dao.query(Group.class, "1=1");
		assertTrue("������Ϊ��",list.size()>0);
	}
	//�����Ƿ���ɾ��ָ������
	public void testDel(){
		Group obj = (Group) this.dao.get(Group.class, 1);
		assertNotNull("����Ϊ��", obj);
		assertTrue("�޷�ɾ��ָ������",this.dao.del(obj));
	}
}