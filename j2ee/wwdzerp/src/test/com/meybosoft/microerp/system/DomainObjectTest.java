package com.meybosoft.microerp.system;

public class DomainObjectTest extends junit.framework.TestCase {
	public void testPopdeom()
	{
		Popedom p=new Popedom();	
		p.setId(999999999);
		p.setTitle("p1");
		Popedom p2=new Popedom();
		p2.setId(124);
		Popedom p3=new Popedom();
		p3.setId(99999999);
		p2.setTitle("p2");
		assertTrue("�����������!",p.equals(p2));
		assertTrue("hashCode�����",p.hashCode()==p2.hashCode());
		assertTrue("�����������!",!p.equals(p3));
		assertTrue("hasHcode���!",p.hashCode()!=p3.hashCode());
	}
	
}
