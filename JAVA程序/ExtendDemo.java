/*
final。可以修饰变量，方法，类
被 final 修饰的
变量  -  常量，
方法  -   不能被覆盖，
类    -  不能被继承
*/ 
class Base {
    private	int num;
	/*
	protected Base(int num){
		this.num = num;
	}*/
	protected Base(){
		System.out.println("父类构造函数被调用");
		this.num = 10;
	}
	public void show(){
		System.out.println("num="+num);
	}
}

class Derived extends Base {
    private	int num;
	final double PI;	//	若不在此显示初始化，必须在构造代码块，或者构造函数中初始化一次。不允许未初始化的情况出现
	//	构造代码块，在一次完整构造过程中构造代码块制备调用一次。也就是说。每构造一个完整的对象，构造代码块都会被调用且仅一次；
	{
		System.out.println("子类构造代码块被调用了");
		//PI = 3.14;
	}
	public Derived(int num,int pi){
		this(pi);			//	缺省会先执行super();再执行this();也就是说super是构造函数的第一条语句
		System.out.println("子类带参构造函数被调用");
		this.num = num;
	}
	public Derived(int pi){
		System.out.println("子类无参构造函数被调用");
		this.PI = pi;
	}
	public void show() {
		System.out.println("num="+num);
		super.show();
	}
}

public class ExtendDemo 
{
	public static void main(String[] args) 
	{
		Derived ded =  new Derived(5);
		ded.show();
	}
}
