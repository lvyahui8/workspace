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
		System.gc();	//	告诉系统启动垃圾清理器
		System.out.println("Hello World!");		//	可能先打印出来，因为它和垃圾清理器属于两个不同的线程
	}
}


/*
//	两次执行得到了不同的结果

E:\程序\JAVA程序>java FinalizeDemo
Demo  Ok!
Demo  Ok!
Hello World!

E:\程序\JAVA程序>java FinalizeDemo
Hello World!
Demo  Ok!
Demo  Ok!
*/