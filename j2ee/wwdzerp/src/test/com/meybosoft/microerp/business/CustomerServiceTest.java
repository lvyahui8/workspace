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
	//�����Ƿ��������¿ͻ�
	public void testAddCustomer() {
		Customer cu = new Customer();
		cu.setSn(null);
		cu.setTitle("title");
		//
		try {
			service.addCustomer(cu);
			fail("��snΪnull����ַ�����ʱ������׳��߼��쳣��");
		} catch (LogicException e) {
			//System.out.println("�ϸ���!");
		}
		cu.setId(1l);
		cu.setSn("test");
		cu.setCity("city");
		assertTrue(service.addCustomer(cu));

		Customer cu2 = new Customer();
		cu2.setSn("test");
		try {
			boolean ret=service.addCustomer(cu2);
			if(ret)fail("������ӱ����ͬ�����ݣ�");			
		} catch (LogicException e) {

		}

	}
	//���ݿͻ�ID�õ��û���Ϣ
	public void testGetCustomerById() {
		Customer cu = service.getCustomer(1l);
		assertNotNull(cu);
		assertEquals("title",cu.getTitle());
		
		Customer cust = service.getCustomer(234l);
		assertNull(cust);
		
	}
	//���ݿͻ���ŵõ��û���Ϣ
	public void testGetCustomerBySn() {
		Customer cu = service.getCustomerBySn("test");
		assertNotNull(cu);
		assertEquals("title",cu.getTitle());
		
		Customer cust = service.getCustomerBySn("�����ڵı��");
		assertNull(cust);
	}
	//��ѯ�����ͻ���Ϣ
	public void testGetRootCustomers(){
		java.util.List list = service.getRootCustomers();
		assertNotNull(list);
		assertTrue(list.size()>0);
		assertTrue(list.get(0).getClass() == Customer.class);
		Customer cu = (Customer) list.get(0);
		assertNull(cu.getParent());
	}
	//�޸Ŀͻ���Ϣ
	public void testUpdateCustomer() {
		Customer cu = service.getCustomerBySn("test");
		assertNotNull(cu);
		cu.setTitle("title");
		cu.setInputUser("new nameUser");
		assertTrue("���¿ͻ���Ϣʧ��",service.updateCustomer(cu));

	}

	//��ѯ���������Ŀͻ���Ϣ
	public void testQueryCustomer(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add(0);
		paras.add(200);
		//paras.add("13251114955");
		IPageList pagetList = service.queryCustomer("id>? and id<? ", paras, 0, 15);
		assertNotNull("��ѯʧ��",pagetList);
		assertTrue(pagetList.getResult().size()>0);
		System.out.println(pagetList.getRowCount());
	}
	
	//ɾ���ͻ���Ϣ
	public void testDelCustomer(){
		Customer cu = service.getCustomerBySn("test");
		assertNotNull("��ɾ�������ݲ�����", cu);
		assertTrue("ɾ������ʧ��",service.delCustomer(cu));
		
	}
}
