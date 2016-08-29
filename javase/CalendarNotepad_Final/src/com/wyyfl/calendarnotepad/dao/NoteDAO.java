package com.wyyfl.calendarnotepad.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteDAO implements INoteDAO {

	
	private Connection conn = null;
	

	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
		conn = connection;
	}

	@Override
	public boolean update(Date d, String noteContent) throws SQLException {
		noteContent = toGBK(noteContent);
		boolean flag=false;
		// TODO Auto-generated method stub
		//构造并執行sql语句
//		try{
			PreparedStatement updateDate;
			String updateString="UPDATE note SET noteContent=? WHERE date=?";
			updateDate = conn.prepareStatement(updateString);

			updateDate.setString(1, noteContent);
			updateDate.setDate(2, d);
			updateDate.executeUpdate();
            flag=true;
			
//		}catch(SQLException ex){
//			ex.printStackTrace();
//		}
		return flag;
	}

	private String toGBK(String noteContent) {
		try {
			noteContent = new String(noteContent.getBytes(),"GBK");
			System.out.println(noteContent);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noteContent;
	}
		

	@Override
	public boolean create(Date d, String noteContent) throws SQLException {
		noteContent = toGBK(noteContent);
		boolean flag=false;
//		try{
			PreparedStatement createDate;
			String createProcedure="INSERT INTO note(date,noteContent) VALUES(?,?)";
			createDate = conn.prepareStatement(createProcedure);
			
			createDate.setDate(1, d);
			createDate.setString(2, noteContent);
			
			createDate.executeUpdate();
            flag=true;
			
//		}catch(SQLException ex){
//			ex.printStackTrace();
//		}
		return flag;
	}

	@Override
	public boolean delete(Date d) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag=false;
//		try{
			PreparedStatement deleteDate;
			String deleteString="DELETE FROM note WHERE date=?";
			deleteDate = conn.prepareStatement(deleteString);
			
			deleteDate.setDate(1, d);
			
			deleteDate.executeUpdate();
            flag=true;
			
//		}catch(SQLException ex){
//			ex.printStackTrace();
//		}
		return flag;
		
	}

	@Override
	public String find(Date d) throws SQLException {
		// TODO Auto-generated method stub
		String noteContent = null;
//		try{//异常需要抛出，不要捕获
			PreparedStatement findDate;
			String findString="SELECT date,noteContent FROM note WHERE date=?";
			findDate = conn.prepareStatement(findString);
			
			findDate.setDate(1, d);
			ResultSet rs=findDate.executeQuery();
			//需要判断结果集里面是否有数据
			if(rs.next()){
					noteContent=rs.getString(2);
					noteContent = toGBK(noteContent);
			}
			return noteContent;
//		}catch(SQLException ex){
//			ex.printStackTrace();
//		}
	}

}
