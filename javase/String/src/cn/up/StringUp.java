/**
 * 
 */
package cn.up;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Agrin
 * 2014Äê3ÔÂ16ÈÕ
 */
public class StringUp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = "1" + "";
		String b = "1" + "";
		
		System.out.println(a == b);
		
		String c = getString("1","");
		String d = getString("1","");
		
		System.out.println(c == d);
		
		
		List l = new ArrayList();
		l.contains("a");
	}

	/**
	 * @param string
	 * @param string2
	 * @return
	 */
	private static String getString(String str1, String str2) {
		return str1+str2;
	}

}
