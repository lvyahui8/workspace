package com.grin.dao;

import java.util.List;

import com.grin.vo.User;

public interface IUserDAO {
	//��ʾ���ݿ�����Ӳ���
	public boolean doCreate(final User user) throws Exception;
	//��ʾ���ݿ�ĸ��²���
	public boolean doUpdate(final User user) throws Exception;
	//��ʾ���ݿ��ɾ������
	public boolean doDelete(final int id) throws Exception;
	//��ʾ���ݿ�Ĳ�ѯ����
	public User findById(final int id) throws Exception;
	//��ʾ���ݿ�����Ӳ�������ѯ���е�
	public List<User> findAll(final String keyWord) throws Exception;
}
