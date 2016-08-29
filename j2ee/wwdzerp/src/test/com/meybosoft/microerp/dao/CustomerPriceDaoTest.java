package com.meybosoft.microerp.dao;

import java.math.BigDecimal;

import com.meybosoft.microerp.business.CustomerService;
import com.meybosoft.microerp.business.ProductService;
import com.meybosoft.microerp.business.impl.CustomerServiceImpl;
import com.meybosoft.microerp.business.impl.ProductServiceImpl;
import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.CustomerPrice;
import com.meybosoft.microerp.domain.Product;

public class CustomerPriceDaoTest extends BaseEasyDBODaoTest{
	

	@Override
	protected void setUp() throws Exception {
		
		super.setUp();
	}
	
	//测试是否能保存给客户的定价
	public void testAdd(){
		CustomerPrice obj = new CustomerPrice();		
		obj.setId(1l);
		obj.setPrice(new java.math.BigDecimal(23.4));
		obj.setUnit("元");
		
		Customer cu =new Customer();
		cu.setTitle("cu");
		cu.setSn("sn");
		this.dao.save(cu);
		
		obj.setCustomer(cu);
		
		Product pro = new Product();
		pro.setTitle("t");
		pro.setSn("ps");
		pro.setSalePrice(new BigDecimal(5));
		pro.setBuyPrice(new BigDecimal(5));
		this.dao.save(pro);
		
		obj.setProduct(pro);

		assertTrue("无法保存数据！", this.dao.save(obj));
	}
	//测试是否能读取到客户的定价
	public void testRead(){
		CustomerPrice obj = (CustomerPrice) this.dao.getBy(CustomerPrice.class, "id", "1");
		assertNotNull("数据为空", obj);
		assertTrue("类型不匹配", obj.getClass() == CustomerPrice.class);
		System.out.println( obj.getUnit() );
	}
	
	//测试是否能更新给客户的定价
	public void testUpdate() {
		CustomerPrice obj = (CustomerPrice) this.dao.getBy(CustomerPrice.class, "id", "1");
		assertNotNull("数据为空", obj);
		assertTrue("类型不匹配", obj.getClass() == CustomerPrice.class);
		obj.setPrice(new java.math.BigDecimal(444));
		obj.setUnit("人民币");
		assertTrue("更新失败", this.dao.update(obj));
	}
	
	//测试是否能自定义查询到给客户的定价
	public void testQuery(){
		java.util.Collection pares = new java.util.ArrayList();
		pares.add(100);
		java.util.List list = this.dao.query(CustomerPrice.class, "price>?", pares, 0, 10);
		assertTrue("查询为空", list.size()>0);
		assertTrue("类型不匹配", list.get(0).getClass() == CustomerPrice.class);
		for(int i=0; i<list.size(); i++){
			CustomerPrice obj = (CustomerPrice) list.get(i);
			System.out.println(obj.getPrice());
		}
	}
	
	//测试是否能删除这些定价
	public void testDel(){
		CustomerPrice obj = (CustomerPrice) this.dao.getBy(CustomerPrice.class, "id", "1");
		assertNotNull("数据为空", obj);
		assertTrue("类型不匹配", obj.getClass() == CustomerPrice.class);
		assertTrue("删除客户信息失败",this.dao.del(obj.getCustomer()));
		assertTrue("删除产品信息失败",this.dao.del(obj.getProduct()));
		assertTrue("删除失败", this.dao.del(obj));
	}
	
	
}
