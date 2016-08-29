package com.wyyfl.calendarnotepad.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
/**
 * 实际数据库操作执行者
 * @author Agrin
 * @version 1.0
 */
public interface INoteDAO {
	/**
	 * 设置数据库连接
	 * @param connection 数据库连接
	 */
	public void setConnection(Connection connection);
	
	/**
	 * 更新指定日期的日记内容
	 * @param date java.sql.Date，要更新的日期
	 * @param noteContent 日记内容
	 * @throws SQLException
	 */
	public boolean update(Date d, String noteContent) throws SQLException;
	/**
	 * 新建日记内容在指定的日期
	 * @param date java.sql.Date，日期
	 * @param noteContent 日记内容
	 * @throws SQLException
	 */
	public boolean create(Date d, String noteContent) throws SQLException;

	/**
	 * 删除指定日记的日记内容
	 * @param date java.sql.Date，日期
	 * @throws SQLException
	 */
	public boolean delete(Date d) throws SQLException ;
	/**
	 * 查找指定日期的日记内容
	 * @param date java.sql.Date，要查找的日期
	 * @return 存在并查找成功返回日记内容，否则返回null
	 * @throws SQLException
	 */
	public String find(Date d) throws SQLException;
}
