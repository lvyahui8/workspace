package com.meybosoft.microerp.business;

import java.util.List;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.CustomerPrice;
import com.meybosoft.microerp.domain.Product;
/**
 * �ͻ�ҵ��ӿ�
 * @author ëΰ
 *
 */
public interface CustomerService {
	/**
	 * ����¿ͻ���Ϣ
	 * 
	 * @param cu �ͻ�����
	 */
	boolean addCustomer(Customer cu);
	/**
	 * �޸Ŀͻ���Ϣ
	 * @param cu
	 * @return
	 */
	boolean updateCustomer(Customer cu);
	/**
	 * ɾ���ͻ���Ϣ
	 * @param cu
	 * @return
	 */
	boolean delCustomer(Customer cu);
	/**
	 * ���ݿͻ�ID�õ��û���Ϣ
	 * @param id
	 * @return
	 */
	Customer getCustomer(Long id);
	/**
	 * ���ݿͻ���ŵõ��ͻ���Ϣ
	 * @param sn �ͻ����
	 * @return
	 */
	Customer getCustomerBySn(String sn);
	/**
	 * �õ������ͻ���Ϣ��Ҳ����û�и��ڵ�Ŀͻ���Ϣ��
	 * @return ������������Ϣ�б�
	 */
	List getRootCustomers();
	/**
	 * ��ѯ���������Ŀͻ���Ϣ
	 * @param scope ��ѯ����
	 * @param paras ����ֵ
	 * @param begin ��ʼ��¼
	 * @param max ÿ�η��ص�����¼��
	 * @return ������������Ϣ�б�
	 */
	IPageList queryCustomer(String scope, java.util.Collection paras, int currentPage,
			int pageSize);// ��ѯ�ͻ���Ϣ
	
	
	/**
	 * ��ѯ�ͻ����һ�ζ���ĳһ��Ʒ�ļ۸���û�иò�Ʒ�۸��¼���򷵻ز�Ʒ����ͨ�����ۼ۸�
	 * @param cu �ͻ�
	 * @param p ��Ʒ
	 * @return
	 */
	CustomerPrice getCustomerPrice(Customer cu,Product p);
	
	/**
	 * �õ���Ʒ�ļ۸��б�
	 * @param cu �ͻ�
 	 * @param p ��Ʒ
	 * @param currentPage ��ǰҳ
	 * @param pageSize ÿҳ��С
	 * @return
	 */
	IPageList queryCustomerPrice(Customer cu,Product p ,int currentPage,int pageSize);
}
