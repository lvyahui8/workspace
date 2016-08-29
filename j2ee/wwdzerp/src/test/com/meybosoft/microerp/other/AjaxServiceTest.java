package com.meybosoft.microerp.other;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.dom4j.io.SAXReader;

import com.easyjf.web.ajax.AjaxConfigManager;
import com.easyjf.web.ajax.AjaxServiceContainer;
import com.easyjf.web.ajax.AjaxUtil;
import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.CustomerService;
import com.meybosoft.microerp.business.SystemRegionService;
import com.meybosoft.microerp.business.impl.CustomerServiceImpl;
import com.meybosoft.microerp.system.SystemRegion;

import junit.framework.TestCase;

public class AjaxServiceTest extends TestCase {
public void testLoadSystemRegion()
{
	Date begin=new Date();
	try{
		AjaxConfigManager config=new AjaxConfigManager();
		SAXReader reader = new SAXReader();
		
		config.parseConfig(reader.read(new java.io.FileInputStream(new File("webapps/WEB-INF/easyjf-ajax.xml"))));		
		AjaxServiceContainer serviceContainer=new AjaxServiceContainer(config);
		AjaxUtil.setServiceContainer(serviceContainer);	
		SystemRegionService regionService=new com.meybosoft.microerp.business.impl.SystemRegionServiceImpl();
		IPageList pageList=regionService.querySystemRegion("lev=1", null, 0, 15);
		List list= pageList.getResult();
		System.out.println(serviceContainer.isAllowProperty(SystemRegion.class, "children"));
		
		System.out.println(AjaxUtil.getJSON(list));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fail("³ö´íÁË£¡"+e);
		}
		System.out.println(System.currentTimeMillis()-begin.getTime());	
}
public void testCacheLoad()
{
	SystemRegionService regionService=new com.meybosoft.microerp.business.impl.SystemRegionServiceImpl();
	IPageList pageList= regionService.querySystemRegion("lev=1", null, 0, 15);
	List list=pageList.getResult();
	for(int i=0;i<list.size();i++)	
	System.out.println(list);
	
	for(int i=0;i<list.size();i++)	
		System.out.println(list);
}
public void testQueryCustomerJSon()
{
	CustomerService service=new CustomerServiceImpl();	
	IPageList pageList=service.queryCustomer("1=1", null, 0, 15);
	System.out.println(AjaxUtil.getJSON(pageList));
}
public void testUncode()
{
	int i='%';
	System.out.println(i);
}
}
