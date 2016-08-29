package com.wyyfl.calendarnotepad.dao;

import java.sql.SQLException;

import com.wyyfl.calendarnotepad.vo.Date;
/**
 * 数据库访问的代理者，主要负责为实际数据库访问者提供连接，以及将自定义Date转换为java.sql.Date
 * @author Agrin
 * @version 1.0
 */
public interface INoteDAOProxy {
	/**
	 * 建立数据库连接，当要执行数据操作时，应该先调用此方法
	 * @return 建立成功返回true，否则返回false
	 */
	public  boolean connect();
	/**
	 * 查找指定日期的日记内容
	 * @param date 自定义Date，要查找的日期
	 * @return 存在并查找成功返回日记内容，否则返回null
	 * @throws SQLException
	 */
	public String find(Date date) throws SQLException ;
	/**
	 * 更新指定日期的日记内容
	 * @param date 自定义Date，要更新的日期
	 * @param noteContent 日记内容
	 * @throws SQLException
	 */
	public void update(Date date, String noteContent) throws SQLException ;
	/**
	 * 新建日记内容在指定的日期
	 * @param date 日期
	 * @param noteContent 日记内容
	 * @throws SQLException
	 */
	public void create(Date date, String noteContent) throws SQLException ;
	
	/**
	 * 删除指定日记的日记内容
	 * @param date 日期
	 * @throws SQLException
	 */
	public void delete(Date date) throws SQLException ;
	
	/**
	 * 关闭数据库链接，当不再执行数据操作时，应该先调用此方法
	 */
	public void close();
}
