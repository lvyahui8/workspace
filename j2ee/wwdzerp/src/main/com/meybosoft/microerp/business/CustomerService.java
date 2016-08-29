package com.meybosoft.microerp.business;

import java.util.List;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.CustomerPrice;
import com.meybosoft.microerp.domain.Product;
/**
 * 客户业务接口
 * @author 毛伟
 *
 */
public interface CustomerService {
	/**
	 * 添加新客户信息
	 * 
	 * @param cu 客户对象
	 */
	boolean addCustomer(Customer cu);
	/**
	 * 修改客户信息
	 * @param cu
	 * @return
	 */
	boolean updateCustomer(Customer cu);
	/**
	 * 删除客户信息
	 * @param cu
	 * @return
	 */
	boolean delCustomer(Customer cu);
	/**
	 * 根据客户ID得到用户信息
	 * @param id
	 * @return
	 */
	Customer getCustomer(Long id);
	/**
	 * 根据客户编号得到客户信息
	 * @param sn 客户编号
	 * @return
	 */
	Customer getCustomerBySn(String sn);
	/**
	 * 得到顶级客户信息，也就是没有父节点的客户信息。
	 * @return 符合条件的信息列表
	 */
	List getRootCustomers();
	/**
	 * 查询符合条件的客户信息
	 * @param scope 查询条件
	 * @param paras 参数值
	 * @param begin 开始记录
	 * @param max 每次返回的最大记录数
	 * @return 符合条件的信息列表
	 */
	IPageList queryCustomer(String scope, java.util.Collection paras, int currentPage,
			int pageSize);// 查询客户信息
	
	
	/**
	 * 查询客户最后一次定购某一产品的价格，若没有该产品价格记录，则返回产品的普通的销售价格
	 * @param cu 客户
	 * @param p 产品
	 * @return
	 */
	CustomerPrice getCustomerPrice(Customer cu,Product p);
	
	/**
	 * 得到产品的价格列表
	 * @param cu 客户
 	 * @param p 产品
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 * @return
	 */
	IPageList queryCustomerPrice(Customer cu,Product p ,int currentPage,int pageSize);
}
