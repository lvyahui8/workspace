package com.meybosoft.microerp.business.impl;

import java.util.Collection;
import java.util.List;

import com.easyjf.util.Assert;
import com.easyjf.util.MD5;
import com.easyjf.web.tools.ActiveUser;
import com.easyjf.web.tools.DbPageList;
import com.easyjf.web.tools.IActiveUser;
import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.CurrentUser;
import com.meybosoft.microerp.business.LogicException;
import com.meybosoft.microerp.business.SystemUserService;
import com.meybosoft.microerp.system.SystemRegion;
import com.meybosoft.microerp.system.SystemUser;

public class SystemUserServiceImpl extends AbstractDAOServiceSupport implements SystemUserService 
{
	private static SystemUserServiceImpl singleton=new SystemUserServiceImpl();
	public static SystemUserServiceImpl getInstance()
	{
		return singleton;
	}
	//添加一个用户,先在表中查询此用户是否存在
	public boolean addSystemUser(SystemUser user) {
		//先检测传入的对象中的用户名是否在数据库的表中存在
		SystemUser obj = (SystemUser) this.dao.getBy(SystemUser.class, "userName", user.getUserName());		
		if(obj != null) throw new LogicException("此用户以存在!");
		if(user.getPassword()==null)user.setPassword("123456");//设置默认密码
		//MD5加密密码		
		String md5 = MD5.encode(user.getPassword());
		user.setPassword(md5);
		user.setLoginTimes(new Integer(1));
		return this.dao.save(user);
	}
	//修改用户密码 先判断输入的原密码是否正确
	public boolean changePassword(SystemUser u, String newPassword,
			String oldPassword) {
		SystemUser user=getSystemUserByName(u.getUserName());//重新查询一次
		String md5=MD5.encode(oldPassword);
		if(!user.getPassword().equals(md5)) throw new LogicException("旧密码错误！");
		user.setPassword(MD5.encode(newPassword));
		return this.dao.update(user);
	}
	//删除用户
	public boolean delSystemUser(SystemUser user) {
		return this.dao.del(user);
	}
	//根据用户名读取用户
	public SystemUser getSystemUserByName(String userName) {
		return (SystemUser) this.dao.getBy(SystemUser.class, "userName",userName);
	}
	//根据ID读取用户
	public SystemUser getSystemUser(Long id) {
		return (SystemUser) this.dao.getBy(SystemUser.class, "id", id);
	}
	//用户登陆
	public IActiveUser login(String userName, String password, String ip) {	
		Assert.notNull(userName);
		Assert.notNull(password);		
		SystemUser system = (SystemUser) getSystemUserByName(userName);		
		if(system == null)throw new LogicException("用户不存在!");		
		String md5=MD5.encode(password);
		if(!md5.equals( system.getPassword() )) throw new LogicException("用户密码错误！");		
		system.setLoginTimes(new Integer(system.getLoginTimes().intValue()+1));//登陆次数+1
		system.setLastLoginTime(new java.util.Date());	//最后登陆时间
		system.setLastLoginIP(ip);		//最后登陆IP
		updateSystemUser(system);
		
		ActiveUser user=new ActiveUser();		
		user.setUserName(userName);
		user.setPassword(system.getPassword());
		user.setIp(ip);
		user.setLoginTime(system.getLastLoginTime());
		CurrentUser.setCurrnetUser(user);
		return user;

	}
	//用户注销
	public boolean logout(IActiveUser user) {
		CurrentUser.setCurrnetUser(null);
		return true;
	}
	//自定义查询用户信息
	public IPageList querySystemUser(String scope, Collection paras, int currentPage,
			int pageSize) {	
		DbPageList pageList=new DbPageList(SystemUser.class,scope,paras,dao);
		pageList.doList(currentPage, pageSize);	
		return pageList;
	}
	//修改用户信息
	public boolean updateSystemUser(SystemUser user) {
		SystemUser u=getSystemUser(user.getId());
		user.setPassword(u.getPassword());//恢复密码信息
		return this.dao.update(user);
	}

}
