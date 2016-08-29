package com.meybosoft.microerp.business.impl;

//地区信息
import java.util.Collection;

import com.easyjf.web.tools.DbPageList;
import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.SystemRegionService;
import com.meybosoft.microerp.system.SystemRegion;

public class SystemRegionServiceImpl extends AbstractDAOServiceSupport
		implements SystemRegionService {
	public boolean addSystemRegion(SystemRegion region) {
		return this.dao.save(region);
	}
	public SystemRegion getSystemRegion(String sn) {

		return (SystemRegion) this.dao.get(SystemRegion.class,sn);
	}

	public boolean delSystemRegion(SystemRegion region) {
		return this.dao.del(region);
	}

	public boolean moveTo(SystemRegion region) {
		// TODO 自动生成方法存根
		return false;
	}

	public IPageList querySystemRegion(String scope, Collection paras, int currentPage,
			int pageSize) {	
		DbPageList pageList=new DbPageList(SystemRegion.class,scope,paras,dao);
		pageList.doList(currentPage, pageSize);	
		return pageList;
	}

	public boolean updateSystemRegion(SystemRegion region) {
		return this.dao.update(region);
	}
}
