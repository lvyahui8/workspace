package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.domain.Deal;

public interface DealService {
/**
 * ��ӽ�����Ϣ
 * @param deal ������Ϣ
 * @return
 */
boolean addDeal(Deal deal);
/**
 * �޸Ľ�����Ϣ
 * @param deal
 * @return
 */
boolean updateDeal(Deal deal);
/**
 * ɾ��������Ϣ
 * @param deal
 * @return
 */
boolean delDeal(Deal deal);
/**
 * ��ѯһ��������Ϣ
 * @param id
 * @return
 */
Deal getDeal(Long id);
/**
 * ��ѯ���������Ľ�����Ϣ
 * @param scope 
 * @param paras
 * @param begin
 * @param max
 * @return
 */
IPageList queryDeal(String scope, java.util.Collection paras, int currentPage,
		int pageSize);
}
