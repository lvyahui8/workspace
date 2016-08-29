package cn.itcast.String.Demo;

public class StringObjectDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
/*		String s1 = "abc";
		String s2 = "abc";
		s1 == s2;	// true
*/	
		String s1 = new String("abc");
		String s2 = s1.intern();  //	等价于  String s2 = "abc";
		String s3 = s1.intern();//	这一回，池中已经有"abc"了，就直接拿现成的引用就行了;
		System.out.println(s1 == s2);
		System.out.println(s3 == s2);
		System.out.println(s2);
		
	}

}
