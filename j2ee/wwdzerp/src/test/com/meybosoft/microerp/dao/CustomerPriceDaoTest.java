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
	
	//�����Ƿ��ܱ�����ͻ��Ķ���
	public void testAdd(){
		CustomerPrice obj = new CustomerPrice();		
		obj.setId(1l);
		obj.setPrice(new java.math.BigDecimal(23.4));
		obj.setUnit("Ԫ");
		
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

		assertTrue("�޷��������ݣ�", this.dao.save(obj));
	}
	//�����Ƿ��ܶ�ȡ���ͻ��Ķ���
	public void testRead(){
		CustomerPrice obj = (CustomerPrice) this.dao.getBy(CustomerPrice.class, "id", "1");
		assertNotNull("����Ϊ��", obj);
		assertTrue("���Ͳ�ƥ��", obj.getClass() == CustomerPrice.class);
		System.out.println( obj.getUnit() );
	}
	
	//�����Ƿ��ܸ��¸��ͻ��Ķ���
	public void testUpdate() {
		CustomerPrice obj = (CustomerPrice) this.dao.getBy(CustomerPrice.class, "id", "1");
		assertNotNull("����Ϊ��", obj);
		assertTrue("���Ͳ�ƥ��", obj.getClass() == CustomerPrice.class);
		obj.setPrice(new java.math.BigDecimal(444));
		obj.setUnit("�����");
		assertTrue("����ʧ��", this.dao.update(obj));
	}
	
	//�����Ƿ����Զ����ѯ�����ͻ��Ķ���
	public void testQuery(){
		java.util.Collection pares = new java.util.ArrayList();
		pares.add(100);
		java.util.List list = this.dao.query(CustomerPrice.class, "price>?", pares, 0, 10);
		assertTrue("��ѯΪ��", list.size()>0);
		assertTrue("���Ͳ�ƥ��", list.get(0).getClass() == CustomerPrice.class);
		for(int i=0; i<list.size(); i++){
			CustomerPrice obj = (CustomerPrice) list.get(i);
			System.out.println(obj.getPrice());
		}
	}
	
	//�����Ƿ���ɾ����Щ����
	public void testDel(){
		CustomerPrice obj = (CustomerPrice) this.dao.getBy(CustomerPrice.class, "id", "1");
		assertNotNull("����Ϊ��", obj);
		assertTrue("���Ͳ�ƥ��", obj.getClass() == CustomerPrice.class);
		assertTrue("ɾ���ͻ���Ϣʧ��",this.dao.del(obj.getCustomer()));
		assertTrue("ɾ����Ʒ��Ϣʧ��",this.dao.del(obj.getProduct()));
		assertTrue("ɾ��ʧ��", this.dao.del(obj));
	}
	
	
}
