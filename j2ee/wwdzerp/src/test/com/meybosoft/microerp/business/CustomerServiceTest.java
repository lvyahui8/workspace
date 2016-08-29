package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.impl.CustomerServiceImpl;
import com.meybosoft.microerp.domain.Customer;

import junit.framework.TestCase;

public class CustomerServiceTest extends TestCase {
	private CustomerService service;

	@Override
	protected void setUp() throws Exception {
		service = new CustomerServiceImpl();
		super.setUp();
	}
	//测试是否可以添加新客户
	public void testAddCustomer() {
		Customer cu = new Customer();
		cu.setSn(null);
		cu.setTitle("title");
		//
		try {
			service.addCustomer(cu);
			fail("当sn为null或空字符串的时候必须抛出逻辑异常！");
		} catch (LogicException e) {
			//System.out.println("合格了!");
		}
		cu.setId(1l);
		cu.setSn("test");
		cu.setCity("city");
		assertTrue(service.addCustomer(cu));

		Customer cu2 = new Customer();
		cu2.setSn("test");
		try {
			boolean ret=service.addCustomer(cu2);
			if(ret)fail("不能添加编号相同的数据！");			
		} catch (LogicException e) {

		}

	}
	//根据客户ID得到用户信息
	public void testGetCustomerById() {
		Customer cu = service.getCustomer(1l);
		assertNotNull(cu);
		assertEquals("title",cu.getTitle());
		
		Customer cust = service.getCustomer(234l);
		assertNull(cust);
		
	}
	//根据客户编号得到用户信息
	public void testGetCustomerBySn() {
		Customer cu = service.getCustomerBySn("test");
		assertNotNull(cu);
		assertEquals("title",cu.getTitle());
		
		Customer cust = service.getCustomerBySn("不存在的编号");
		assertNull(cust);
	}
	//查询顶级客户信息
	public void testGetRootCustomers(){
		java.util.List list = service.getRootCustomers();
		assertNotNull(list);
		assertTrue(list.size()>0);
		assertTrue(list.get(0).getClass() == Customer.class);
		Customer cu = (Customer) list.get(0);
		assertNull(cu.getParent());
	}
	//修改客户信息
	public void testUpdateCustomer() {
		Customer cu = service.getCustomerBySn("test");
		assertNotNull(cu);
		cu.setTitle("title");
		cu.setInputUser("new nameUser");
		assertTrue("更新客户信息失败",service.updateCustomer(cu));

	}

	//查询符合条件的客户信息
	public void testQueryCustomer(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add(0);
		paras.add(200);
		//paras.add("13251114955");
		IPageList pagetList = service.queryCustomer("id>? and id<? ", paras, 0, 15);
		assertNotNull("查询失败",pagetList);
		assertTrue(pagetList.getResult().size()>0);
		System.out.println(pagetList.getRowCount());
	}
	
	//删除客户信息
	public void testDelCustomer(){
		Customer cu = service.getCustomerBySn("test");
		assertNotNull("需删除的数据不存在", cu);
		assertTrue("删除数据失败",service.delCustomer(cu));
		
	}
}
