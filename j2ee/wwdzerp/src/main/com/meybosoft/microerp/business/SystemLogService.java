package com.meybosoft.microerp.business;

import java.util.Date;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.system.SystemLog;

public interface SystemLogService {	
boolean addSystemLog(SystemLog log);	
IPageList querySystemLog(String scope,java.util.Collection paras,int currentPage,int pageSize);
boolean delSystemLog(SystemLog log);
boolean exportSystemLog(Date date1,Date date2,int backType);
}
