package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.domain.OrderDetail;
import com.meybosoft.microerp.domain.OrderInfo;

public interface OrderService {
	/**
	 * 添加订单信息，订单编号不能重复，并且需要把订单的一些系统状态信息强制设置成默认值
	 * 
	 * @param order
	 *            订单信息
	 * @return
	 */
	boolean addOrder(OrderInfo order);

	/**
	 * 修改订单信息，一些字段的状态只能由具有一定权限的用户来修改
	 * 
	 * @param order 订单对象
	 * @return
	 */
	boolean updateOrder(OrderInfo order);

	/**
	 * 确认主键值为id的定单
	 * @param id
	 * @return
	 */
	boolean confirmOrder(Long id);
	/**
	 * 删除订单信息
	 * @param order 订单对象
	 * @return 操作成功，则返回true
	 */
	boolean delOrder(OrderInfo order);
	/**
	 * 根据id得到订单信息
	 * @param id 订单的id号
	 * @return
	 */
	OrderInfo getOrder(Long id);

	/**
	 * 得到最后一个订单
	 * @return
	 */
	OrderInfo getLastOrder(Integer types);
	
	/**
	 * 得到最后一个正在编辑的订单详细信息
	 * @return
	 */
	OrderDetail getLastOrderDetail(OrderInfo order);
	/**
	 * 根据订单编号得到订单信息
	 * @param sn 订单编号
	 * @return 若记录存在则返回具体的订单，否则返回null
	 */
	OrderInfo getOrderBySn(String sn);
	/**
	 * 查询订单信息
	 * @param scope 查询条件
	 * @param paras 参数值
	 * @param begin 开始记录数
	 * @param max 最大返回记录数
	 * @return 符合条件的订单信息
	 */
	IPageList queryOrder(String scope, java.util.Collection paras, int currentPage,
			int pageSize);	
	/**
	 * 添加订单详细列表对象
	 * @param detail 订单详细列表对象
	 * @return
	 */
	boolean addOrderDetail(OrderDetail detail);
	/**
	 * 修改订单详细列表对象
	 * @param detail 订单的详细列表
	 * @return
	 */
	boolean updateOrderDetail(OrderDetail detail);
	/**
	 * 删除订单详细列表对象
	 * @param detail
	 * @return
	 */	
	boolean delOrderDetail(OrderDetail detail);
	
	/**
	 * 执行排除水票编号的操作
	 * @param sn
	 * @return
	 */
	boolean excludeTicketSn(OrderInfo order,String sns);
	
}
