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
	//�����Ƿ�������һ���µ��ֵ���Ϣ
	public void testAddDictionary(){
		SystemDictionary sy = new SystemDictionary();
		sy.setSn(null);
		try{
			boolean bol = service.addDictionary(sy);
			if(bol)	 fail("�ֵ��Ų���Ϊ��");
		}
		catch(LogicException e){
			
		}
		sy.setId(new Long(1));
		sy.setSn(new String("�ֵ���"));
		sy.setTitle(new String("�Ա�"));
		sy.setIntro(new String("Intro"));
		assertTrue("����ֵ���Ϣʧ��", service.addDictionary(sy));
		
		SystemDictionary sy2 = new SystemDictionary();
		sy2.setSn(new String("�ֵ���"));
		try{
			service.addDictionary(sy2);
			fail("������ӱ����ͬ���ֵ���Ϣ");
		}
		catch(LogicException e){
			
		}
		
	}
	//�����Ƿ�����޸�һ���ֵ���Ϣ
	public void testUpdateDictionary(){
		SystemDictionary sy = service.getDictionary(1l);
		assertNotNull("�ֵ���ϢΪ��", sy);
		sy.setSn("�ֵ��±��");
		assertTrue("�޸��ֵ���Ϣʧ��", service.updateDictionary(sy));
	}

	//�����Ƿ����ͨ��id�õ�һ���ֵ�
	public void testGetDictionary_Id(){
		SystemDictionary sy = service.getDictionary(1l);
		assertNotNull("�ֵ���ϢΪ��", sy);
		//��ѯһ�������ڵ�ID�ֵ���Ϣ
		SystemDictionary sy2 = service.getDictionary(123l);
		assertNull(sy2);
	}
	//�����Ƿ����ͨ���ֵ��ŵõ�һ���ֵ�
	public void testGetDictionary_Sn(){
		SystemDictionary sy = service.getDictionaryBySn(new String("�ֵ��±��"));
		assertNotNull("�ֵ���ϢΪ��", sy);
		
		SystemDictionary sy2 = service.getDictionaryBySn(new String("�����ڵ��ֵ���"));
		assertNull(sy2);
	}
	//�����Ƿ��������һ���ֵ�ֵ
	public void testAddDictionaryDetail(){
		SystemDictionaryDetail sydet = new SystemDictionaryDetail();
		SystemDictionary parent = service.getDictionary(1l);
		sydet.setId(new Long(1));
		sydet.setParent(parent);
		sydet.setTitle("��");
		sydet.setTvalue("man");
		sydet.setSequence(new Integer(1));
		assertTrue("�����ֵ�ֵʧ��", service.addDictionaryDetail(sydet));
		
	}
	//�����Ƿ�����޸�һ���ֵ�ֵ
	public void testUpdateDictionaryDetail(){
		SystemDictionary sy = service.getDictionary(1l);
		assertNotNull("�ֵ䲻����", sy);
		IPageList pageList= service.getDetailByDictionary(sy);
		java.util.List list =pageList.getResult();
		assertTrue("����Ϊ��", list.size()>0);
		assertTrue("����ͬһ����", list.get(0).getClass() == SystemDictionaryDetail.class );
		//�Ѽ����еĶ��������
		SystemDictionaryDetail syst = (SystemDictionaryDetail) list.get(0);
		syst.setTitle("Ů");
		syst.setTvalue("woman");
		assertTrue("�޸��ֵ�ֵʧ��",service.updateDictionaryDetail(syst));
	}
	//�����Ƿ����ͨ���ֵ��ѯ��ϸ�ֵ�ֵ��Ϣ
	public void testGetDictionaryDetail(){
		SystemDictionary sy = service.getDictionary(1l);
		assertNotNull("�ֵ䲻����", sy);
		IPageList pageList=service.getDetailByDictionary(sy);
		java.util.List list = pageList.getResult();
		assertTrue("����Ϊ��", list.size()>0);
		assertTrue("���Ͳ���Ӧ", list.get(0).getClass() == SystemDictionaryDetail.class );
		for(int i=0; i<list.size(); i++){
			SystemDictionaryDetail syst = (SystemDictionaryDetail) list.get(i);
			System.out.println(syst.getTitle());
		}
	}
	//�����Ƿ���Ը����Զ����ѯ������ѯ�ֵ�ֵ
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
	//�����Ƿ����ɾ��һ���ֵ�ֵ
	public void testDelDictionaryDetail(){
		SystemDictionary sy = service.getDictionary(1l);
		assertNotNull("�ֵ䲻����", sy);
		java.util.Iterator<SystemDictionaryDetail> it = sy.getChildren().iterator();
		while(it.hasNext())
		assertTrue("ɾ���ֵ�ֵʧ��", service.delDictionaryDetail(it.next()));
	}
	//�����Ƿ����ɾ��һ���ֵ�
	public void testDelDictionary(){
		SystemDictionary sy = service.getDictionary(1l);
		assertNotNull("ָ��ID���ֵ���Ϣ������", sy);
		assertTrue("ɾ���ֵ���Ϣʧ��", service.delDictionary(sy));
	}
}
