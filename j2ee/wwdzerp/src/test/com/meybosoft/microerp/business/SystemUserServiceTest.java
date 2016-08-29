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
	//��������û�
	public void testAddSystemUser(){
		SystemUser user = new SystemUser();
		user.setId(1l);
		user.setUserName("maowei");
		user.setPassword("12345678");
		user.setTel("13251114955");
		assertNull("�û����Ѵ���", service.getSystemUserByName("maowei"));
		assertTrue("����û�ʧ��", service.addSystemUser(user));	
	}
	//�����û���¼
	public void testLogin(){
		SystemUser user = new SystemUser();
		user.setUserName("maowei");
		user.setPassword("12345678");
		user.setLastLoginIP("10.0.0.138");
		assertNotNull("��½ʧ��", service.login(user.getUserName(), user.getPassword(), user.getLastLoginIP()));
	}
	//�����û�ע��
	public void testLogout(){
		ActiveUser user = new ActiveUser();
		user.setUserName("maowei");
		user.setPassword("12345678");
		assertTrue("ע��ʧ��", service.logout(user));
	}
	//�����޸��û�����
	public void testChangePassword(){
		//����ID���������е��û�
		SystemUser user = service.getSystemUser(1l);
		assertNotNull("�û�������", user);
		assertTrue("�޸�����ʧ��", service.changePassword(user, "444333222", "12345678"));
	}
	
	//���Ը����û�����ȡ�û�
	public void testGetSystemUser_user(){
		SystemUser user = service.getSystemUserByName("maowei");
		assertNotNull("�û�������", user);
		System.out.println("�û���:" + user.getUserName());
		System.out.println("��  ��:" + user.getPassword());
	}
	//���Ը���Id�Ŷ�ȡ�û�
	public void testGetSystemUser_id(){
		SystemUser user = service.getSystemUser(1l);
		assertNotNull("�û�������", user);
		System.out.println("�û���:" + user.getUserName());
		System.out.println("��  ��:" + user.getPassword());
	}
	//�����޸��û���Ϣ
	public void testUpdateSystemUser(){
		SystemUser user = service.getSystemUser(1l);
		assertNotNull("�û�������", user);
		user.setTel("123321123");
		user.setEmail("ksmwly@163.com");
		assertTrue("�޸��û���Ϣʧ��", service.updateSystemUser(user));
	}
	
	//����������ѯ�û���Ϣ
	public void testQuerySystemUser(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add("ksmwly@163.com");
		IPageList pageList=service.querySystemUser("email=?", paras, 0, 15);
		java.util.List list =pageList.getResult();
		assertTrue("��ѯʧ��", list.size()>0);
		assertTrue("���Ͳ�ƥ��", list.get(0).getClass() == SystemUser.class);
		for(int i=0; i<list.size(); i++){
			SystemUser user = (SystemUser) list.get(i);
			System.out.println(user.getUserName());
		}
	}
	
	//����ɾ���û�
	public void testDelSystemUser(){
		SystemUser user = service.getSystemUser(1l);
		assertNotNull("�û�������", user);
		assertTrue("ɾ���û�ʧ��", service.delSystemUser(user));
	}
	
}
