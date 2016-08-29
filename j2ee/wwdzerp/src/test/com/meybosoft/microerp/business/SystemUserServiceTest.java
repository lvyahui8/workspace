package com.meybosoft.microerp.business;

import com.easyjf.web.tools.ActiveUser;
import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.impl.SystemUserServiceImpl;
import com.meybosoft.microerp.system.SystemUser;

import junit.framework.TestCase;

public class SystemUserServiceTest extends TestCase {
	private SystemUserService service;

	@Override
	protected void setUp() throws Exception {
		service = new SystemUserServiceImpl();
		super.setUp();
	}
	//测试添加用户
	public void testAddSystemUser(){
		SystemUser user = new SystemUser();
		user.setId(1l);
		user.setUserName("maowei");
		user.setPassword("12345678");
		user.setTel("13251114955");
		assertNull("用户名已存在", service.getSystemUserByName("maowei"));
		assertTrue("添加用户失败", service.addSystemUser(user));	
	}
	//测试用户登录
	public void testLogin(){
		SystemUser user = new SystemUser();
		user.setUserName("maowei");
		user.setPassword("12345678");
		user.setLastLoginIP("10.0.0.138");
		assertNotNull("登陆失败", service.login(user.getUserName(), user.getPassword(), user.getLastLoginIP()));
	}
	//测试用户注销
	public void testLogout(){
		ActiveUser user = new ActiveUser();
		user.setUserName("maowei");
		user.setPassword("12345678");
		assertTrue("注销失败", service.logout(user));
	}
	//测试修改用户密码
	public void testChangePassword(){
		//先用ID读出数据中的用户
		SystemUser user = service.getSystemUser(1l);
		assertNotNull("用户不存在", user);
		assertTrue("修改密码失败", service.changePassword(user, "444333222", "12345678"));
	}
	
	//测试根据用户名读取用户
	public void testGetSystemUser_user(){
		SystemUser user = service.getSystemUserByName("maowei");
		assertNotNull("用户不存在", user);
		System.out.println("用户名:" + user.getUserName());
		System.out.println("密  码:" + user.getPassword());
	}
	//测试根据Id号读取用户
	public void testGetSystemUser_id(){
		SystemUser user = service.getSystemUser(1l);
		assertNotNull("用户不存在", user);
		System.out.println("用户名:" + user.getUserName());
		System.out.println("密  码:" + user.getPassword());
	}
	//测试修改用户信息
	public void testUpdateSystemUser(){
		SystemUser user = service.getSystemUser(1l);
		assertNotNull("用户不存在", user);
		user.setTel("123321123");
		user.setEmail("ksmwly@163.com");
		assertTrue("修改用户信息失败", service.updateSystemUser(user));
	}
	
	//测试批量查询用户信息
	public void testQuerySystemUser(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add("ksmwly@163.com");
		IPageList pageList=service.querySystemUser("email=?", paras, 0, 15);
		java.util.List list =pageList.getResult();
		assertTrue("查询失败", list.size()>0);
		assertTrue("类型不匹配", list.get(0).getClass() == SystemUser.class);
		for(int i=0; i<list.size(); i++){
			SystemUser user = (SystemUser) list.get(i);
			System.out.println(user.getUserName());
		}
	}
	
	//测试删除用户
	public void testDelSystemUser(){
		SystemUser user = service.getSystemUser(1l);
		assertNotNull("用户不存在", user);
		assertTrue("删除用户失败", service.delSystemUser(user));
	}
	
}
