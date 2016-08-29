package principle;
/*
 * 接口隔离原则
 * 
 * 问题由来：类A通过接口I依赖类B，类C通过接口I依赖类D
 * （类A中持有I的引用，B实现了I接口；类C中持有I的引用，D实现了I接口），如果接口I对于类A和类C来说不是
 * 最小接口，则类B和类D必须实现他们不需要的方法
 * 
 * 解决方法，将臃肿的接口I拆分为独立的几个接口，类A和类C分别与需要的接口建立依赖关系
 * ，也就是采用哦接口隔离原则
 * 
 * 客户端不应该依赖他不需要的接口，一个类对另一个类的依赖应该建立在最小的接口上
 * 
 * 接口隔离原则的含义：建立单一接口，不要建立判断庞大臃肿的接口，尽量细化接口，接口中的方法尽量少
 */

interface I {
	public void method_1();
	public void method_2();
	public void method_3();
	public void method_4();
	public void method_5();
}

class A2 {
	public void depend_1(I i){
		i.method_1();
	}
	public void depend_2(I i){
		i.method_2();
	}
	public void depend_3(I i){
		i.method_3();
	}
}

class B2 implements I{
	public void method_1(){
		System.out.println("类B实现接口I的方法1");
	}
	public void method_2(){
		System.out.println("类B实现接口I的方法2");
	}
	public void method_3(){
		System.out.println("类B实现接口I的方法3");
	}
	//	对于类B来说，method_4和method_5不是必须的，但是由于接口I中有这两个方法，所以即便方法体为空，也需要写上
	public void method_4(){
	}
	public void method_5(){
	}
}

class C{
	public void depend_1(I i){
		i.method_1();
	}
	public void depend_2(I i){
		i.method_4();
	}
	public void depend_3(I i){
		i.method_5();
	}
}

class D implements I{

	@Override
	public void method_1() {
		System.out.println("类D实现接口I的方法1");
	}
	//对于类D来说，method_2 method_3不是必须的，但也要写上
	@Override
	public void method_2() {
	}

	@Override
	public void method_3() {
	}

	@Override
	public void method_4() {
		System.out.println("类D实现接口I的方法4");
	}
	@Override
	public void method_5() {
		System.out.println("类D实现接口I的方法5");
	}
	
}

public class InterfaceIsolation {
	public static void main(String []  args){
		A2 a = new A2();
		a.depend_1(new B2());
		a.depend_2(new B2());
		a.depend_3(new B2());
		
		C c = new C();
		c.depend_1(new D());
		c.depend_2(new D());
		c.depend_3(new D());
	}
}


//可以看出接口过于复杂，这显然不是最好的设计。下面将接口拆分
interface I1 {
	public void method_1();
}
interface I2 {
	public void method_2();
	public void method_3();
	
}
interface I3 {
	public void method_4();
	public void method_5();
}

//下面类只需要实现它所依赖的接口。代码不述

