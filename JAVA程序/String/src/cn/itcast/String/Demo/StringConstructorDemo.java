package cn.itcast.String.Demo;

public class StringConstructorDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		stringConstructorDemo2();
	}

	private static void stringConstructorDemo2() {
		// TODO �Զ����ɵķ������
		char [] arr = {'w','g','b','x','y'};
		String s = new String(arr,1,3);
		System.out.println(s);
	}

	private static void stringConstructorDemo() {
		// TODO �Զ����ɵķ������
		String s = new String();//��Ч��String s = "";����Ч��String s=null;
		byte []str = {97,98,99,100};
		String s1 = new String(str);
		System.out.println("s1 = "+s1);
	}
}
