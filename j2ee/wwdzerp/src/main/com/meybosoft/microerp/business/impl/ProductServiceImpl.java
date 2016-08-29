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
	//��֤��Ʒ��Ϣ
	private void validate(Product product){
		if(product.getSn()==null || "".equals(product.getSn()))throw new LogicException("��Ʒ��Ų���Ϊ�գ�");	
		if(product.getTitle()==null || "".equals(product.getTitle())) throw new LogicException("��Ʒ���Ʋ���Ϊ��");
		if(product.getTypes()==null || "".equals(product.getTypes())) throw new LogicException("��ѡ���Ʒ���");
		if(product.getBuyPrice()==null || "".equals(product.getBuyPrice())) throw new LogicException("�����۸���Ϊ��");
		if(product.getSalePrice()==null || "".equals(product.getSalePrice())) throw new LogicException("���ۼ۸���Ϊ��");
	}	
	//��Ӳ�Ʒ��Ϣ
	public boolean addProduct(Product product) {
		Assert.notNull(product);
		if(getProductBySn(product.getSn()) != null )throw new LogicException("��Ʒ�Ѿ����ڣ�");
		validate(product);
		if(product.getId()!=null && product.getId().intValue()==0)product.setId(null);
		return this.dao.save(product);
	}
	//ɾ����Ʒ��Ϣ
	public boolean delProduct(Product product) {
		Assert.notNull(product);
		Assert.notNull(product.getId());
		return this.dao.del(product);
	}
	////ͨ��ID�õ���Ʒ��Ϣ
	public Product getProduct(Long id) {		
		return (Product)this.dao.getBy(Product.class, "id", id);
	}
	//ͨ����ŵõ���Ʒ��Ϣ
	public Product getProductBySn(String sn) {	
		return (Product) this.dao.getBy(Product.class, "sn", sn);
	}
	//��ѯ��Ʒ��Ϣ
	public IPageList queryProduct(String scope, Collection paras, int currentPage, int pageSize) {
		DbPageList pageList=new DbPageList(Product.class,scope,paras,dao);
		pageList.doList(currentPage, pageSize);
		return pageList;
		
	}
	
	//�޸Ĳ�Ʒ��Ϣ
	public boolean updateProduct(Product product) {
		validate(product);
		return this.dao.update(product);
	}

}
