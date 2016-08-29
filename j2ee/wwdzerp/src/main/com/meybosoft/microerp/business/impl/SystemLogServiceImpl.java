package com.meybosoft.microerp.business.impl;

import java.util.Collection;
import java.util.Date;

import com.easyjf.web.tools.DbPageList;
import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.SystemLogService;
import com.meybosoft.microerp.system.SystemLog;

public class SystemLogServiceImpl extends AbstractDAOServiceSupport implements SystemLogService {

	public boolean addSystemLog(SystemLog log) {		
		return this.dao.save(log);
	}

	public boolean delSystemLog(SystemLog log) {	
		return this.dao.del(log);
	}

	public boolean exportSystemLog(Date date1, Date date2, int backType) {	
		return false;
	}

	public IPageList querySystemLog(String scope, Collection paras,
			int currentPage, int pageSize) {
		DbPageList pageList=new DbPageList(SystemLog.class,scope,paras,dao);
		pageList.doList(currentPage, pageSize);
		return pageList;
	}

}
