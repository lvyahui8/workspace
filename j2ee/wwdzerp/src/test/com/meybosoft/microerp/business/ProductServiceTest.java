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
	//测试是否可以添加产品信息
	public void testAddProduct(){
		Product pr = new Product();
		pr.setSn(null);
		try{
			service.addProduct(pr);
			fail("添加产品时编号不能为空");
		}
		catch(LogicException e){
		}
		pr.setId(1l);
		pr.setSn("产品编号");
		pr.setTitle("产品名称");
		pr.setTypes("产品类别");
		pr.setSalePrice(new java.math.BigDecimal(65.4));
		pr.setBuyPrice(new java.math.BigDecimal(22));
		assertTrue("添加产品失败", service.addProduct(pr));
		
		Product pr2 = new Product();
		pr2.setSn(new String("产品编号"));
		try{
			boolean se = service.addProduct(pr2);
			if(se) fail("产品编号已存在");
		}
		catch(LogicException e){
			
		}
	}
	//测试是否可以修改产品信息
	public void testUpdateProduct(){
		Product pr = service.getProductBySn("产品编号");
		assertNotNull("指定产品不存在", pr);
		assertEquals("产品类别不一样", "产品类别", pr.getTypes());
		pr.setSn("修改后的产品编号");
		pr.setTitle("修改后的产品标题");
		assertTrue("修改产品信息失败", service.updateProduct(pr));
	}
	//测试是否可以根据产品ID的查询产品信息
	public void testGetProduct_Id(){
		Product pr = service.getProduct(1l);
		assertNotNull("指定产品不存在", pr);
		//assertEquals("产品类别不一样", "产品类别", pr.getTypes());
		System.out.println(pr.getVendor());
		//查询一个不存在的产品ID
		Product pr2 = service.getProduct(123l);
		assertNull(pr2);
	}
	//测试是否可以根据产品的编号查询产品信息
	public void testGetProduct_Sn(){
		Product pr = service.getProductBySn("修改后的产品编号");
		assertNotNull("指定产品不存在", pr);
		assertEquals("产品类别不一样", "产品类别", pr.getTypes());
		
		//查询一个不存在的产品Sn
		Product pr2 = service.getProductBySn(new String("不存在的产品编号"));
		assertNull(pr2);
	}
	//测试是否可以根据查询条件查询产品信息
	public void testQueryProduct(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add("产品编号");
		IPageList pageList = service.queryProduct("sn=?", paras, 0, 10);
		assertNotNull("查询失败", pageList);
	}
	//测试是否可以删除产品信息
	public void testDelProduct(){
		Product pr = service.getProduct(1l);
		assertNotNull("产品不存在", pr);
		assertTrue("删除产品失败", service.delProduct(pr));
	}
}
