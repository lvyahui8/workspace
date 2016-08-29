class Outer {
    private int num;
	static private int s_num;
	static {
		s_num = 10;
	}
	static class Inner {
	    void show(){
			//System.out.println("num..="+num);
			System.out.println("s_num..="+s_num);
		}
		static void fun(){	//如果内部类中有静态成员，内部类也必须声明为静态
			System.out.println("静态类的静态函数被调用");
		}
	}
	public void method(){
		Inner in = new Inner();
		in.show();
	}
}

class InClassDemo 
{
	public static void main(String[] args) 
	{
		//当权限够大时,直接访问内部类
		//Outer.Inner in = new Outer().new Inner();
		//in.show();
		//当内部类是个静态的时候,相当于一个外部类
		Outer.Inner in = new Outer.Inner();
		in.show();
		Outer.Inner.fun();
		in.fun();
	}
}
