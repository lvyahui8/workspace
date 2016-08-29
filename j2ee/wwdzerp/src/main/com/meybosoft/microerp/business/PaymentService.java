package com.meybosoft.microerp.business;

import java.util.List;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.OrderInfo;
import com.meybosoft.microerp.domain.Payment;

public interface PaymentService {
	Integer PAYTYPE_NONE=new Integer(-1);
	Integer PAYTYPE_PAIED=new Integer(2);
	Integer PAYMENT_DONATED=new Integer(3);
	Integer PAYMENT_BAD_DEBT=new Integer(4);
	/**
	 * 添加一笔支付信息
	 * 
	 * @param pay
	 * @return
	 */
	boolean addPayment(Payment pay);

	/**
	 * 修改一笔支付信息
	 * 
	 * @param pay
	 * @return
	 */
	boolean updatePayment(Payment pay);

	/**
	 * 删除一笔支付信息
	 * 
	 * @param pay
	 * @return
	 */
	boolean delPayment(Payment pay);

	/**
	 * 通过id查询一笔支付信息
	 * 
	 * @param id
	 *            ID号
	 * @return
	 */
	Payment getPayment(Long id);

	/**
	 * 返回一笔订单的所有支付信息
	 * 
	 * @param order
	 *            订单对象
	 * @return
	 */
	List getOrderPayment(OrderInfo order);

	/**
	 * 返回一个客户的所有支付信息
	 * 
	 * @param customer
	 * @return
	 */
	List getCustomerPayment(Customer customer);

	boolean pay(Payment payment,String orders);
	
	IPageList queryCustomerDebt(Customer customer);
	/**
	 * 查询支付信息
	 * 
	 * @param scope
	 *            查询条件
	 * @param paras
	 *            查询参数值
	 * @param begin
	 *            开始记录
	 * @param max
	 *            返回记录条数
	 * @return
	 */
	IPageList queryPayment(String scope, java.util.Collection paras, int currentPage,
			int pageSize);
}
