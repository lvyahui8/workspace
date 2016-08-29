interface A {
    
}

class B implements A {
    String func(){
		return "func";
	}
}

class  Quet1
{
	public static void main(String[] args) 
	{
		A a = new B();
		System.out.println(a.func());	//	编译失败，A没有这个方法
	}
}
