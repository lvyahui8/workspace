package com.meybosoft.microerp.business.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.easyjf.util.Assert;
import com.easyjf.web.tools.DbPageList;
import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.CustomerService;
import com.meybosoft.microerp.business.LogicException;
import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.CustomerPrice;
import com.meybosoft.microerp.domain.Product;

public class CustomerServiceImpl extends AbstractDAOServiceSupport implements CustomerService {

	public boolean addCustomer(Customer cu) {
	  Assert.notNull(cu);
	  if(cu.getSn()==null || "".equals(cu.getSn()))throw new LogicException("编号不能为空");
	  if(getCustomerBySn(cu.getSn())!=null)throw new LogicException("编号已经存在!");
	  if(cu.getId()!=null && cu.getId().intValue()==0)cu.setId(null);
	  initCustomer(cu);
	  return this.dao.save(cu);
	}

	private void initCustomer(Customer cu)
	{
		if(cu.getDebt()==null)cu.setDebt(new BigDecimal(0));
		if(cu.getBalance()==null)cu.setBalance(new BigDecimal(0));		
	}
	public boolean delCustomer(Customer cu) {
		Assert.notNull(cu);
		Assert.notNull(cu.getId());
		return this.dao.del(cu);
	}

	public Customer getCustomer(Long id) {
		Assert.notNull(id);
		return (Customer)this.dao.getBy(Customer.class, "id", id);
	}

	public Customer getCustomerBySn(String sn) {
		Assert.notNull(sn);		
		return (Customer)this.dao.getBy(Customer.class,"sn", sn);
	}

	public List getRootCustomers() {		
		return this.dao.query(Customer.class,"(parent_id is null or parent_id='')");
	}

	public IPageList queryCustomer(String scope, Collection paras, int currentPage, int pageSize){		
		DbPageList pageList=new DbPageList(Customer.class,scope,paras,dao);
		pageList.doList(currentPage, pageSize);		
		return pageList;
	}

	public boolean updateCustomer(Customer cu) {
	Assert.notNull(cu);
	Assert.notNull(cu.getId());
	initCustomer(cu);
	return this.dao.update(cu);
	}

	
	public CustomerPrice getCustomerPrice(Customer cu, Product p) {
		CustomerPrice ret=null;
		List list=dao.query(CustomerPrice.class, "customer_id="+cu.getId()+" and product_id="+p.getId()+" order by vdate desc");
		if(list!=null && list.size()>0)
		{
			ret=(CustomerPrice)list.get(0);
		}
		else
		{
			ret=new CustomerPrice();
			ret.setCustomer(cu);
			ret.setProduct(p);		
			ret.setUnit(p.getUnit());
			ret.setVdate(new Date());
			ret.setPrice(p.getSalePrice());			
			this.dao.save(ret);
		}			
		return ret;
	}

	public IPageList queryCustomerPrice(Customer cu, Product p, int currentPage, int pageSize) {		
		return null;
	}

}
