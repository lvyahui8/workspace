package com.wyyfl.calendarnotepad.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
/**
 * ʵ�����ݿ����ִ����
 * @author Agrin
 * @version 1.0
 */
public interface INoteDAO {
	/**
	 * �������ݿ�����
	 * @param connection ���ݿ�����
	 */
	public void setConnection(Connection connection);
	
	/**
	 * ����ָ�����ڵ��ռ�����
	 * @param date java.sql.Date��Ҫ���µ�����
	 * @param noteContent �ռ�����
	 * @throws SQLException
	 */
	public boolean update(Date d, String noteContent) throws SQLException;
	/**
	 * �½��ռ�������ָ��������
	 * @param date java.sql.Date������
	 * @param noteContent �ռ�����
	 * @throws SQLException
	 */
	public boolean create(Date d, String noteContent) throws SQLException;

	/**
	 * ɾ��ָ���ռǵ��ռ�����
	 * @param date java.sql.Date������
	 * @throws SQLException
	 */
	public boolean delete(Date d) throws SQLException ;
	/**
	 * ����ָ�����ڵ��ռ�����
	 * @param date java.sql.Date��Ҫ���ҵ�����
	 * @return ���ڲ����ҳɹ������ռ����ݣ����򷵻�null
	 * @throws SQLException
	 */
	public String find(Date d) throws SQLException;
}
