package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.Deal;
import com.meybosoft.microerp.domain.OrderInfo;

//测试交易
public class DealDaoTest extends BaseEasyDBODaoTest{
	//测试数据是否能保存
	public void testAdd(){
		Deal obj = new Deal();
		obj.setId(1l);
		obj.setSum(new java.math.BigDecimal(10));
		
		Customer cu = new Customer();
		cu.setSn("sn");
		cu.setTitle("title");
		assertTrue("保存客户失败", this.dao.save(cu));
		obj.setCustomer(cu);
		
		OrderInfo ord = new OrderInfo();
		ord.setSn("sn");
		ord.setAmount(new java.math.BigDecimal(6787));
		assertTrue("保存客户失败", this.dao.save(ord));
		obj.setOrder(ord);
		
		assertTrue("无法保存数据", this.dao.save(obj));
	}
	//测试读取出数据
	public void testRead(){
		Deal obj = (Deal) this.dao.get(Deal.class, 1);
		assertNotNull("没有这个数据",obj);
	}
	//测试是否能更新数据
	public void testUpdate(){
		Deal obj = (Deal) this.dao.get(Deal.class, 1);
		obj.setSum(new java.math.BigDecimal(532432423));
		obj.setDealType(3444444);
		assertTrue("更新数据失败",this.dao.update(obj));
	}
	//测试表中是否有数据
	public void testQuery(){
		java.util.List list = this.dao.query(Deal.class, "1=1");
		assertNotNull(list);
		assertTrue("表中无数据",list.size()>0);
		assertTrue("不是同一类",list.get(0).getClass()==Deal.class);
	}
	//测试是否能删除数据
	public void testDel(){
		Deal obj = (Deal) this.dao.get(Deal.class, 1);
		assertNotNull("数据为空", obj);
		assertTrue("删除客户信息失败", this.dao.del(obj.getCustomer()));
		assertTrue("删除定单信息失败", this.dao.del(obj.getOrder()));
		assertTrue("删除失败",this.dao.del(obj));
	}
	
}