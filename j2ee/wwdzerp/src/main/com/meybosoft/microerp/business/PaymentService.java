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
	 * ���һ��֧����Ϣ
	 * 
	 * @param pay
	 * @return
	 */
	boolean addPayment(Payment pay);

	/**
	 * �޸�һ��֧����Ϣ
	 * 
	 * @param pay
	 * @return
	 */
	boolean updatePayment(Payment pay);

	/**
	 * ɾ��һ��֧����Ϣ
	 * 
	 * @param pay
	 * @return
	 */
	boolean delPayment(Payment pay);

	/**
	 * ͨ��id��ѯһ��֧����Ϣ
	 * 
	 * @param id
	 *            ID��
	 * @return
	 */
	Payment getPayment(Long id);

	/**
	 * ����һ�ʶ���������֧����Ϣ
	 * 
	 * @param order
	 *            ��������
	 * @return
	 */
	List getOrderPayment(OrderInfo order);

	/**
	 * ����һ���ͻ�������֧����Ϣ
	 * 
	 * @param customer
	 * @return
	 */
	List getCustomerPayment(Customer customer);

	boolean pay(Payment payment,String orders);
	
	IPageList queryCustomerDebt(Customer customer);
	/**
	 * ��ѯ֧����Ϣ
	 * 
	 * @param scope
	 *            ��ѯ����
	 * @param paras
	 *            ��ѯ����ֵ
	 * @param begin
	 *            ��ʼ��¼
	 * @param max
	 *            ���ؼ�¼����
	 * @return
	 */
	IPageList queryPayment(String scope, java.util.Collection paras, int currentPage,
			int pageSize);
}
