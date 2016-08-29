package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.SystemDept;

public class SystemDeptDaoTest extends BaseEasyDBODaoTest{
	//�����Ƿ��ܱ�������
	public void testAdd(){
		SystemDept obj = new SystemDept();
		obj.setId(1);
		obj.setSn("���one");
		obj.setTitle("����");
		obj.setAddress("�����п�����������");
		obj.setTel("13251114955");
		obj.setEmail("ksmwly@163.com");
		assertTrue("��������ʧ��",this.dao.save(obj));
	}
	//�����Ƿ��ܶ�ȡ������
	public void testRead(){
		SystemDept obj = (SystemDept) this.dao.get(SystemDept.class, 1);
		assertNotNull("��ȡ����ʧ��",obj);
		assertEquals("�ͻ��绰����","13251114955",obj.getTel());
	}
	//�����Ƿ��ܸ�������
	public void testUpdate(){
		SystemDept obj = (SystemDept) this.dao.get(SystemDept.class, 1);
		assertNotNull("�޿ͻ�����",obj);
		obj.setSn("���һ");
		obj.setAddress("����ݿƼ�");
		assertTrue("���¿ͻ�����ʧ��",this.dao.update(obj));
	}
	//���Ա����Ƿ��пͻ�����
	public void testQuery(){
		java.util.List list = this.dao.query(SystemDept.class, "1=1");
		assertTrue("����������",list.size()>0);
		for(int i=0; i<list.size(); i++){
			SystemDept obj = (SystemDept) list.get(i);
			System.out.println("�ͻ�����Ϊ:" + obj.getEmail());
		}
	}
	//�����Ƿ���ɾ���ͻ�����
	public void testDel(){
		SystemDept obj = (SystemDept) this.dao.getBy(SystemDept.class, "tel","13251114955");
		assertNotNull(obj);
		assertTrue("ɾ��ʧ��",this.dao.del(obj));
	}
}
