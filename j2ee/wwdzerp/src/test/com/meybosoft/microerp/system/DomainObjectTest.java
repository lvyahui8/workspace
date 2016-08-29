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
		assertTrue("两个对象不相等!",p.equals(p2));
		assertTrue("hashCode不相等",p.hashCode()==p2.hashCode());
		assertTrue("两个对象相等!",!p.equals(p3));
		assertTrue("hasHcode相等!",p.hashCode()!=p3.hashCode());
	}
	
}
