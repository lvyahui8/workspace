abstract class Demo{
	abstract void show();
}

interface Inter {
    void show1();
	void show2();
}

class Outer {
    public void method(){
//---------匿名内部类-------------
		new Demo(){		
			void show(){
				System.out.println("你好啊");
			}
		}.show();
		Inter in = new Inter(){
			public void show1(){
				System.out.println("Outer.method.inter.show1();");
			}
			public void show2(){
				System.out.println("Outer.method.inter.show2();");
			}
		};
		in.show1();
		in.show2();
	}
}

/*
使用场景之一：
当函数参数是接口类型时，而且接口中的方法不超过3个
可以使用匿名内部类作为实际参数作为传递
*/
class NmInClass 
{
	public static void main(String[] args) 
	{
		new Outer().method();
		show(
			new Inter()
			{
				public void show1(){
					System.out.println("Show1");
				}
				public void show2(){
					System.out.println("Show2");
				}
			}
			);
	}

	public static void show(Inter in){
		in.show1();
		in.show2();
	}

}


