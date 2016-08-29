package day02;
class Tool{
	public static int getValue(){
		System.out.println("Tool");
		return 0;
	}
}
class A {
	int a = Tool.getValue();
	static {
		System.out.println("A d static");
	}
	
	{
		System.out.println("A d gouzaodaimak");
	}
	
	public A(int a){
		System.out.println("A");
	}
}

class B extends A{
	int b = Tool.getValue();
	static {
		System.out.println("B d static");
	}
	{
		System.out.println("B d gouzaodaimak");
	}
	public B(){
		super(0);
		System.out.println("B1");
	}
	public B(int a){
		super(a);
		System.out.println("B2");
	}
}

public class DebugTest {

	public static void main(String[] args) {
		A a = new B();
		System.out.println(a.a);
	}

}
