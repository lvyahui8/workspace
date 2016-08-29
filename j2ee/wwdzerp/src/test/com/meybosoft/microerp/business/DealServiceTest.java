package com.meybosoft.microerp.business;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.impl.DealServiceImpl;
import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.Deal;
import com.meybosoft.microerp.domain.OrderInfo;


public class DealServiceTest extends TestCase {
	private DealService service;

	@Override
	protected void setUp() throws Exception {
		service = new DealServiceImpl();
		super.setUp();
	}
	//测试是否可以添加交易信息
	public void testAddDeal(){
		Deal deal = new Deal();
		
		OrderInfo ord = new OrderInfo();
		ord.setId(new Long(1l));
		String s = new String("编号");
		ord.setSn(s);
		deal.setOrder(ord);
		try{
			service.addDeal(deal);
			fail("无交易客户");
		}
		catch(LogicException e){
		}
		
		
		Customer cu = new Customer();
		cu.setId(1l);
		String ss = new String("毛伟");
		cu.setTitle(ss);
		deal.setCustomer(cu);
		deal.setId(new Long(1));
		assertTrue("添加交易信息失败",service.addDeal(deal));		
	}
	//测试是否可以修改交易信息
	public void testUpdataDeal(){
		Deal deal = service.getDeal(1l);
		assertNotNull("交易信息不存在", deal);
		Customer cu = new Customer();
		cu.setTitle("毛正伟");
		deal.setCustomer(cu);
		assertTrue("修改交易信息失败", service.updateDeal(deal));
	}
	//测试是否可以查询一条指定交易信息
	public void testGetDeal(){
		Deal deal = service.getDeal(1l);
		assertNotNull("数据不存在", deal);
		
	}
	//测试是否可以查询符合条件的交易信息
	public void testQueryDeal(){
		java.util.Collection paras=new java.util.ArrayList();
		paras.add(new Date());
		paras.add(100l);
		IPageList pageList = service.queryDeal("vdate>? and id=?",paras, 0,15);
		assertNotNull("没有查询到符合条件的交易信息", pageList);
		
	}
	//测试是否可以删除交易信息
	public void testDelDeal(){
		Deal deal = service.getDeal(1l);
		assertNotNull("需被删除的数据不存在",deal);
		assertTrue("删除失败", service.delDeal(deal));
		
	}
}