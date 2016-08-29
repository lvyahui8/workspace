package principle;
//里氏替换原则
/*
 * 通俗讲：
 * 子类可以扩张父类的功能，但不能改变父类原有的功能，它包含以下4层含义
 * 
 * 1、子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法
 * 2、子类可以增加自己特有的方法
 * 3、当子类的方法重载父类的方法时，方法的前置条件（即方法的形参）要比父类方法的输入参数更为宽松
 * 4、当子类的方法实现父类的抽象方法时，方法的后置条件（即返回值）要比父类更严格
 * 
 */
class A{
	public int func1(int a,int b){
		return a-b;
	}
}
public class RichterReplaced {

	public static void main(String[] args) {
//		A a = new A();
//		System.out.println("100-50="+a.func1(100, 50));
//		System.out.println("100-80="+a.func1(100, 80));
		
		B b = new B();
		
		System.out.println("100-50="+b.func1(100, 50));
		System.out.println("100-80="+b.func1(100, 80));
		System.out.println("100+20+100="+b.func2(100, 20));
		
	}

}


//后来我盟需要新增一个工功能，完成两个数相加，然后再与100求和，由类B来负责。即类B需要完成两个功能：


class B extends A{
	public int func1(int a,int b){
		return a+b;
	}
	public int func2(int a,int b){
		return func1(a,b)+100;
	}
}