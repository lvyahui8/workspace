package Denglu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sldll.cms.vo.Waiter;


public class FwyDao {
	public static boolean login(Waiter fwy)
	{
		
		Connection con=null;
		Statement stat=null;
		ResultSet  rs=null;
		try {
			con=BaseDao.getCon();
			stat=con.createStatement();
			String sql="select count(*) from Waiter  where username='"+fwy.getUsername()+"'  and password='"+fwy.getPassword()+"'";
			rs=stat.executeQuery(sql);
			if(rs.next()){
				return true;
			}else
			{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally
		{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			BaseDao.doClose(con, stat,rs);
		}
		
		
		
		
	}
}
