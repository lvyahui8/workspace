package com.wyyfl.calendarnotepad.dao;

import java.sql.SQLException;

import com.wyyfl.calendarnotepad.vo.Date;
/**
 * ���ݿ���ʵĴ����ߣ���Ҫ����Ϊʵ�����ݿ�������ṩ���ӣ��Լ����Զ���Dateת��Ϊjava.sql.Date
 * @author Agrin
 * @version 1.0
 */
public interface INoteDAOProxy {
	/**
	 * �������ݿ����ӣ���Ҫִ�����ݲ���ʱ��Ӧ���ȵ��ô˷���
	 * @return �����ɹ�����true�����򷵻�false
	 */
	public  boolean connect();
	/**
	 * ����ָ�����ڵ��ռ�����
	 * @param date �Զ���Date��Ҫ���ҵ�����
	 * @return ���ڲ����ҳɹ������ռ����ݣ����򷵻�null
	 * @throws SQLException
	 */
	public String find(Date date) throws SQLException ;
	/**
	 * ����ָ�����ڵ��ռ�����
	 * @param date �Զ���Date��Ҫ���µ�����
	 * @param noteContent �ռ�����
	 * @throws SQLException
	 */
	public void update(Date date, String noteContent) throws SQLException ;
	/**
	 * �½��ռ�������ָ��������
	 * @param date ����
	 * @param noteContent �ռ�����
	 * @throws SQLException
	 */
	public void create(Date date, String noteContent) throws SQLException ;
	
	/**
	 * ɾ��ָ���ռǵ��ռ�����
	 * @param date ����
	 * @throws SQLException
	 */
	public void delete(Date date) throws SQLException ;
	
	/**
	 * �ر����ݿ����ӣ�������ִ�����ݲ���ʱ��Ӧ���ȵ��ô˷���
	 */
	public void close();
}
