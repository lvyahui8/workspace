class Fu {
    Fu(){
		show();
	}

	void show(){
		System.out.println("Fu Init!");	
	}
}
class Zi extends Fu{
    int num = 9;
	//	构造代码块
	{
		System.out.println("构造代码块");
	}
	Zi(){
		System.out.println("Zi Init!");
		System.out.println("num=="+num);
	}
}
class ObjInit 
{
	public static void main(String[] args) 
	{
		new Zi();
	}
}
