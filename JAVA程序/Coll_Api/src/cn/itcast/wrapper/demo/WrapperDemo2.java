package cn.itcast.wrapper.demo;

public class WrapperDemo2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int num = 4;
		num = num + 5;
		
		Integer i = 4;	// 1.5版本才出现的特性，这叫自动装箱  简化书写
		i = i + 5;	//	首先将i变成基本数据类型，在和  6 相加 ,//i.intValue()自动拆箱
		show(i);
		
		Integer a = 127;//	JDK1.5以后，自动装箱，如果装箱的是一个字节，那么该数据会被共享不会重新开辟空间
		Integer b = 127;
		Integer c = null;	//一般要做健壮性判断
		show(a == b);
		show(a.equals(b));
		Integer m = new Integer(12);
		Integer n = new Integer(12);
		show( m == n);
		show(m.equals(b));
		
	}
	public static void show(Object a) {
		// TODO 自动生成的方法存根
		System.out.println("a="+a);
	}
}
