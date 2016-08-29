package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.domain.OrderDetail;
import com.meybosoft.microerp.domain.OrderInfo;

public interface OrderService {
	/**
	 * ��Ӷ�����Ϣ��������Ų����ظ���������Ҫ�Ѷ�����һЩϵͳ״̬��Ϣǿ�����ó�Ĭ��ֵ
	 * 
	 * @param order
	 *            ������Ϣ
	 * @return
	 */
	boolean addOrder(OrderInfo order);

	/**
	 * �޸Ķ�����Ϣ��һЩ�ֶε�״ֻ̬���ɾ���һ��Ȩ�޵��û����޸�
	 * 
	 * @param order ��������
	 * @return
	 */
	boolean updateOrder(OrderInfo order);

	/**
	 * ȷ������ֵΪid�Ķ���
	 * @param id
	 * @return
	 */
	boolean confirmOrder(Long id);
	/**
	 * ɾ��������Ϣ
	 * @param order ��������
	 * @return �����ɹ����򷵻�true
	 */
	boolean delOrder(OrderInfo order);
	/**
	 * ����id�õ�������Ϣ
	 * @param id ������id��
	 * @return
	 */
	OrderInfo getOrder(Long id);

	/**
	 * �õ����һ������
	 * @return
	 */
	OrderInfo getLastOrder(Integer types);
	
	/**
	 * �õ����һ�����ڱ༭�Ķ�����ϸ��Ϣ
	 * @return
	 */
	OrderDetail getLastOrderDetail(OrderInfo order);
	/**
	 * ���ݶ�����ŵõ�������Ϣ
	 * @param sn �������
	 * @return ����¼�����򷵻ؾ���Ķ��������򷵻�null
	 */
	OrderInfo getOrderBySn(String sn);
	/**
	 * ��ѯ������Ϣ
	 * @param scope ��ѯ����
	 * @param paras ����ֵ
	 * @param begin ��ʼ��¼��
	 * @param max ��󷵻ؼ�¼��
	 * @return ���������Ķ�����Ϣ
	 */
	IPageList queryOrder(String scope, java.util.Collection paras, int currentPage,
			int pageSize);	
	/**
	 * ��Ӷ�����ϸ�б����
	 * @param detail ������ϸ�б����
	 * @return
	 */
	boolean addOrderDetail(OrderDetail detail);
	/**
	 * �޸Ķ�����ϸ�б����
	 * @param detail ��������ϸ�б�
	 * @return
	 */
	boolean updateOrderDetail(OrderDetail detail);
	/**
	 * ɾ��������ϸ�б����
	 * @param detail
	 * @return
	 */	
	boolean delOrderDetail(OrderDetail detail);
	
	/**
	 * ִ���ų�ˮƱ��ŵĲ���
	 * @param sn
	 * @return
	 */
	boolean excludeTicketSn(OrderInfo order,String sns);
	
}
