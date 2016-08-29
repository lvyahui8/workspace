package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.impl.SystemDictionaryServiceImpl;
import com.meybosoft.microerp.system.SystemDictionary;
import com.meybosoft.microerp.system.SystemDictionaryDetail;

import junit.framework.TestCase;

public class SystemDictionaryServiceTest extends TestCase {
	private SystemDictionaryService service;

	@Override
	protected void setUp() throws Exception {
		service = new SystemDictionaryServiceImpl();
		super.setUp();
	}
	//测试是否可以添加一个新的字典信息
	public void testAddDictionary(){
		SystemDictionary sy = new SystemDictionary();
		sy.setSn(null);
		try{
			boolean bol = service.addDictionary(sy);
			if(bol)	 fail("字典编号不能为空");
		}
		catch(LogicException e){
			
		}
		sy.setId(new Long(1));
		sy.setSn(new String("字典编号"));
		sy.setTitle(new String("性别"));
		sy.setIntro(new String("Intro"));
		assertTrue("添加字典信息失败", service.addDictionary(sy));
		
		SystemDictionary sy2 = new SystemDictionary();
		sy2.setSn(new String("字典编号"));
		try{
			service.addDictionary(sy2);
			fail("不能添加编号相同的字典信息");
		}
		catch(LogicException e){
			
		}
		
	}
	//测试是否可以修改一个字典信息
	public void testUpdateDictionary(){
		SystemDictionary sy = service.getDictionary(1l);
		assertNotNull("字典信息为空", sy);
		sy.setSn("字典新编号");
		assertTrue("修改字典信息失败", service.updateDictionary(sy));
	}

	//测试是否可以通过id得到一个字典
	public void testGetDictionary_Id(){
		SystemDictionary sy = service.getDictionary(1l);
		assertNotNull("字典信息为空", sy);
		//查询一个不存在的ID字典信息
		SystemDictionary sy2 = service.getDictionary(123l);
		assertNull(sy2);
	}
	//测试是否可以通过字典编号得到一个字典
	public void testGetDictionary_Sn(){
		SystemDictionary sy = service.getDictionaryBySn(new String("字典新编号"));
		assertNotNull("字典信息为空", sy);
		
		SystemDictionary sy2 = service.getDictionaryBySn(new String("不存在的字典编号"));
		assertNull(sy2);
	}
	//测试是否可以新增一个字典值
	public void testAddDictionaryDetail(){
		SystemDictionaryDetail sydet = new SystemDictionaryDetail();
		SystemDictionary parent = service.getDictionary(1l);
		sydet.setId(new Long(1));
		sydet.setParent(parent);
		sydet.setTitle("男");
		sydet.setTvalue("man");
		sydet.setSequence(new Integer(1));
		assertTrue("新增字典值失败", service.addDictionaryDetail(sydet));
		
	}
	//测试是否可以修改一个字典值
	public void testUpdateDictionaryDetail(){
		SystemDictionary sy = service.getDictionary(1l);
		assertNotNull("字典不存在", sy);
		IPageList pageList= service.getDetailByDictionary(sy);
		java.util.List list =pageList.getResult();
		assertTrue("集合为空", list.size()>0);
		assertTrue("不是同一类型", list.get(0).getClass() == SystemDictionaryDetail.class );
		//把集合中的对象读出来
		SystemDictionaryDetail syst = (SystemDictionaryDetail) list.get(0);
		syst.setTitle("女");
		syst.setTvalue("woman");
		assertTrue("修改字典值失败",service.updateDictionaryDetail(syst));
	}
	//测试是否可以通过字典查询详细字典值信息
	public void testGetDictionaryDetail(){
		SystemDictionary sy = service.getDictionary(1l);
		assertNotNull("字典不存在", sy);
		IPageList pageList=service.getDetailByDictionary(sy);
		java.util.List list = pageList.getResult();
		assertTrue("集合为空", list.size()>0);
		assertTrue("类型不对应", list.get(0).getClass() == SystemDictionaryDetail.class );
		for(int i=0; i<list.size(); i++){
			SystemDictionaryDetail syst = (SystemDictionaryDetail) list.get(i);
			System.out.println(syst.getTitle());
		}
	}
	//测试是否可以根据自定义查询条件查询字典值
	public void testQueryDictionary(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add(1);
		 IPageList pageList= service.queryDictionary("id = ?", paras , 0, 15);
		 java.util.List list=pageList.getResult();
		for(int i=0; i<list.size(); i++){
			SystemDictionaryDetail syst = (SystemDictionaryDetail) list.get(i);
			System.out.println(syst.getTitle());
		}
	}
	//测试是否可以删除一个字典值
	public void testDelDictionaryDetail(){
		SystemDictionary sy = service.getDictionary(1l);
		assertNotNull("字典不存在", sy);
		java.util.Iterator<SystemDictionaryDetail> it = sy.getChildren().iterator();
		while(it.hasNext())
		assertTrue("删除字典值失败", service.delDictionaryDetail(it.next()));
	}
	//测试是否可以删除一个字典
	public void testDelDictionary(){
		SystemDictionary sy = service.getDictionary(1l);
		assertNotNull("指定ID的字典信息不存在", sy);
		assertTrue("删除字典信息失败", service.delDictionary(sy));
	}
}
