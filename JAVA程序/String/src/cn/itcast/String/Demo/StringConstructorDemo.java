package cn.itcast.String.Demo;

public class StringConstructorDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		stringConstructorDemo2();
	}

	private static void stringConstructorDemo2() {
		// TODO 自动生成的方法存根
		char [] arr = {'w','g','b','x','y'};
		String s = new String(arr,1,3);
		System.out.println(s);
	}

	private static void stringConstructorDemo() {
		// TODO 自动生成的方法存根
		String s = new String();//等效于String s = "";不等效于String s=null;
		byte []str = {97,98,99,100};
		String s1 = new String(str);
		System.out.println("s1 = "+s1);
	}
}
