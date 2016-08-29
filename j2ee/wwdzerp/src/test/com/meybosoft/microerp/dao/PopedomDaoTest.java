package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.Popedom;

public class PopedomDaoTest extends BaseEasyDBODaoTest{
	//�����Ƿ��ܱ�������
	public void testAdd(){
		//��Ȩ��
		Popedom parent = new Popedom();
		parent.setId(1);
		parent.setTitle("������");
		parent.setIntro("�����");
		//��Ȩ��
		Popedom obj = new Popedom();
		obj.setId(111);
		obj.setTitle("�ӱ���");
		obj.setIntro("�Ӽ��");
		obj.setParent(parent);
		parent.getChildren().add(obj);//ָ����Ȩ�޵���Ȩ����obj
		
		assertTrue("���游����ʧ��",this.dao.save(parent));
	}
	//�����Ƿ��ܶ�ȡ����������Ӷ���
	public void testRead(){
		Popedom obj = (Popedom) this.dao.get(Popedom.class, 111);
		assertNotNull("�Ӷ��󲻴���",obj);
		assertNotNull("�����󲻴���",obj.getParent());
		assertEquals("�Ӷ�����������",111l,obj.getId());
		assertEquals("��������������", 1l, obj.getParent().getId());
	}
	//�����Ƿ��ܸ�������
	public void testUpdate(){
		Popedom obj = (Popedom)this.dao.getBy(Popedom.class, "id", "111");
		assertNotNull("�Ӷ��󲻴���",obj);
		obj.setTitle("���ĺ���ӱ���");
		obj.setIntro("���ĺ���Ӽ��");
		assertTrue("�����Ӷ���ʧ��",this.dao.update(obj));
		obj.getParent().setTitle("���º�ĸ�����");
		assertTrue("���¸�����ʧ��",this.dao.update(obj));
	}
	//�������ݱ��������Ƿ�Ϊ��
	public void testQuery(){
		java.util.List list = this.dao.query(Popedom.class, "1=1");
		assertTrue("��������Ϊ��",list.size()>0);
		assertTrue("���Ͳ�ƥ��", list.get(0).getClass() == Popedom.class);
		for(int i=0; i<list.size(); i++){
			Popedom pop = (Popedom) list.get(i);
			System.out.println(pop.getTitle());
		}
	}
	//�����Ƿ���ɾ��ָ������
	public void testDel(){
		Popedom obj = (Popedom) this.dao.get(Popedom.class, 1);
		assertNotNull("�Ӷ��󲻴���",obj);
		assertTrue("ɾ������ʧ��",this.dao.del(obj));
		//ɾ��������ͬʱҲɾ�����Ӷ���
	}

}
