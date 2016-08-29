package cn.itcast.String.Demo;

public class StringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*
		 * String类的特点：
		 * 字符串对象一旦被初始化就不会被改变。
		 */
		stringDeme2();
	}

	private static void stringDeme2() {
		// TODO 自动生成的方法存根
		String s = "abc";				//	这个是放在常量池中
		String s1 = new String("abc");	//	
		System.out.println("s="+s);
		System.out.println("s1="+s1);
		System.out.println(s==s1);
		System.out.println(s.equals(s1));//	String类中的equals重写了Object的equals方法
	}

	/**
	 * 演示字符串定义的第一种形式，并明确字符串常量池的特点
	 * 池中没有就建立，池中有就直接使用。
	 */
	private static void stringDemo1() {
		String s = "abc";	//	"abc"存储在字符串常量池中。
//		s = "jbk";		//	字符串"abc"并没有变，指示然s指向了另外一个字符串
		System.out.println("s="+s);
		String s1 = "abc";
		System.out.println(s==s1);
	}

}
