package cn.itcast.String.Demo;

public class StringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		/*
		 * String����ص㣺
		 * �ַ�������һ������ʼ���Ͳ��ᱻ�ı䡣
		 */
		stringDeme2();
	}

	private static void stringDeme2() {
		// TODO �Զ����ɵķ������
		String s = "abc";				//	����Ƿ��ڳ�������
		String s1 = new String("abc");	//	
		System.out.println("s="+s);
		System.out.println("s1="+s1);
		System.out.println(s==s1);
		System.out.println(s.equals(s1));//	String���е�equals��д��Object��equals����
	}

	/**
	 * ��ʾ�ַ�������ĵ�һ����ʽ������ȷ�ַ��������ص��ص�
	 * ����û�оͽ����������о�ֱ��ʹ�á�
	 */
	private static void stringDemo1() {
		String s = "abc";	//	"abc"�洢���ַ����������С�
//		s = "jbk";		//	�ַ���"abc"��û�б䣬ָʾȻsָ��������һ���ַ���
		System.out.println("s="+s);
		String s1 = "abc";
		System.out.println(s==s1);
	}

}
