package com.wyyfl.calendarnotepad.dao.test;

import java.sql.SQLException;

import junit.framework.TestCase;

import com.wyyfl.calendarnotepad.dao.INoteDAOProxy;
import com.wyyfl.calendarnotepad.dao.NoteDAOProxy;
import com.wyyfl.calendarnotepad.vo.Date;

public class NoteDAOProxyTest extends TestCase {
	public void testFind() throws SQLException {
		INoteDAOProxy it = new NoteDAOProxy() ;
		Date dates = new Date();
		it.connect();
		String string = it.find(dates);
		System.out.println(string);
        it.close();
	}

	public void testUpdate() throws SQLException {
		Date dates = new Date();
		INoteDAOProxy it = new NoteDAOProxy() ;
		it.connect();
		it.update(dates, "³Ô·¹");
	    it.close();
	}

	public void testCreate() throws SQLException {
		Date dates = new Date();
		INoteDAOProxy it =new NoteDAOProxy() ;
		it.connect();
		it.create(dates, "Ë¯¾õ");
		it.close();
	}

	public void testDelete() throws SQLException {

		Date dates = new Date();
		INoteDAOProxy it =new NoteDAOProxy() ;
		it.connect();
		it.delete(dates);
        it.close();
	}

}
