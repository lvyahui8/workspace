package com.meybosoft.microerp.business.impl;

import java.util.Collection;
import com.easyjf.util.Assert;
import com.easyjf.web.tools.DbPageList;
import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.DealService;
import com.meybosoft.microerp.business.LogicException;
import com.meybosoft.microerp.domain.Deal;

public class DealServiceImpl extends AbstractDAOServiceSupport implements
		DealService {
	public boolean addDeal(Deal deal) {
		Assert.notNull(deal);
		if(deal.getCustomer()==null)throw new LogicException("客户不能为空!");		
		return this.dao.save(deal);
	}

	public boolean delDeal(Deal deal) {
		Assert.notNull(deal);
		return this.dao.del(deal);
	}

	public Deal getDeal(Long id) {
		Assert.notNull(id);
		return (Deal)this.dao.get(Deal.class, id);
	}

	public IPageList queryDeal(String scope, Collection paras, int currentPage, int pageSize) {
		DbPageList pageList=new DbPageList(Deal.class,scope,paras,dao);
		pageList.doList(currentPage, pageSize);	
		return pageList;
	}

	public boolean updateDeal(Deal deal) {
		Assert.notNull(deal);
		Assert.notNull(deal.getId());
		return this.dao.update(deal);
	}

}
