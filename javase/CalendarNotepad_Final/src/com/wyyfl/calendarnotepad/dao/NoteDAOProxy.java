package com.wyyfl.calendarnotepad.dao;

import java.sql.SQLException;

import com.wyyfl.calendarnotepad.vo.Date;

public class NoteDAOProxy implements INoteDAOProxy {
	DataBaseConnection dbc = new DataBaseConnection();
	INoteDAO dao = new NoteDAO();
	@Override
	public boolean connect() {
		// TODO Auto-generated method stub
		dao.setConnection(dbc.getConnection());
		return false;
	}
	
	
	@Override
	public String find(Date date) throws SQLException {
		// TODO Auto-generated method stub
		//自定义date转换为java.sql.date
		java.sql.Date date2= java.sql.Date.valueOf(date.toString());
		;
		return dao.find(date2);
	}

	@Override
	public void update(Date date, String noteContent) throws SQLException {
		// TODO Auto-generated method stub
		java.sql.Date date2= java.sql.Date.valueOf(date.toString());
		dao.update(date2, noteContent);
	}

	@Override
	public void create(Date date, String noteContent) throws SQLException {
		// TODO Auto-generated method stub
		java.sql.Date date2= java.sql.Date.valueOf(date.toString());
		dao.create(date2, noteContent);
	}

	@Override
	public void delete(Date date) throws SQLException {
		// TODO Auto-generated method stub
		java.sql.Date date2= java.sql.Date.valueOf(date.toString());
        dao.delete(date2);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		dbc.close();
	}

}
