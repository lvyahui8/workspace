package cn.itcast.String.Demo;

public class StringObjectDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
/*		String s1 = "abc";
		String s2 = "abc";
		s1 == s2;	// true
*/	
		String s1 = new String("abc");
		String s2 = s1.intern();  //	�ȼ���  String s2 = "abc";
		String s3 = s1.intern();//	��һ�أ������Ѿ���"abc"�ˣ���ֱ�����ֳɵ����þ�����;
		System.out.println(s1 == s2);
		System.out.println(s3 == s2);
		System.out.println(s2);
		
	}

}
