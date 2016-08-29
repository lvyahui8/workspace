package com.meybosoft.microerp.business.impl;

import java.util.Date;

import com.easyjf.web.tools.ActiveUser;
import com.meybosoft.microerp.system.*;

public class SystemRole {
	private com.easyjf.web.tools.IDAO dao;	
	public ActiveUser login(String userName,String password,String ip)
	{
		ActiveUser user=null;
		SystemUser u=(SystemUser)dao.get(SystemUser.class,userName);
		if(u!=null && password.equals(u.getPassword().trim()))
		{
			user=new ActiveUser();		
			user.setUserName(u.getUserName().trim());		
			user.setIp(ip);
			user.setCurPosition("µ±«∞Œª÷√");
			user.setPassword(u.getPassword().trim());
			user.setLoginTime(new Date());				
			u.setLastLoginIP(ip);
			//user.setDept(u.getBelongDept());
			u.setLoginTimes( new Integer(u.getLoginTimes()==null?1:u.getLoginTimes().intValue()+1));
			this.update(u);
		}	
		return user;
	}
	public void setDao(com.easyjf.web.tools.IDAO dao) {
		this.dao = dao;
	}	
	public Popedom getPopedom(String cid) {
		return (Popedom) dao.get(Popedom.class, cid);
	}
	public void save(Object obj)
	{
		dao.save(obj);
	}
	public void update(Object obj) {
		dao.update(obj);
	}
	public void del(Object obj) {
		dao.del(obj);
	}
}
