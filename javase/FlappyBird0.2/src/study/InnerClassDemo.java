package study;
class Test{
	void fun2(){
		
	}
	void fun(){
		
	}
}
//什么时候定义内部类，当一个类只为某一个A类服务，并且必不可少，那么就应该定义为这个A类的内部类
class ExternalClass{
	private String ziduan;
	private void method(){
		
	}
	//最简单的内部类
	class InnerClass_1{
		
	}
	
	//匿名内部类
	
	public void method_1(){
		//匿名内部类，一般定义在函数里面，什么时候使用呢，我只需要一个这样的对象，并且只使用一次
//		new Test(){
//			private int in_ziduan;
//			public void fun(){
//				
//			}
//		};//这里其实也产生了一个对象
		
//		new Test(){
//			private int in_ziduan;
//			public void fun(){
//				System.out.println("内部类");
//			}
//		}.fun();//这里使用匿名内部类产生了一个匿名对象，并调用对象的方法
		
/*父类引用*/	
		Test test = new Test(){//new  子类对象
			private int in_ziduan;//将这一部分父类中没有的隐藏了
			public void fun(){
				System.out.println("内部类");
			}
		};//这里使用匿名内部类产生了一个匿名对象，并且赋值给父类引用
		
		test.fun();//用一个父类的引用指向一个子类对象，父类的引用只能调用父类种的方法和子类中覆盖父类的方法（并且以覆盖父类的方法为主）
	}
	
}


public class InnerClassDemo {

	public static void main(String[] args) {
		new ExternalClass().method_1();//匿名对象调用方法
	}

}
