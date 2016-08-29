package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.domain.Deal;

public interface DealService {
/**
 * 添加交易信息
 * @param deal 交易信息
 * @return
 */
boolean addDeal(Deal deal);
/**
 * 修改交易信息
 * @param deal
 * @return
 */
boolean updateDeal(Deal deal);
/**
 * 删除交易信息
 * @param deal
 * @return
 */
boolean delDeal(Deal deal);
/**
 * 查询一条交易信息
 * @param id
 * @return
 */
Deal getDeal(Long id);
/**
 * 查询符合条件的交易信息
 * @param scope 
 * @param paras
 * @param begin
 * @param max
 * @return
 */
IPageList queryDeal(String scope, java.util.Collection paras, int currentPage,
		int pageSize);
}
