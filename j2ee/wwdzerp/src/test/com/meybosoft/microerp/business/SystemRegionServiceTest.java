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
	//�����Ƿ������ӵ�����Ϣ
	public void testAddSystemRegion(){
		SystemRegion reg = new SystemRegion();
		reg.setId(400l);
		reg.setTitle("��  ��");
		reg.setSequence(0);
		reg.setParent(reg);
		reg.setLev(1);
		reg.setInputTime(new java.util.Date());
		reg.setInputUser("ëΰ");
		reg.setSn("1");
		assertTrue("��ӵ���ʧ��", service.addSystemRegion(reg));
	}
	//�����Ƿ���Ը��µ�����Ϣ
	public void testUpdateSystemRegion(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add(400);
		IPageList pageList=service.querySystemRegion("id=?", paras, 0, 1);
		java.util.List list = pageList.getResult();
		assertNotNull("������ϢΪ��", list.size()>0);
		assertTrue("���Ͳ�ƥ��", list.get(0).getClass() == SystemRegion.class);
		SystemRegion reg = (SystemRegion) list.get(0);
		reg.setSn("0000001");
		assertTrue("���µ���ʧ��", service.updateSystemRegion(reg));
	}
	//�����Ƿ���Բ�ѯ������Ϣ
	public void testQuerySystemRegion(){
		java.util.Collection paras = new java.util.ArrayList();
		paras.add(400);
		IPageList pageList=service.querySystemRegion("lev=1", paras, 0, 15);
		 java.util.List list =pageList.getResult();
		assertNotNull("������ϢΪ��", list.size()>0);
		assertTrue("���Ͳ�ƥ��", list.get(0).getClass() == SystemRegion.class);
		for(int i=0; i<list.size(); i++){
			SystemRegion reg = (SystemRegion) list.get(i);
			System.out.println(reg.getTitle());
		}
	}
	//�����Ƿ�����ƶ�������Ϣ
	public void testMoveTo(){
		
	}
	//�����Ƿ����ɾ��������Ϣ
	public void delSystemRegion(){
		
	}
}
