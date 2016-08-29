
/*
当一个抽象类中所有方法都是抽象的时候，这时可以将
该抽象类用另外一种形式定义和表示，这既是接口
*/
/*
接口中常见成员
这些成员有固定的修饰符,如果没写java会自动加上。
1.全局常量		public static final
2.接口方法		public abstract
*/
interface Demo {
    public abstract void show1();
	abstract void show2();
	public static final double PI = 3.14;
	/*接口中不能有函数实体
	void show3(){
	}
	*/
}

// 类与类之间是继承关系，类与接口之间是实现关系
class DemoImpl implements Demo {
	//	接口覆盖必须是显示定义public
    public void show1(){
		System.out.println("Show1实现了:"+PI);
	}
	public void show2(){
		System.out.println("Show2实现了:"+PI);
	}

	double x;
}
/*
在JAVA中不直接支持多继承，java进行改进，
变成了多实现（一个类可以实现多个接口）

*/

/*
、、细节
类与类值之间是继承关系，不能多继承
类与接口之间是实现关系，可以多实现
接口与接口之间是继承关系，可以多继承
*/
public class InterfaceDemo 
{
	public static void main(String[] args) 
	{
		DemoImpl di	=	new DemoImpl();
		di.show1();
		di.show2();
		System.out.println(di.x=5);
	}
}
