package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.system.SystemRegion;

public class SystemRegionDaoTest extends BaseEasyDBODaoTest {
	public void testAdd(){
		
		SystemRegion parent = new SystemRegion();
		parent.setSn("0000000");
		
		SystemRegion parent1 = new SystemRegion();
		parent1.setId(379l);
		parent1.setSn("0000035");
		parent1.setParent(parent);
		parent1.setInputTime(new java.util.Date());
		parent1.setInputUser("ëΰ");
		parent1.setTitle("����");
		parent1.setLev(new Integer(1));	//ָ���ǹ���
		
		SystemRegion obj = new SystemRegion();
		obj.setId(380l);
		obj.setSn("0000035000001");
		obj.setInputTime(new java.util.Date());
		obj.setInputUser("ëΰ");
		obj.setTitle("ŦԼ");
		obj.setLev(new Integer(1));	//ָ���ǹ���
		obj.setParent(parent1);	//�õ��������
		
		parent1.getChildren().add(obj); //ͨ�����õ���
				
		assertTrue("��������ʧ��",this.dao.save(parent1));
	}
	//�����Ƿ��ܶ�ȡ������
	public void testRead(){
		SystemRegion obj = (SystemRegion) this.dao.getBy(SystemRegion.class, "title", "ŦԼ");
		assertNotNull("�޷���ȡ������",obj);
		assertEquals("���ݲ�ƥ��", "0000035", obj.getParent().getSn());
	}
	//�����Ƿ��ܸ�������
	public void testUpdate(){
		SystemRegion obj = (SystemRegion) this.dao.getBy(SystemRegion.class, "id", "379");
		assertNotNull("����Ϊ��", obj);
		obj.setInputTime(new java.util.Date());		
		obj.setTitle("����");
		System.out.println(obj.getChildren().size());
		assertTrue("��������ʧ��",this.dao.update(obj));
	}
	//���Ա��������Ƿ�Ϊ��
	public void testQuery(){
		java.util.List list = this.dao.query(SystemRegion.class, "lev=1",null,0,15);
		assertTrue("����������",list.size()>0);
		assertTrue(list.size()<=15);
		String s="";
		for(int i=0;i<list.size();i++)
		{
			SystemRegion region=(SystemRegion)list.get(i);
			s+=region+"\n";
		}
		System.out.println(s);
	}
	//�����Ƿ����ɾ��ָ������
	public void testDel(){
		SystemRegion obj = (SystemRegion) this.dao.getBy(SystemRegion.class, "sn","0000035");
		assertNotNull("����Ϊ��", obj);
		assertTrue("ɾ��ʧ��",this.dao.del(obj));
	}
}
