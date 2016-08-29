import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import util.DBConnection;

/**
 * jdbc连接数据库类
 * 
 * @author haisheng
 * 
 */
public class CopyOfJdbcDao {

	// 系统库标志；系统库为true；用户库为false (项目中要连2个库)
	private boolean falg;

	private CopyOfJdbcDao() {
	}

	/**
	 * @param sysflag
	 *            系统库标志；系统库为true；用户库为false
	 */
	public CopyOfJdbcDao(boolean sysflag) {
		falg = sysflag;
	}

	protected DBConnection connMagager = new DBConnection();

	public List findAll(Object obj) throws Exception {
		List list = null;
		try {
			Statement sql_statement = connMagager.getDBConenction(falg)
					.createStatement();
			String tablename = obj.getClass().getName();
			tablename = tablename.substring(tablename.lastIndexOf(".") + 1);
			ResultSet rs = sql_statement.executeQuery("select * from "
					+ tablename);
			list = new ArrayList();

			if (rs != null) {
				while (rs.next()) {
					list.add(creatObject(rs, obj));
				}
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			connMagager.closeConn();
		}
	}

	public List findByNamedQuery(Object obj, String query) throws Exception {
		// TODO Auto-generated method stub
		List list = null;
		try {
			Statement sql_statement = connMagager.getDBConenction(falg)
					.createStatement();
			ResultSet rs = sql_statement.executeQuery(query);
			list = new ArrayList();

			if (rs != null) {
				while (rs.next()) {
					list.add(creatObject(rs, obj));
				}
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			connMagager.closeConn();
		}

	}

	public List findByNamedQuery(Object obj, Map condition) throws Exception {
		List list = null;
		try {

			String tablename = obj.getClass().getName();
			tablename = tablename.substring(tablename.lastIndexOf(".") + 1);
			StringBuffer sb = new StringBuffer("select * from " + tablename);
			PreparedStatement state = null;
			state = connMagager.getDBConenction(falg).prepareStatement(
					buildQueryString(sb, condition));
			state = setSqlValue(state, condition);
			ResultSet rs = state.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					list.add(creatObject(rs, obj));
				}
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			connMagager.closeConn();
		}
	}

	public Long findCount(final String tablename, final String condition)
			throws Exception {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			Statement sql_statement = connMagager.getDBConenction(falg)
					.createStatement();
			String query = "select count(*) from " + tablename;
			if (condition != null && condition.length() > 6) {
				query += condition;
			}
			System.out.println(query);
			ResultSet result = sql_statement.executeQuery(query);
			while (result.next()) {
				count = result.getLong(1);
			}
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			connMagager.closeConn();
		}

	}

	public Object getByPrimarykey(Object obj, Map primarykey) throws Exception {
		try {
			String tablename = obj.getClass().getName();
			tablename = tablename.substring(tablename.lastIndexOf(".") + 1);
			StringBuffer sb = new StringBuffer("select * from " + tablename);
			PreparedStatement state = null;

			state = connMagager.getDBConenction(falg).prepareStatement(
					buildQueryString(sb, primarykey));
			state = setSqlValue(state, primarykey);
			ResultSet rs = state.executeQuery();

			if (rs != null && rs.next()) {// 只返回第一条记录
				return creatObject(rs, obj);
			} else {
				return null;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {

			connMagager.closeConn();
		}
	}

	public List findPageByQuery(Object obj, String queryString, int start,
			int length) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 构建sql语句
	 * 
	 * @param sb
	 *            where之前的sql
	 * @param condition
	 *            条件条件(key:字段名；value:值)
	 * @return
	 */
	private String buildQueryString(StringBuffer sb, Map condition) {
		if (!condition.isEmpty()) {
			sb.append(" where ");
			int i = 0;

			for (Iterator it = condition.keySet().iterator(); it.hasNext();) {
				String key = (String) it.next();
				if (key == null) {
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

	private PreparedStatement setSqlValue(PreparedStatement state, Map condition)
			throws SQLException {
		if (!condition.isEmpty()) {
			int i = 1;
			for (Iterator it = condition.keySet().iterator(); it.hasNext();) {
				Object value = condition.get(it.next());
				if (value instanceof Integer) {
					state.setInt(i++, (Integer) value);
				} else if (value instanceof String) {

					state.setString(i++, (String) value);

				} else if (value instanceof Double) {

					state.setDouble(i++, (Double) value);

				} else if (value instanceof Float) {

					state.setFloat(i++, (Float) value);

				} else if (value instanceof Long) {

					state.setLong(i++, (Long) value);

				} else if (value instanceof Date) {

					state.setDate(i++, (Date) value);
				}
			}

		}
		return state;
	}

	/**
	 * 利用反射通过数据集创建对象 (要求pojo类的set方法名称必须是set+属性名，其中属性名首字母必须大写)
	 * 
	 * @param rs
	 *            数据集
	 * @param obj
	 *            要创建对象的名称
	 * @return
	 * @throws Exception
	 */
	private Object creatObject(ResultSet rs, Object obj) throws Exception {
		Object object = obj.getClass().newInstance();
		Field[] fields = obj.getClass().getDeclaredFields();
		Method[] mds = obj.getClass().getDeclaredMethods();

		for (int i = 0; i < fields.length; i++) {
			String methodName = "set"
					+ fields[i].getName().substring(0, 1).toUpperCase()
					+ fields[i].getName().substring(1);

			Method method = null;

			for (int j = 0; j < mds.length; j++) {
				if (mds[j].getName().equals(methodName)) {
					method = mds[j];
					break;
				}
			}

			// 类型转换
			String filedtype = fields[i].getGenericType().toString();
			if (filedtype.endsWith("Long")) {
				method.invoke(object,
						new Object[] { rs.getLong(fields[i].getName()) });
			} else if (filedtype.endsWith("Integer")) {
				method.invoke(object,
						new Object[] { rs.getInt(fields[i].getName()) });
			} else if (filedtype.endsWith("Double")) {
				method.invoke(object,
						new Object[] { rs.getDouble(fields[i].getName()) });
			} else if (filedtype.endsWith("Float")) {
				method.invoke(object,
						new Object[] { rs.getFloat(fields[i].getName()) });
			} else if (filedtype.endsWith("Short")) {
				method.invoke(object,
						new Object[] { rs.getShort(fields[i].getName()) });
			} else if (filedtype.endsWith("Byte")) {
				method.invoke(object,
						new Object[] { rs.getByte(fields[i].getName()) });
			} else if (filedtype.endsWith("Date")) {
				method.invoke(object,
						new Object[] { rs.getDate(fields[i].getName()) });
			} else {
				method.invoke(object,
						new Object[] { rs.getString(fields[i].getName()) });
			}

		}
		return object;
	}

}