package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IActiveUser;
import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.system.SystemUser;

public interface SystemUserService {
	/**
	 * 用户登录
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	IActiveUser login(String userName, String password,String ip);

	/**
	 * 注销用户
	 * 
	 * @param user
	 */
	boolean logout(IActiveUser user);// 用户退出登录

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	boolean addSystemUser(SystemUser user);// 添加用户

	/**
	 * 删除用户
	 * 
	 * @param user
	 */
	boolean delSystemUser(SystemUser user);// 删除用户

	/**
	 * 修改用户
	 * 
	 * @param user
	 */
	boolean updateSystemUser(SystemUser user);// 修改用户

	/**
	 * 根据用户名读取用户
	 * 
	 * @param userName
	 *            用户名
	 * @return
	 */
	SystemUser getSystemUserByName(String userName);// 

	/**
	 * 根据Id号查询用户
	 * 
	 * @param id
	 *            用户ID号
	 * @return
	 */
	SystemUser getSystemUser(Long id);

	/**
	 * 更改用户密码
	 * 
	 * @param user
	 *            用户
	 * @param newPassword
	 *            新密码
	 * @param oldPassword
	 *            旧密码
	 */
	boolean changePassword(SystemUser user, String newPassword, String oldPassword);

	/**
	 * 批量查询用户信息
	 * 
	 * @param scope
	 *            查询条件
	 * @param paras
	 *            条件值
	 * @param begin
	 *            开始记录数
	 * @param max
	 *            返回的最大结果数
	 * @return
	 */
	IPageList querySystemUser(String scope, java.util.Collection paras, int currentPage,
			int pageSize);// 查询用户信息
}
