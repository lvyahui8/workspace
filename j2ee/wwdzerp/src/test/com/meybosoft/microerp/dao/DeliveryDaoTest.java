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
		assertTrue("数据无法保存",dao.save(obj));
	}
	
	public void testRead(){
		Delivery obj = (Delivery) this.dao.get(Delivery.class,1l);
		assertNotNull("对象不能为空",obj);
		java.util.Iterator it=obj.getChildren().iterator();
		assertNotNull(it);
		assertTrue(it.hasNext());
		assertEquals("对象的值不相等","001",obj.getCarno());		
	}
	
	public void testUpdate(){
		Delivery obj = (Delivery) this.dao.get(Delivery.class,1l);
		assertNotNull("对象不能为空",obj);
		assertTrue("类型不匹配", obj.getClass() == Delivery.class);
		obj.setCarno("002");
		assertTrue("保存数据失败!", this.dao.update(obj));
		Delivery p2 = (Delivery) this.dao.getBy(Delivery.class, "carno","002");
		assertEquals("两个对象编号号不相等!", obj.getId(), p2.getId());
	}

	public void testQuery()
	{
		java.util.List list=this.dao.query(Delivery.class,"1=1");
		assertNotNull(list);
		assertTrue("列表中没有数据!",list.size()>0);
		assertTrue("类型不匹配!",list.get(0).getClass()==Delivery.class);				
	}
	
	public void testDel() {
		Delivery obj = (Delivery) this.dao.get(Delivery.class, 1);
		assertNotNull("对象为空！",obj);
		//删除定单,定单下的定单详细列表会自动删除
		assertTrue("删除定单信息失败", this.dao.del(obj));
		
		Delivery p2 = (Delivery) this.dao.get(Delivery.class,1);
		assertNull("数据不为空", p2);
	}
}
