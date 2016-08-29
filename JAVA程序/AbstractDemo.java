
//	abstract 不能与下面的关键字搭配
//	private	因为需要子类实例化，子类就必须有访问权限
//	static	因为静态不需要对象，这样就可以不覆盖就直接使用类名访问，那是无意义的事。
//	final	因为final修饰的方法不能重写
//	有抽象方法的类必须定义为抽象类
abstract class  Demo{
    abstract void show();
}


class Demo1 extends Demo {
    void show(){
		System.out.println("Demo1 Show");
	}
}

class Demo2 extends Demo {
    void show(){
		System.out.println("Demo2 Show");
	}
}

public class AbstractDemo 
{
	public static void main(String[] args) 
	{
		//Demo demo	=	new Demo();
		Demo1 demo1	=	new Demo1();
		Demo2 demo2	=	new Demo2();
		demo1.show();
		demo2.show();
	}
}
