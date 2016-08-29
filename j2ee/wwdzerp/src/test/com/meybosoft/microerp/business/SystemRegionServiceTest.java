package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.impl.SystemRegionServiceImpl;
import com.meybosoft.microerp.system.SystemRegion;
import junit.framework.TestCase;

public class SystemRegionServiceTest extends TestCase {
	private SystemRegionService service;

	@Override
	protected void setUp() throws Exception {
		service = new SystemRegionServiceImpl();
		super.setUp();
	}
	//测试是否可以添加地区信息
	public void testAddSystemRegion(){
		SystemRegion reg = new SystemRegion();
		reg.setId(400l);
		reg.setTitle("开  县");
		reg.setSequence(0);
		reg.setParent(reg);
		reg.setLev(1);
		reg.setInputTime(new java.util.Date());
		reg.setInputUser("毛伟");
		reg.setSn("1");
		assertTrue("添加地区失败", service.addSystemRegion(reg));
	}
	//测试是否可以更新地区信息
	public void testUpdateSystemRegion(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add(400);
		IPageList pageList=service.querySystemRegion("id=?", paras, 0, 1);
		java.util.List list = pageList.getResult();
		assertNotNull("地区信息为空", list.size()>0);
		assertTrue("类型不匹配", list.get(0).getClass() == SystemRegion.class);
		SystemRegion reg = (SystemRegion) list.get(0);
		reg.setSn("0000001");
		assertTrue("更新地区失败", service.updateSystemRegion(reg));
	}
	//测试是否可以查询地区信息
	public void testQuerySystemRegion(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add(400);
		IPageList pageList=service.querySystemRegion("lev=1", paras, 0, 15);
		 java.util.List list =pageList.getResult();
		assertNotNull("地区信息为空", list.size()>0);
		assertTrue("类型不匹配", list.get(0).getClass() == SystemRegion.class);
		for(int i=0; i<list.size(); i++){
			SystemRegion reg = (SystemRegion) list.get(i);
			System.out.println(reg.getTitle());
		}
	}
	//测试是否可以移动地区信息
	public void testMoveTo(){
		
	}
	//测试是否可以删除地区信息
	public void delSystemRegion(){
		
	}
}
