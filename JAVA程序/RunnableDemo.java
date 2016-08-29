//	实现线程的另外一种方法是实现Runnable接口。主要是因为java不支持多继承，但支持单继承和多实现。
/*
1、定义类实现Runnable接口中
2、实现接口中的run方法。
3、将Runnable接口的子类对象作为Thread类的构造函数的参数（在创建线程对象之前必须明确要运行的任务）。
4、调用线程对象的start方法开启线程
*/
class Demo implements Runnable{
    private String name;
	Demo(String name){
		this.name = name;
	}
	public void show(){
		
		for (int i=1;i<=10 ;i++ ) {
		    //System.out.println("  ."+name+".  "+getName());	//	当前线程对象的名字
			System.out.println("  ."+name+".  "+Thread.currentThread().getName());		//	当前运行线程的名字
		}
	}
	//	实现接口的run方法。
	public void run(){
		show();
	}
}

class RunnableDemo 
{
	public static void main(String[] args) 
	{
		Demo	d1	=	new	Demo("1");
		Demo	d2	=	new	Demo("2");
		Thread	t1	=	new	Thread(d1,"线程1");
		Thread	t2	=	new	Thread(d2,"线程2");
		t1.start();
		t2.start();

	}
}
