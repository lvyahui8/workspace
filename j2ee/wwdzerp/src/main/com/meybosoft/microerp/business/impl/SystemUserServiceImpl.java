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
	//���һ���û�,���ڱ��в�ѯ���û��Ƿ����
	public boolean addSystemUser(SystemUser user) {
		//�ȼ�⴫��Ķ����е��û����Ƿ������ݿ�ı��д���
		SystemUser obj = (SystemUser) this.dao.getBy(SystemUser.class, "userName", user.getUserName());		
		if(obj != null) throw new LogicException("���û��Դ���!");
		if(user.getPassword()==null)user.setPassword("123456");//����Ĭ������
		//MD5��������		
		String md5 = MD5.encode(user.getPassword());
		user.setPassword(md5);
		user.setLoginTimes(new Integer(1));
		return this.dao.save(user);
	}
	//�޸��û����� ���ж������ԭ�����Ƿ���ȷ
	public boolean changePassword(SystemUser u, String newPassword,
			String oldPassword) {
		SystemUser user=getSystemUserByName(u.getUserName());//���²�ѯһ��
		String md5=MD5.encode(oldPassword);
		if(!user.getPassword().equals(md5)) throw new LogicException("���������");
		user.setPassword(MD5.encode(newPassword));
		return this.dao.update(user);
	}
	//ɾ���û�
	public boolean delSystemUser(SystemUser user) {
		return this.dao.del(user);
	}
	//�����û�����ȡ�û�
	public SystemUser getSystemUserByName(String userName) {
		return (SystemUser) this.dao.getBy(SystemUser.class, "userName",userName);
	}
	//����ID��ȡ�û�
	public SystemUser getSystemUser(Long id) {
		return (SystemUser) this.dao.getBy(SystemUser.class, "id", id);
	}
	//�û���½
	public IActiveUser login(String userName, String password, String ip) {	
		Assert.notNull(userName);
		Assert.notNull(password);		
		SystemUser system = (SystemUser) getSystemUserByName(userName);		
		if(system == null)throw new LogicException("�û�������!");		
		String md5=MD5.encode(password);
		if(!md5.equals( system.getPassword() )) throw new LogicException("�û��������");		
		system.setLoginTimes(new Integer(system.getLoginTimes().intValue()+1));//��½����+1
		system.setLastLoginTime(new java.util.Date());	//����½ʱ��
		system.setLastLoginIP(ip);		//����½IP
		updateSystemUser(system);
		
		ActiveUser user=new ActiveUser();		
		user.setUserName(userName);
		user.setPassword(system.getPassword());
		user.setIp(ip);
		user.setLoginTime(system.getLastLoginTime());
		CurrentUser.setCurrnetUser(user);
		return user;

	}
	//�û�ע��
	public boolean logout(IActiveUser user) {
		CurrentUser.setCurrnetUser(null);
		return true;
	}
	//�Զ����ѯ�û���Ϣ
	public IPageList querySystemUser(String scope, Collection paras, int currentPage,
			int pageSize) {	
		DbPageList pageList=new DbPageList(SystemUser.class,scope,paras,dao);
		pageList.doList(currentPage, pageSize);	
		return pageList;
	}
	//�޸��û���Ϣ
	public boolean updateSystemUser(SystemUser user) {
		SystemUser u=getSystemUser(user.getId());
		user.setPassword(u.getPassword());//�ָ�������Ϣ
		return this.dao.update(user);
	}

}
