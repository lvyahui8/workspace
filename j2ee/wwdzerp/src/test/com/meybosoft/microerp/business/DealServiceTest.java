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
	//�����Ƿ������ӽ�����Ϣ
	public void testAddDeal(){
		Deal deal = new Deal();
		
		OrderInfo ord = new OrderInfo();
		ord.setId(new Long(1l));
		String s = new String("���");
		ord.setSn(s);
		deal.setOrder(ord);
		try{
			service.addDeal(deal);
			fail("�޽��׿ͻ�");
		}
		catch(LogicException e){
		}
		
		
		Customer cu = new Customer();
		cu.setId(1l);
		String ss = new String("ëΰ");
		cu.setTitle(ss);
		deal.setCustomer(cu);
		deal.setId(new Long(1));
		assertTrue("��ӽ�����Ϣʧ��",service.addDeal(deal));		
	}
	//�����Ƿ�����޸Ľ�����Ϣ
	public void testUpdataDeal(){
		Deal deal = service.getDeal(1l);
		assertNotNull("������Ϣ������", deal);
		Customer cu = new Customer();
		cu.setTitle("ë��ΰ");
		deal.setCustomer(cu);
		assertTrue("�޸Ľ�����Ϣʧ��", service.updateDeal(deal));
	}
	//�����Ƿ���Բ�ѯһ��ָ��������Ϣ
	public void testGetDeal(){
		Deal deal = service.getDeal(1l);
		assertNotNull("���ݲ�����", deal);
		
	}
	//�����Ƿ���Բ�ѯ���������Ľ�����Ϣ
	public void testQueryDeal(){
		java.util.Collection paras=new java.util.ArrayList();
		paras.add(new Date());
		paras.add(100l);
		IPageList pageList = service.queryDeal("vdate>? and id=?",paras, 0,15);
		assertNotNull("û�в�ѯ�����������Ľ�����Ϣ", pageList);
		
	}
	//�����Ƿ����ɾ��������Ϣ
	public void testDelDeal(){
		Deal deal = service.getDeal(1l);
		assertNotNull("�豻ɾ�������ݲ�����",deal);
		assertTrue("ɾ��ʧ��", service.delDeal(deal));
		
	}
}