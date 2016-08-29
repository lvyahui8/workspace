package com.meybosoft.microerp.business.impl;

import java.util.Collection;

import com.easyjf.util.Assert;
import com.easyjf.web.tools.DbPageList;
import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.LogicException;
import com.meybosoft.microerp.business.ProductService;
import com.meybosoft.microerp.domain.Product;

public class ProductServiceImpl extends AbstractDAOServiceSupport implements
		ProductService {	
	//验证产品信息
	private void validate(Product product){
		if(product.getSn()==null || "".equals(product.getSn()))throw new LogicException("产品编号不能为空！");	
		if(product.getTitle()==null || "".equals(product.getTitle())) throw new LogicException("产品名称不能为空");
		if(product.getTypes()==null || "".equals(product.getTypes())) throw new LogicException("请选择产品类别");
		if(product.getBuyPrice()==null || "".equals(product.getBuyPrice())) throw new LogicException("进货价格不能为空");
		if(product.getSalePrice()==null || "".equals(product.getSalePrice())) throw new LogicException("销售价格不能为空");
	}	
	//添加产品信息
	public boolean addProduct(Product product) {
		Assert.notNull(product);
		if(getProductBySn(product.getSn()) != null )throw new LogicException("产品已经存在！");
		validate(product);
		if(product.getId()!=null && product.getId().intValue()==0)product.setId(null);
		return this.dao.save(product);
	}
	//删除产品信息
	public boolean delProduct(Product product) {
		Assert.notNull(product);
		Assert.notNull(product.getId());
		return this.dao.del(product);
	}
	////通过ID得到产品信息
	public Product getProduct(Long id) {		
		return (Product)this.dao.getBy(Product.class, "id", id);
	}
	//通过编号得到产品信息
	public Product getProductBySn(String sn) {	
		return (Product) this.dao.getBy(Product.class, "sn", sn);
	}
	//查询产品信息
	public IPageList queryProduct(String scope, Collection paras, int currentPage, int pageSize) {
		DbPageList pageList=new DbPageList(Product.class,scope,paras,dao);
		pageList.doList(currentPage, pageSize);
		return pageList;
		
	}
	
	//修改产品信息
	public boolean updateProduct(Product product) {
		validate(product);
		return this.dao.update(product);
	}

}
