package com.meybosoft.microerp.dao;

import com.meybosoft.microerp.domain.OrderDetail;
import com.meybosoft.microerp.domain.OrderInfo;
import com.meybosoft.microerp.domain.Product;

public class OrderDetailDaoTest extends BaseEasyDBODaoTest{
	//测试写入数据
	public void testAdd(){
		OrderDetail obj = new OrderDetail();
		obj.setId(1l);
		obj.setNum(53243.6d);
		obj.setPrice(new java.math.BigDecimal(49.4));
		obj.setAmount(new java.math.BigDecimal(23));
		
		OrderInfo ord = new OrderInfo();
		ord.setSn("sn");
		ord.setAmount(new java.math.BigDecimal(45));
		assertTrue("保存定单信息失败", this.dao.save(ord));
		obj.setOrder(ord);
		
		Product pro = new Product();
		pro.setSn("sn");
		pro.setBuyPrice(new java.math.BigDecimal(523));
		pro.setSalePrice(new java.math.BigDecimal(352));
		assertTrue("保存产品信息失败", this.dao.save(pro));
		obj.setProduct(pro);
		
		assertTrue("保存数据失败",dao.save(obj));
	}
	//测试读取出数据
	public void testRead(){
		OrderDetail obj = (OrderDetail) this.dao.get(OrderDetail.class, 1);
		assertNotNull("没有这个数据",obj);
	}
	//测试能否更新数据
	public void testUpdate(){
		OrderDetail obj = (OrderDetail) this.dao.get(OrderDetail.class, 1);
		obj.setNum(100.4d);
		//obj.setTitle("改写后的标题");
		assertNotNull("更新数据失败",dao.update(obj));
	}
	//测试表中有无数据
	public void testQuery(){
		java.util.List list = this.dao.query(OrderDetail.class, "1=1");
		assertTrue("数据为空",list.size()>0);
	}
	//测试能否删除数据
	public void testDel(){
		OrderDetail obj = (OrderDetail) this.dao.get(OrderDetail.class, 1);
		assertNotNull("数据为空", obj);
		assertTrue("删除失败",dao.del(obj));
		assertTrue("删除定单数据失败", this.dao.del(obj.getOrder()));
		assertTrue("删除产品数据失败", this.dao.del(obj.getProduct()));
		
		
	}
}