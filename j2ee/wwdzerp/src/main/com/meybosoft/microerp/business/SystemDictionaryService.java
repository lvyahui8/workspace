package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.system.SystemDictionary;
import com.meybosoft.microerp.system.SystemDictionaryDetail;

/**
 * 系统数据字典服务
 * 
 * @author 毛伟
 * @company meybosoft.com
 */
public interface SystemDictionaryService {
	/**
	 * 添加一个新的字典信息
	 * 
	 * @param dict
	 *            字典对象
	 * @return
	 */
	boolean addDictionary(SystemDictionary dict);

	/**
	 * 修改一个字典信息
	 * 
	 * @param dict
	 *            字典对象
	 * @return
	 */
	boolean updateDictionary(SystemDictionary dict);

	/**
	 * 删除一个字典
	 * 
	 * @param dict
	 * @return
	 */
	boolean delDictionary(SystemDictionary dict);

	/**
	 * 通过id得到一个字典
	 * 
	 * @param id
	 * @return
	 */
	SystemDictionary getDictionary(Long id);

	/**
	 * 通过字典编号得到一个字典
	 * 
	 * @param sn
	 * @return
	 */
	SystemDictionary getDictionaryBySn(String sn);

	public SystemDictionaryDetail getDictionaryDetailByValue(String sn,String tvalue);
	/**
	 * 获得一个字典详细值
	 * @param id
	 * @return
	 */
	public SystemDictionaryDetail getDictionaryDetail(Long id);
	/**
	 * 新增一个字典值
	 * 
	 * @param dictDetail
	 *            字典的详细值
	 * @return
	 */
	boolean addDictionaryDetail(SystemDictionaryDetail dictDetail);

	/**
	 * 修改一个字典值
	 * 
	 * @param dictDetail
	 *            要修改的字典详细值
	 * @return
	 */
	boolean updateDictionaryDetail(SystemDictionaryDetail dictDetail);

	/**
	 * 删除一个字典值
	 * 
	 * @param dictDetail
	 *            字典详细值
	 * @return
	 */
	boolean delDictionaryDetail(SystemDictionaryDetail dictDetail);

	/**
	 * 通过字典查询详细字典值信息，返回结果按sequence排序
	 * 
	 * @param dict
	 * @return
	 */
	IPageList getDetailByDictionary(SystemDictionary dict);

	/**
	 * 根据自定义查询条件查询字典值
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
