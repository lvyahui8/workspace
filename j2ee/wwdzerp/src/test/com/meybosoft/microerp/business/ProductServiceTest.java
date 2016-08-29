package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.impl.ProductServiceImpl;
import com.meybosoft.microerp.domain.Product;

import junit.framework.TestCase;

public class ProductServiceTest extends TestCase {
	private ProductService service;

	@Override
	protected void setUp() throws Exception {
		service = new ProductServiceImpl();
		super.setUp();
	}
	//�����Ƿ������Ӳ�Ʒ��Ϣ
	public void testAddProduct(){
		Product pr = new Product();
		pr.setSn(null);
		try{
			service.addProduct(pr);
			fail("��Ӳ�Ʒʱ��Ų���Ϊ��");
		}
		catch(LogicException e){
		}
		pr.setId(1l);
		pr.setSn("��Ʒ���");
		pr.setTitle("��Ʒ����");
		pr.setTypes("��Ʒ���");
		pr.setSalePrice(new java.math.BigDecimal(65.4));
		pr.setBuyPrice(new java.math.BigDecimal(22));
		assertTrue("��Ӳ�Ʒʧ��", service.addProduct(pr));
		
		Product pr2 = new Product();
		pr2.setSn(new String("��Ʒ���"));
		try{
			boolean se = service.addProduct(pr2);
			if(se) fail("��Ʒ����Ѵ���");
		}
		catch(LogicException e){
			
		}
	}
	//�����Ƿ�����޸Ĳ�Ʒ��Ϣ
	public void testUpdateProduct(){
		Product pr = service.getProductBySn("��Ʒ���");
		assertNotNull("ָ����Ʒ������", pr);
		assertEquals("��Ʒ���һ��", "��Ʒ���", pr.getTypes());
		pr.setSn("�޸ĺ�Ĳ�Ʒ���");
		pr.setTitle("�޸ĺ�Ĳ�Ʒ����");
		assertTrue("�޸Ĳ�Ʒ��Ϣʧ��", service.updateProduct(pr));
	}
	//�����Ƿ���Ը��ݲ�ƷID�Ĳ�ѯ��Ʒ��Ϣ
	public void testGetProduct_Id(){
		Product pr = service.getProduct(1l);
		assertNotNull("ָ����Ʒ������", pr);
		//assertEquals("��Ʒ���һ��", "��Ʒ���", pr.getTypes());
		System.out.println(pr.getVendor());
		//��ѯһ�������ڵĲ�ƷID
		Product pr2 = service.getProduct(123l);
		assertNull(pr2);
	}
	//�����Ƿ���Ը��ݲ�Ʒ�ı�Ų�ѯ��Ʒ��Ϣ
	public void testGetProduct_Sn(){
		Product pr = service.getProductBySn("�޸ĺ�Ĳ�Ʒ���");
		assertNotNull("ָ����Ʒ������", pr);
		assertEquals("��Ʒ���һ��", "��Ʒ���", pr.getTypes());
		
		//��ѯһ�������ڵĲ�ƷSn
		Product pr2 = service.getProductBySn(new String("�����ڵĲ�Ʒ���"));
		assertNull(pr2);
	}
	//�����Ƿ���Ը��ݲ�ѯ������ѯ��Ʒ��Ϣ
	public void testQueryProduct(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add("��Ʒ���");
		IPageList pageList = service.queryProduct("sn=?", paras, 0, 10);
		assertNotNull("��ѯʧ��", pageList);
	}
	//�����Ƿ����ɾ����Ʒ��Ϣ
	public void testDelProduct(){
		Product pr = service.getProduct(1l);
		assertNotNull("��Ʒ������", pr);
		assertTrue("ɾ����Ʒʧ��", service.delProduct(pr));
	}
}
