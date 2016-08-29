package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.system.SystemRegion;

public interface SystemRegionService {
boolean addSystemRegion(SystemRegion region);//添加地区信息
SystemRegion getSystemRegion(String sn);
boolean delSystemRegion(SystemRegion region);//删除地区信息
boolean updateSystemRegion(SystemRegion region);//更新地区信息
boolean moveTo(SystemRegion region);//移动地区信息
IPageList querySystemRegion(String scope, java.util.Collection paras, int currentPage,
		int pageSize);// 查询地区信息
}
