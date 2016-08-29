package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.domain.Delivery;
import com.meybosoft.microerp.domain.DeliveryDetail;

public class DeliveryDaoTest extends BaseEasyDBODaoTest {
	public void testAdd(){
		Delivery obj = new Delivery();
		obj.setId(1l);
		obj.setVdate(new java.util.Date());
		obj.setCarno("001");
		
		DeliveryDetail child=new DeliveryDetail();
		child.setId(1l);
		child.setParent(obj);
		obj.getChildren().add(child);
		assertTrue("�����޷�����",dao.save(obj));
	}
	
	public void testRead(){
		Delivery obj = (Delivery) this.dao.get(Delivery.class,1l);
		assertNotNull("������Ϊ��",obj);
		java.util.Iterator it=obj.getChildren().iterator();
		assertNotNull(it);
		assertTrue(it.hasNext());
		assertEquals("�����ֵ�����","001",obj.getCarno());		
	}
	
	public void testUpdate(){
		Delivery obj = (Delivery) this.dao.get(Delivery.class,1l);
		assertNotNull("������Ϊ��",obj);
		assertTrue("���Ͳ�ƥ��", obj.getClass() == Delivery.class);
		obj.setCarno("002");
		assertTrue("��������ʧ��!", this.dao.update(obj));
		Delivery p2 = (Delivery) this.dao.getBy(Delivery.class, "carno","002");
		assertEquals("���������źŲ����!", obj.getId(), p2.getId());
	}

	public void testQuery()
	{
		java.util.List list=this.dao.query(Delivery.class,"1=1");
		assertNotNull(list);
		assertTrue("�б���û������!",list.size()>0);
		assertTrue("���Ͳ�ƥ��!",list.get(0).getClass()==Delivery.class);				
	}
	
	public void testDel() {
		Delivery obj = (Delivery) this.dao.get(Delivery.class, 1);
		assertNotNull("����Ϊ�գ�",obj);
		//ɾ������,�����µĶ�����ϸ�б���Զ�ɾ��
		assertTrue("ɾ��������Ϣʧ��", this.dao.del(obj));
		
		Delivery p2 = (Delivery) this.dao.get(Delivery.class,1);
		assertNull("���ݲ�Ϊ��", p2);
	}
}
