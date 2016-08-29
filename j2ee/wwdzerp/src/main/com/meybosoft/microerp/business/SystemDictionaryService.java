package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.system.SystemDictionary;
import com.meybosoft.microerp.system.SystemDictionaryDetail;

/**
 * ϵͳ�����ֵ����
 * 
 * @author ëΰ
 * @company meybosoft.com
 */
public interface SystemDictionaryService {
	/**
	 * ���һ���µ��ֵ���Ϣ
	 * 
	 * @param dict
	 *            �ֵ����
	 * @return
	 */
	boolean addDictionary(SystemDictionary dict);

	/**
	 * �޸�һ���ֵ���Ϣ
	 * 
	 * @param dict
	 *            �ֵ����
	 * @return
	 */
	boolean updateDictionary(SystemDictionary dict);

	/**
	 * ɾ��һ���ֵ�
	 * 
	 * @param dict
	 * @return
	 */
	boolean delDictionary(SystemDictionary dict);

	/**
	 * ͨ��id�õ�һ���ֵ�
	 * 
	 * @param id
	 * @return
	 */
	SystemDictionary getDictionary(Long id);

	/**
	 * ͨ���ֵ��ŵõ�һ���ֵ�
	 * 
	 * @param sn
	 * @return
	 */
	SystemDictionary getDictionaryBySn(String sn);

	public SystemDictionaryDetail getDictionaryDetailByValue(String sn,String tvalue);
	/**
	 * ���һ���ֵ���ϸֵ
	 * @param id
	 * @return
	 */
	public SystemDictionaryDetail getDictionaryDetail(Long id);
	/**
	 * ����һ���ֵ�ֵ
	 * 
	 * @param dictDetail
	 *            �ֵ����ϸֵ
	 * @return
	 */
	boolean addDictionaryDetail(SystemDictionaryDetail dictDetail);

	/**
	 * �޸�һ���ֵ�ֵ
	 * 
	 * @param dictDetail
	 *            Ҫ�޸ĵ��ֵ���ϸֵ
	 * @return
	 */
	boolean updateDictionaryDetail(SystemDictionaryDetail dictDetail);

	/**
	 * ɾ��һ���ֵ�ֵ
	 * 
	 * @param dictDetail
	 *            �ֵ���ϸֵ
	 * @return
	 */
	boolean delDictionaryDetail(SystemDictionaryDetail dictDetail);

	/**
	 * ͨ���ֵ��ѯ��ϸ�ֵ�ֵ��Ϣ�����ؽ����sequence����
	 * 
	 * @param dict
	 * @return
	 */
	IPageList getDetailByDictionary(SystemDictionary dict);

	/**
	 * �����Զ����ѯ������ѯ�ֵ�ֵ
	 * 
	 * @param scope
	 * @param paras
	 * @param begin
	 * @param max
	 * @return
	 */
	IPageList queryDictionary(String scope, java.util.Collection paras, int currentPage,
			int pageSize);
}
