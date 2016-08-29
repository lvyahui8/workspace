package com.sldll.cms.dao.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.sldll.cms.dao.GeneralDAO;
import com.sldll.cms.vo.Dishes;
import com.sldll.cms.vo.OrderForm;
import com.sldll.cms.vo.Vip;

public class GeneralDAOTest extends TestCase {
	private GeneralDAO gdao;

	Vip vip = new Vip();
	Dishes  dishes = new Dishes();
	OrderForm of = new OrderForm();
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gdao = new GeneralDAO();
	}

	public void testFindAll(){
		try {
//			List<Object> list = gdao.findAll(vip);
//			List<Object> list = gdao.findAll(dishes);
			List<Object> list = gdao.findAll(of);
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
//			reg.put("id", 1);
			
//			reg.put("id>=", 1);
//			reg.put("id<=", 2);
			
			reg.put("name", "��");
//			reg.put("createDate", "2012");
			List<Object> list = gdao.findByNameQuery(vip, reg,true);
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
			
			String sql = "select * from dishes";
			List<Object> list = gdao.findByNameQuery(dishes, sql);
			for (Object obj : list) {

				System.out.println(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testCreate(){
		vip.setId("008");
		vip.setName("ɽҩ");
		vip.setPhone("1368886598");
		vip.setScore(50);
		vip.setSex("Ů");
		vip.setState(0);
		vip.setCreateDate(new Timestamp(Date.valueOf("2011-3-10").getTime()));
		try {
			gdao.create(vip);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testDelete(){
		Map<Object, Object> condition = new HashMap<Object,Object>();
		condition.put("id", 4);
		try {
			gdao.delete(vip, condition);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testUpdate(){
		Map<Object, Object> map = new HashMap<Object,Object>();
		map.put("sex", "Ů");
		map.put("createDate", new Timestamp(Date.valueOf("2012-1-7").getTime()));
		Map<Object, Object> condition = new HashMap<Object,Object>();
		condition.put("id", "004");
		try {
			gdao.update(vip, map, condition);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
