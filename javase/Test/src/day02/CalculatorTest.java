package day02;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
	public void testAdd()throws Exception{
		assertEquals(12, Calculator.add(3, 5));
	}
}
