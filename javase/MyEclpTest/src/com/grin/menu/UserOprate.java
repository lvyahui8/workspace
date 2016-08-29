package com.grin.menu;

import java.util.Iterator;
import java.util.List;

import com.grin.dao.factory.DAOFactory;
import com.grin.util.InputData;
import com.grin.vo.User;

public class UserOprate 
{
	public static void insert(){
		User user = new User();
		InputData input = new InputData();
		user.setName(input.getString("������������"));
		user.setSex(input.getString("�������Ա�"));
		user.setBirthday(input.getDate("���������գ�","���ݱ��������ڣ�yyyy-mm-dd��,"));
		try {
		    DAOFactory.getIUserDAOInstance().doCreate(user);
		}
		catch (Exception ex) {
		    ex.printStackTrace();
		}		
	}

	public static void update(){
		InputData input = new InputData();
		int id = input.getInt("������Ҫ�޸��û��ı�ţ�","��ű��������֣�");
		User user = null;
		try {
		    user = DAOFactory.getIUserDAOInstance().findById(id);
		}
		catch (Exception ex) {
		    ex.printStackTrace();
		}
		
		if(user != null){
			user.setName(input.getString("������������ԭ������"+user.getName()+"����"));
			user.setSex(input.getString("�������Ա�ԭ�Ա�"+user.getSex()+"����"));
			user.setBirthday(input.getDate("���������գ�ԭ���գ�"+user.getBirthday()+"����","���ݱ��������ڣ�yyyy-mm-dd����"));
			try {
				DAOFactory.getIUserDAOInstance().doUpdate(user);
			} catch (Exception e) {
				
			}
			finally{
				
			}
		}
		else{
			System.out.println("Ҫ���µ��û�������");
		}
	}
	
	public static void delete(){
		InputData input = new InputData();
		int id = input.getInt("������Ҫ��ѯ�ı�ţ�", "��ű��������֣�");
		try {
			DAOFactory.getIUserDAOInstance().doDelete(id);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void findId(){
		InputData input = new InputData();
		int id = input.getInt("������Ҫ��ѯ�ı�ţ�", "��ű��������֣�");
		User user = null;
		try{
			user = DAOFactory.getIUserDAOInstance().findById(id);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		if(user != null){
			System.out.println(user);
		}
		else{
			System.out.println("Ҫ���ҵ��û�������");
		}
	}
	
	public static void findAll(){
		InputData input = new InputData();
		
		String keyWord = input.getString("������Ҫ��ѯ�Ĺؼ��֣�");
		List<User> allUser = null;
		
		try {
			allUser = DAOFactory.getIUserDAOInstance().findAll(keyWord);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		for (Iterator<User> iterator = allUser.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			System.out.println(user);
		}
	}
	
}
