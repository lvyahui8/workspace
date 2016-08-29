package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.system.SystemRegion;

public interface SystemRegionService {
boolean addSystemRegion(SystemRegion region);//��ӵ�����Ϣ
SystemRegion getSystemRegion(String sn);
boolean delSystemRegion(SystemRegion region);//ɾ��������Ϣ
boolean updateSystemRegion(SystemRegion region);//���µ�����Ϣ
boolean moveTo(SystemRegion region);//�ƶ�������Ϣ
IPageList querySystemRegion(String scope, java.util.Collection paras, int currentPage,
		int pageSize);// ��ѯ������Ϣ
}
