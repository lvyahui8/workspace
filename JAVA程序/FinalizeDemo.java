class Demo extends Object{
    public void finalize(){
		System.out.println("Demo  Ok!");
	}
}

class FinalizeDemo 
{
	public static void main(String[] args) 
	{
		new Demo();
		new Demo();
		new Demo();
		System.gc();	//	����ϵͳ��������������
		System.out.println("Hello World!");		//	�����ȴ�ӡ��������Ϊ������������������������ͬ���߳�
	}
}


/*
//	����ִ�еõ��˲�ͬ�Ľ��

E:\����\JAVA����>java FinalizeDemo
Demo  Ok!
Demo  Ok!
Hello World!

E:\����\JAVA����>java FinalizeDemo
Hello World!
Demo  Ok!
Demo  Ok!
*/