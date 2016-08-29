package com.meybosoft.microerp.business.impl;

import java.util.Collection;

import com.easyjf.util.Assert;
import com.easyjf.web.tools.DbPageList;
import com.easyjf.web.tools.IPageList;
import com.easyjf.web.tools.ListQuery;
import com.meybosoft.microerp.business.LogicException;
import com.meybosoft.microerp.business.SystemDictionaryService;
import com.meybosoft.microerp.system.SystemDictionary;
import com.meybosoft.microerp.system.SystemDictionaryDetail;

public class SystemDictionaryServiceImpl extends AbstractDAOServiceSupport
		implements SystemDictionaryService {

	public boolean addDictionary(SystemDictionary dict) {
		Assert.notNull(dict);
		if(dict.getSn()==null)throw new LogicException("字典编号不能为空！");
		if(getDictionaryBySn(dict.getSn())!=null)throw new LogicException("该编号已经存在！");
		if(dict.getId()!=null && dict.getId().intValue()==0)dict.setId(null);
		return this.dao.save(dict);
	}

	public boolean addDictionaryDetail(SystemDictionaryDetail dictDetail) {
		Assert.notNull(dictDetail);
		return this.dao.save(dictDetail);
	}

	public boolean delDictionary(SystemDictionary dict) {
		return this.dao.del(dict);
	}

	public boolean delDictionaryDetail(SystemDictionaryDetail dictDetail) {		
		return this.dao.del(dictDetail);
	}

	public SystemDictionary getDictionary(Long id) {		
		return (SystemDictionary)this.dao.get(SystemDictionary.class, id);
	}

	public SystemDictionaryDetail getDictionaryDetail(Long id) {		
		return (SystemDictionaryDetail)this.dao.get(SystemDictionaryDetail.class, id);
	}
	public SystemDictionaryDetail getDictionaryDetailByValue(String sn,String tvalue) {
		SystemDictionary dict=getDictionaryBySn(sn);
		if(dict!=null)
		{
			java.util.Iterator it=dict.getChildren().iterator();
			while(it.hasNext())
			{				
				SystemDictionaryDetail sdd=(SystemDictionaryDetail)it.next();
				if(sdd.getTvalue().equals(tvalue))
				{
					return sdd;
				}
			}
		}		
		//this.dao.query(SystemDictionaryDetail.class, "parent_sn='"+sn+"' and tvalue='"+tvalue+"'");
		return null;
	}
	public SystemDictionary getDictionaryBySn(String sn) {	
		return (SystemDictionary)this.dao.getBy(SystemDictionary.class, "sn", sn);
	}

	public IPageList getDetailByDictionary(SystemDictionary dict) {
		SystemDictionary realDict=getDictionary(dict.getId());
		IPageList pageList=new com.easyjf.web.tools.PageList(new ListQuery(new java.util.ArrayList(realDict.getChildren())));
		pageList.doList(-1, 1, "", "");		
		return pageList;
	}

	public IPageList queryDictionary(String scope, Collection paras, int currentPage,
			int pageSize) {		
		DbPageList pageList=new DbPageList(SystemDictionary.class,scope,paras,dao);
		pageList.doList(currentPage, pageSize);
		return pageList;
	}

	public boolean updateDictionary(SystemDictionary dict) {
		Assert.notNull(dict);		
		return this.dao.update(dict);
	}

	public boolean updateDictionaryDetail(SystemDictionaryDetail dictDetail) {
		Assert.notNull(dictDetail);
		return this.dao.update(dictDetail);
	}
}
