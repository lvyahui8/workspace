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
		System.out.println(a.func());	//	����ʧ�ܣ�Aû���������
	}
}
