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
	//	��������
	{
		System.out.println("��������");
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
