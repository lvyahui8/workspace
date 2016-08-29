package com.sldll.cms.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//0oO
public class GeneralDAO {

	//---------------------------------��ѯ����--------------------------------------------------------------------------
	/**
	 * ��ѯ���м�¼
	 * @param obj	���Ӧ��JavaBean����
	 * @return		���м�¼���ɵ�list
	 * @throws Exception
	 */
	public List<Object> findAll(Object obj) throws Exception {

		List<Object> list = new ArrayList<Object>();
		ResultSet rs = null;
		try {

			// ��ȡ���ݿ�����
			Statement stmt = DBConnectionManager.getConnection()
					.createStatement();
			// ����sql���
			String tableName = obj.getClass().getName();
			tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
			String sql = "select * from " + tableName;
System.out.println(sql);
			// ִ��sql���
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				list.add(createObj(rs, obj));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			// �ر�����
			if (rs != null) {
				rs.close();
			}
			DBConnectionManager.closeConnection();
		}

		return list;
	}

	/**
	 * ��ָ���ı�ִ��ָ����sql��ѯ���
	 * @param obj
	 * 			�Ըñ��Ӧ��JavaBean���������
	 * @param query
	 * 			Ҫ�Ըñ�ִ�е�sql���
	 * @return
	 * @throws Exception
	 */
	public List<Object> findByNameQuery(Object obj, String query) throws Exception {
		// TODO Auto-generated method stub
		List<Object> list = null;
		try {
			Statement sql_statement = DBConnectionManager.getConnection()
					.createStatement();
			//ִ�д��ݵ�sql���
			ResultSet rs = sql_statement.executeQuery(query);
			list = new ArrayList<Object>();
			if (rs != null) {
				while (rs.next()) {
					list.add(createObj(rs, obj));
				}
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			DBConnectionManager.closeConnection();
		}

	}

	/**
	 * ��������ָ������в�ѯ
	 * @param obj
	 * 		�Ըñ��Ӧ��JavaBean���������
	 * @param condition
	 * 		��ѯ��������key������		value��ֵ
	 * @param isFuzzzy
	 *		�Ƿ�֧��ģ����ѯ
	 * @return
	 * @throws Exception
	 */
	public List<Object> findByNameQuery(Object obj, Map<Object,Object> condition,boolean isFuzzy) throws Exception {
		List<Object> list = new ArrayList<Object>();
		try {
			
			String tablename = getTableName(obj);
			StringBuilder sb = new StringBuilder("select * from " + tablename);
			PreparedStatement state = null;
			if(isFuzzy){
				addFuzzyConditionString(sb, condition);
			}
			else{
				addConditionString(sb, condition);
			}
			state = DBConnectionManager.getConnection().prepareStatement(sb.toString());
			state = setSqlValue(state, condition,isFuzzy);
			ResultSet rs = state.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					list.add(createObj(rs, obj));
				}
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			DBConnectionManager.closeConnection();
		}
	}



	//-------------------------------------��������--------------------------------------------------------------------------
	/**
	 * �����ݿ����½�һ����¼
	 * @param obj
	 * 		������¼�Ķ���,���������ݿ���ĳ�ű��Ӧ��JavaBean����
	 * @return
	 * 		�½��ɹ������棬���򷵻ؼ�
	 * @throws Exception
	 */
	public boolean create(Object obj) throws Exception{
		// ��ȡ���ݿ�����
		try {
			// ����sql���
			Map<Object, Object> map = getObjectFieldValue(obj);
			String tableName = obj.getClass().getName();
			tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
			StringBuilder sb = new StringBuilder("insert into " + tableName);
			addCreateString(sb, map);
			PreparedStatement  stmt = DBConnectionManager.getConnection()
					.prepareStatement(sb.toString());
			setSqlValue(stmt, map,false);
			int count = stmt.executeUpdate();
			if(count>0){
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBConnectionManager.closeConnection();
		}
	}

	//-------------------------------------ɾ������----------------------------------------------------------------------------
	/**
	 * ɾ���������м�¼
	 * @param obj
	 * 			JavaBean���󣬾���Ҫɾ���������ű�
	 * @return
	 * 			ɾ���ɹ������棬���򷵻ؼ�
	 */
	public boolean deleteAll(Object obj) throws Exception{
		String delete_sql = "delete from "+getTableName(obj);
		PreparedStatement pstmt;
		try {
			pstmt = DBConnectionManager.getConnection().prepareStatement(delete_sql);
			int count = pstmt.executeUpdate();
			if(count>0){
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		finally{
			DBConnectionManager.closeConnection();
		}
		
	}
	
	/**
	 * ��ָ������ɾ������ID�ļ�¼
	 * @param obj
	 * 		��ʾҪɾ���ı�
	 * @param condition
	 * 		ɾ�������� key:�ֶ�(һ��Ϊ�ַ���) value:ֵ
	 * @return
	 */
	public boolean delete(Object obj,Map<Object,Object> condition) throws Exception{
		//����sql���
		StringBuilder sb = new StringBuilder("delete from "+getTableName(obj));
		addConditionString(sb, condition);
		try {
			PreparedStatement pstmt = DBConnectionManager.getConnection().prepareStatement(sb.toString());
			setSqlValue(pstmt, condition,false);
			int count = pstmt.executeUpdate();
			if(count > 0){
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		finally{
			DBConnectionManager.closeConnection();
		}
	}
	
	//-------------------------------------���²���----------------------------------------------------------------------------
	/**
	 * ����ָ����ļ�¼
	 * @param obj
	 * 		����ȷ�����Java����
	 * @param map
	 * 		Ҫ���õ��ֶ�ֵ��key���ֶΣ��ַ�����,value��ֵ
	 * @param condition
	 * 		ɸѡ����
	 * @return
	 */
	public boolean update(Object obj,Map<Object,Object> map,Map<Object, Object>condition) throws Exception {
		StringBuilder sb = new StringBuilder("update "+getTableName(obj));
		addSetString(sb,map);
		addConditionString(sb, condition);
		try {
			PreparedStatement pstmt = DBConnectionManager.getConnection().prepareStatement(sb.toString());
			List<Object> values =  new ArrayList<Object>();
			getValuesToList(values,map);
			getValuesToList(values, condition);
			setSqlValue(pstmt, values);

			int count = pstmt.executeUpdate();
			if(count > 0){
				return true;
			}
			else{
				return false;
			}
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		finally{
			DBConnectionManager.closeConnection();
		}
	}

	private List<Object> getValuesToList(List<Object> values,Map<Object, Object> map) {
		
		for (Iterator<Object> it = map.keySet().iterator(); it.hasNext();) {
			Object value =  map.get(it.next());
			values.add(value);
		}
		return values;
	}
	
	


	/**
	 * ��ȡJavaBean������ֶ�ֵ�ŵ�������
	 * @param obj
	 * 			JavaBean����
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private Map<Object, Object> getObjectFieldValue(Object obj)
			throws IllegalAccessException, InvocationTargetException {
		Map<Object, Object> map = new HashMap<Object,Object>();
		
		Field fields[] = obj.getClass().getFields();
		Method methods[] = obj.getClass().getMethods();

		// ���ֶ�����ֵ
		for (int i = 0; i < fields.length; i++) {
			// ���ֶε����ֹ���set����������
			String fieldName = fields[i].getName();
			
			String methodName = "get" + fieldName.substring(0, 1).toUpperCase()
					+ fieldName.substring(1);

			// ���Ҷ�Ӧ�ķ���
			Method method = null;
			for (int j = 0; j < methods.length; j++) {
				if (methods[j].getName().equals(methodName)) {
					method = methods[j];
					break;
				}
			}
			// ��������������
			if (method != null) {
				// ��ʼִ�з�������ȡ��ǰ��JavaBean�����ֶ�ֵ
				Object value = method.invoke(obj, new Object[] { });
				map.put(fieldName, value);
			}
		}
		return map;
	}
	
	private void addSetString(StringBuilder sb, Map<Object, Object> map) {
		// TODO Auto-generated method stub
		if (!map.isEmpty()) {
			sb.append(" set ");
			for (Iterator<Object> it = map.keySet().iterator(); it.hasNext();) {
				String key = (String) it.next();
				if (null == key) {
					continue;
				}
				sb.append(key+"=?,");				
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			System.out.println(sb.toString());
		}
	}
	
	/**
	 * ������sql����������׷���ֶ�����ռλ��
	 * @param sb
	 * @param map
	 */
	private void addCreateString(StringBuilder sb,Map<Object, Object> map) {
		// TODO Auto-generated method stub
		sb.append("(");
		int count = 0;
		for (Iterator<Object> it = map.keySet().iterator(); it.hasNext();) {
			String key = (String) it.next();
			if (null == key) {
				continue;
			}
			sb.append(key + ",");
			count++;
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(") values(");
		for (int i = 0; i < count; i++) {
			sb.append("?,");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(")");
		System.out.println(sb.toString());
	}

	/**
	 * ������sql��ѯ������׷���ж�����
	 * @param sb  			where֮ǰ��sql         
	 * @param condition 	����(key:�ֶ�����value:ֵ)       
	 * @return	ʹ��ռλ����sql���
	 */
	private String addConditionString(StringBuilder sb, Map<Object,Object> condition) {
		if (!condition.isEmpty()) {
			sb.append(" where ");
			int i = 0;

			for (Iterator<Object> it = condition.keySet().iterator(); it.hasNext();) {
				String key = (String) it.next();
				if (null == key) {
					continue;
				}
				if (i != 0) {
					sb.append(" and ");
				}
				if (key.indexOf("<") != -1 || key.indexOf(">") != -1
						|| key.indexOf("=") != -1) {
					sb.append(key + "?");
				} else {
					sb.append(key + "=" + "?");
				}

				i++;

			}

		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	private String addFuzzyConditionString(StringBuilder sb,Map<Object,Object>condition) {
		if (!condition.isEmpty()) {
			sb.append(" where ");
			int i = 0;

			for (Iterator<Object> it = condition.keySet().iterator(); it.hasNext();) {
				String key = (String) it.next();
				if (null == key) {
					continue;
				}
				if (i != 0) {
					sb.append(" or ");
				}
				sb.append(key + " like " +"?");
				i++;
			}

		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	/**
	 * ��������sql����ռλ����ֵ
	 * @param state
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	private PreparedStatement setSqlValue(PreparedStatement state, Map<Object,Object> map,boolean isFuzzy)
			throws SQLException {
		if (!map.isEmpty()) {
			int i = 1;
			for (Iterator<Object> it = map.keySet().iterator(); it.hasNext();) {
				Object value = map.get(it.next());
				if(isFuzzy){
					state.setObject(i++, "%"+value+"%");
				}else{
					state.setObject(i++, value);
				}
			}

		}
		return state;
	}
	private PreparedStatement setSqlValue(PreparedStatement state, List<Object> values)
			throws SQLException {
		if (!values.isEmpty()) {
			int i = 1;
			for (Iterator<Object> it = values.iterator(); it.hasNext();) {
				Object value = it.next();
				state.setObject(i++, value);
			}
			
		}
		return state;
	}
	
	private String getTableName(Object obj) {
		String tablename = obj.getClass().getName();
		tablename = tablename.substring(tablename.lastIndexOf(".") + 1);
		return tablename;
	}
	// ���÷��乹������
	
	private Object createObj(ResultSet rs, Object obj)
			throws  Exception {
		// TODO Auto-generated method stub
		Object object = obj.getClass().newInstance();
		// ��ȡ�ֶ�
		Field fields[] = obj.getClass().getFields();
		// ��ȡ����
		Method methods[] = obj.getClass().getMethods();

		// ���ֶ�����ֵ
		for (int i = 0; i < fields.length; i++) {
			// ���ֶε����ֹ���set����������
			String fieldName = fields[i].getName();
			String methodName = "set" + fieldName.substring(0, 1).toUpperCase()
					+ fieldName.substring(1);

			// ���Ҷ�Ӧ�ķ���
			Method method = null;
			for (int j = 0; j < methods.length; j++) {
				if (methods[j].getName().equals(methodName)) {
					method = methods[j];
					break;
				}
			}

			// ��������������
			if (method != null) {
				// ��ʼִ�з�����Ϊ��ǰ��JavaBean�����ֶ�����ֵ
				Object value = rs.getObject(fieldName);
				method.invoke(object, new Object[] { value });

			}
		}
		return object;
	}
	
	
}
