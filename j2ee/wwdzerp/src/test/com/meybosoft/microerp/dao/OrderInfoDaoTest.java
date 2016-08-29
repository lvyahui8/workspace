package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.OrderDetail;
import com.meybosoft.microerp.domain.OrderInfo;

public class OrderInfoDaoTest extends BaseEasyDBODaoTest{
	public void testAdd(){
		OrderInfo obj = new OrderInfo();
		obj.setId(1l);
		obj.setSn("c001");
		obj.setAmount(new java.math.BigDecimal(23));
		
		Customer cu = new Customer();
		cu.setSn("sn");
		cu.setTitle("title");
		assertTrue("无法保存客户信息", this.dao.save(cu));
		obj.setCustomer(cu);
		
		OrderDetail ord = new OrderDetail();
		ord.setPrice(new java.math.BigDecimal(3254));
		ord.setAmount(new java.math.BigDecimal(565));
		ord.setOrder(obj);
		//assertTrue("无法保存定单详细信息", this.dao.save(ord));
		
		obj.getChildren().add(ord);
		assertTrue("数据无法保存",dao.save(obj));
	}
	
	public void testRead(){
		OrderInfo obj = (OrderInfo) this.dao.getBy(OrderInfo.class, "sn", "c001");
		java.util.Iterator it=obj.getChildren().iterator();		
		assertNotNull("对象不能为空",obj);
		assertEquals("对象的值不相等","c001",obj.getSn());		
	}
	
	public void testUpdate(){
		OrderInfo obj = (OrderInfo) this.dao.get(OrderInfo.class, "1");
		assertNotNull("对象为空",obj);
		assertTrue("类型不匹配", obj.getClass() == OrderInfo.class);
		obj.setTel("13251114955");
		assertTrue("保存数据失败!", this.dao.update(obj));
		OrderInfo p2 = (OrderInfo) this.dao.getBy(OrderInfo.class, "tel","13251114955");
		assertEquals("两个对象编号号不相等!", obj.getSn(), p2.getSn());
	}

	public void testQuery()
	{
		java.util.List list=this.dao.query(OrderInfo.class,"1=1");
		assertNotNull(list);
		assertTrue("列表中没有数据!",list.size()>0);
		assertTrue("类型不匹配!",list.get(0).getClass()==OrderInfo.class);				
	}
	
	public void testDel() {
		OrderInfo obj = (OrderInfo) this.dao.get(OrderInfo.class, 1);
		assertNotNull("对象为空！",obj);
		
		assertTrue("删除客户信息失败", this.dao.del(obj.getCustomer()));
		//删除定单,定单下的定单详细列表会自动删除
		assertTrue("删除定单信息失败", this.dao.del(obj));
		
		OrderInfo p2 = (OrderInfo) this.dao.get(OrderInfo.class, "1");
		assertNull("数据不为空", p2);
	}
}
