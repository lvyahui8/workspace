package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.OrderInfo;
import com.meybosoft.microerp.domain.Payment;

public class PaymentDaoTest extends BaseEasyDBODaoTest{
	//测试是否能保存数据
	public void testAdd(){
		Payment obj = new Payment();
		obj.setId(1l);
		obj.setSum(new java.math.BigDecimal(3534));
		obj.setVdate(new java.util.Date());
		
		Customer cu = new Customer();
		cu.setSn("sn");
		cu.setTitle("title");
		assertTrue("添加用户信息失败", this.dao.save(cu));
		obj.setCustomer(cu);
		
		OrderInfo ord = new OrderInfo();
		ord.setSn("sn");
		ord.setAmount(new java.math.BigDecimal(523));
		assertTrue("添加定单信息失败", this.dao.save(ord));
			
		assertTrue("无法存储数据", this.dao.save(obj));
	}
	//测试读取出数据
	public void testRead(){
		Payment obj = (Payment) this.dao.getBy(Payment.class, "id", 1);
		assertNotNull("无法取出数据",obj);
		System.out.println(obj.getVdate());
	}
	//测试更新数据
	public void testUpdate(){
		Payment obj = (Payment) this.dao.get(Payment.class, 1);
		assertNotNull("原数据不存在", obj);
		assertTrue("类型不匹配", obj.getClass() == Payment.class);
		obj.setSum(new java.math.BigDecimal(12345678));
		obj.setVdate(new java.util.Date());
		assertNotNull("更新数据失败",dao.update(obj));
	}
	//测试表中有无数据
	public void testQuery(){
		java.util.List list = this.dao.query(Payment.class, "1=1");
		assertTrue("表中无数据",list.size()>0);
		for(int i=0; i<list.size(); i++){
			Payment p=(Payment)list.get(i);
			System.out.println(p.getSum());
		}
	}
	//测试是否能删除数据
	public void testDel(){
		Payment obj = (Payment) this.dao.get(Payment.class, 1);
		assertNotNull("数据为空", obj);
		
		assertTrue("删除客户失败", this.dao.del(obj.getCustomer()));
	//	assertTrue("删除定单失败", this.dao.del(obj.getOrder()));
		assertTrue("删除数据失败",this.dao.del(obj));
		
		assertNull("没有被删除", this.dao.get(Payment.class, 1));
	}
}
