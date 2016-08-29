package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IActiveUser;
import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.system.SystemUser;

public interface SystemUserService {
	/**
	 * �û���¼
	 * 
	 * @param userName
	 *            �û���
	 * @param password
	 *            ����
	 * @return
	 */
	IActiveUser login(String userName, String password,String ip);

	/**
	 * ע���û�
	 * 
	 * @param user
	 */
	boolean logout(IActiveUser user);// �û��˳���¼

	/**
	 * ����û�
	 * 
	 * @param user
	 */
	boolean addSystemUser(SystemUser user);// ����û�

	/**
	 * ɾ���û�
	 * 
	 * @param user
	 */
	boolean delSystemUser(SystemUser user);// ɾ���û�

	/**
	 * �޸��û�
	 * 
	 * @param user
	 */
	boolean updateSystemUser(SystemUser user);// �޸��û�

	/**
	 * �����û�����ȡ�û�
	 * 
	 * @param userName
	 *            �û���
	 * @return
	 */
	SystemUser getSystemUserByName(String userName);// 

	/**
	 * ����Id�Ų�ѯ�û�
	 * 
	 * @param id
	 *            �û�ID��
	 * @return
	 */
	SystemUser getSystemUser(Long id);

	/**
	 * �����û�����
	 * 
	 * @param user
	 *            �û�
	 * @param newPassword
	 *            ������
	 * @param oldPassword
	 *            ������
	 */
	boolean changePassword(SystemUser user, String newPassword, String oldPassword);

	/**
	 * ������ѯ�û���Ϣ
	 * 
	 * @param scope
	 *            ��ѯ����
	 * @param paras
	 *            ����ֵ
	 * @param begin
	 *            ��ʼ��¼��
	 * @param max
	 *            ���ص��������
	 * @return
	 */
	IPageList querySystemUser(String scope, java.util.Collection paras, int currentPage,
			int pageSize);// ��ѯ�û���Ϣ
}
