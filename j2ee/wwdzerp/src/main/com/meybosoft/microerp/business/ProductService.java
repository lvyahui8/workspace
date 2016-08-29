package com.meybosoft.microerp.business;

import java.util.Collection;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.domain.Product;

public interface ProductService {
	/**
	 * 添加产品信息
	 * 
	 * @param product
	 *            产品对象
	 * @return 成功返回true，失败返回false或抛出异常信息
	 */
	boolean addProduct(Product product);

	/**
	 * 修改产品信息
	 * 
	 * @param product
	 *            产品对象
	 * @return
	 */
	boolean updateProduct(Product product);

	/**
	 * 删除产品信息
	 * 
	 * @param product
	 *            产品对象
	 * @return
	 */
	boolean delProduct(Product product);
		/**
	 * 根据产品ID的查询产品信息
	 * 
	 * @param id
	 *            产品ID号
	 * @return 若产品存在则返回产品对象，否则返回null
	 */
	Product getProduct(Long id);

	/**
	 * 根据产品编号查询产品信息
	 * 
	 * @param sn
	 *            产品编号
	 * @return 若找到该编号的产品则返回产品对象，否则返回null
	 */
	Product getProductBySn(String sn);

	/**
	 * 根据查询条件查询产品信息
	 * 
	 * @param scope
	 *            查询条件
	 * @param paras
	 *            参数值
	 * @param begin
	 *            记录开始数
	 * @param max
	 *            返回的最大条数
	 * @return
	 */
	IPageList queryProduct(String scope, Collection paras, int currentPage,
			int pageSize);
}
