package ref.dao.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import ref.dao.GeneralDAO;
import ref.dao.vo.Test;
import ref.dao.vo.User;

public class GeneralDAOTest extends TestCase {
	private GeneralDAO gdao;
	User user = new User();
	Test test = new Test();
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gdao = new GeneralDAO();
	}

	public void testFindAll(){
		try {
			List<Object> list = gdao.findAll(user);
			for (Object obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testFindByNameQuery1(){
		try {
			Map<Object, Object> reg = new HashMap<Object, Object>();
//			reg.put("id=", 1);
//			reg.put("id=", "1");
//			reg.put("birthday", new Timestamp(Date.valueOf("1994-1-1").getTime()));
//			reg.put("sex=", "ÄÐ");
//			reg.put("id>=", 2);
//			reg.put("id<=", 4);
//			List<Object> list = gdao.findByNameQuery(user, reg);
			reg.put("id", 1);
			List<Object> list = gdao.findByNameQuery(test, reg);
			for (Object obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void testFindByNameQuery2(){
		try {
			
			String sql = "select * from user";
			List<Object> list = gdao.findByNameQuery(user, sql );
			for (Object obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void testCreate(){
//		user.setName("º£ÌÄ");
//		user.setBirthday(new Timestamp(Date.valueOf("2013-1-1").getTime()));
//		user.setId(new Long(7));
//		user.setSex("Å®");
		
		test.setCreateDate(new Timestamp(Date.valueOf("2013-1-1").getTime()));
		test.setId(new Long(4));
		test.setMoney(new Long(300)	);
		test.setPhone("13813249872");
		test.setScore(new Long(30));
		
		try {
//			gdao.create(user);
			gdao.create(test);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
