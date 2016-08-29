package com.meybosoft.microerp.business;

import java.util.Collection;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.domain.Product;

public interface ProductService {
	/**
	 * ��Ӳ�Ʒ��Ϣ
	 * 
	 * @param product
	 *            ��Ʒ����
	 * @return �ɹ�����true��ʧ�ܷ���false���׳��쳣��Ϣ
	 */
	boolean addProduct(Product product);

	/**
	 * �޸Ĳ�Ʒ��Ϣ
	 * 
	 * @param product
	 *            ��Ʒ����
	 * @return
	 */
	boolean updateProduct(Product product);

	/**
	 * ɾ����Ʒ��Ϣ
	 * 
	 * @param product
	 *            ��Ʒ����
	 * @return
	 */
	boolean delProduct(Product product);
		/**
	 * ���ݲ�ƷID�Ĳ�ѯ��Ʒ��Ϣ
	 * 
	 * @param id
	 *            ��ƷID��
	 * @return ����Ʒ�����򷵻ز�Ʒ���󣬷��򷵻�null
	 */
	Product getProduct(Long id);

	/**
	 * ���ݲ�Ʒ��Ų�ѯ��Ʒ��Ϣ
	 * 
	 * @param sn
	 *            ��Ʒ���
	 * @return ���ҵ��ñ�ŵĲ�Ʒ�򷵻ز�Ʒ���󣬷��򷵻�null
	 */
	Product getProductBySn(String sn);

	/**
	 * ���ݲ�ѯ������ѯ��Ʒ��Ϣ
	 * 
	 * @param scope
	 *            ��ѯ����
	 * @param paras
	 *            ����ֵ
	 * @param begin
	 *            ��¼��ʼ��
	 * @param max
	 *            ���ص��������
	 * @return
	 */
	IPageList queryProduct(String scope, Collection paras, int currentPage,
			int pageSize);
}
