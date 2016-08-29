
/*
多线程是有安全问题的：
产生问题的原因

1、多个线程操作了共享数据
2、操作共享数据的线程代码有多条

请仔细看本文件末尾这个程序的运行结果，出现了异常

解决方法：
就是讲多条操作共享数据的代码封装起来。
当有其他线程是不可以参与运算，必须在当前线程把这封装的代码块执行完毕后，其他线程才可以参与进来
JAVA中就是使用同步代码块：
synchronized(对象)
{
}

同步的好处：	解决了线程的安全问题
同步的弊端：	相对降低了效率，因为同步外的线程都必须判断同步锁，很多时候是无谓的判断
同步的前提：	同步中把必须有多个线程使用同一把锁

*/

class Ticket implements Runnable{//extends Thread{
    private static int num = 100;
	Object	obj	=	new	Object();
	public void run(){
		//Object	obj	=	new	Object();	//	这样是不行的。每个线程必须使用同一个锁
		for (;true; ) {
//			try {
//			    Thread.sleep(1000);
//			}
//			catch (Exception ex) {
//		
//			}
			synchronized(obj){		//	obj 相当于一个锁，当有一个线程进去以后，锁就锁上了，其他的线程就进不来。知道那个线程出去，锁才打开，其它的线程才可以进来。
				if (num>0) {
					System.out.println(obj+Thread.currentThread().getName()+".......sale"+num--);
				}
				else{
					break;
				}
			}
		}
	}
}

class TicketDemo 
{
	public static void main(String[] args) 
	{

//		Ticket	t1	=	new	Ticket();
//		Ticket	t2	=	new	Ticket();
//		Ticket	t3	=	new	Ticket();
//		Ticket	t4	=	new	Ticket();
		Ticket	t	=	new	Ticket();		//	这里用的是同一个锁
		Thread	t1	=	new	Thread(t);
		Thread	t2	=	new	Thread(t);
		Thread	t3	=	new	Thread(t);
		Thread	t4	=	new	Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}


/*
--------------------运行结果-----------------------------
E:\程序\JAVA程序>java TicketDemo
Thread-0.......sale100
Thread-1.......sale99
Thread-3.......sale98
Thread-2.......sale97
Thread-0.......sale96
Thread-2.......sale93
Thread-3.......sale94
Thread-1.......sale95
Thread-0.......sale92
Thread-2.......sale91
Thread-3.......sale90
Thread-1.......sale89
Thread-0.......sale88
Thread-2.......sale87
Thread-3.......sale86
Thread-1.......sale85
Thread-0.......sale84
Thread-2.......sale83
Thread-3.......sale82
Thread-1.......sale81
Thread-0.......sale80
Thread-2.......sale79
Thread-3.......sale78
Thread-1.......sale77
Thread-0.......sale76
Thread-2.......sale75
Thread-3.......sale74
Thread-1.......sale73
Thread-0.......sale72
Thread-2.......sale71
Thread-3.......sale70
Thread-1.......sale69
Thread-0.......sale68
Thread-2.......sale67
Thread-3.......sale66
Thread-1.......sale65
Thread-0.......sale64
Thread-2.......sale63
Thread-3.......sale62
Thread-1.......sale61
Thread-0.......sale60
Thread-2.......sale59
Thread-3.......sale58
Thread-1.......sale57
Thread-0.......sale56
Thread-2.......sale55
Thread-3.......sale54
Thread-1.......sale53
Thread-0.......sale52
Thread-2.......sale51
Thread-3.......sale50
Thread-1.......sale49
Thread-0.......sale48
Thread-2.......sale47
Thread-3.......sale46
Thread-1.......sale45
Thread-0.......sale44
Thread-2.......sale43
Thread-3.......sale42
Thread-1.......sale41
Thread-0.......sale40
Thread-2.......sale39
Thread-3.......sale38
Thread-1.......sale37
Thread-0.......sale36
Thread-2.......sale35
Thread-3.......sale34
Thread-1.......sale33
Thread-0.......sale32
Thread-2.......sale31
Thread-3.......sale30
Thread-1.......sale29
Thread-0.......sale28
Thread-2.......sale27
Thread-3.......sale26
Thread-1.......sale25
Thread-0.......sale24
Thread-2.......sale23
Thread-3.......sale22
Thread-1.......sale21
Thread-0.......sale20
Thread-2.......sale19
Thread-3.......sale18
Thread-1.......sale17
Thread-0.......sale16
Thread-2.......sale15
Thread-3.......sale14
Thread-1.......sale13
Thread-0.......sale12
Thread-2.......sale11
Thread-3.......sale10
Thread-1.......sale9
Thread-0.......sale8
Thread-2.......sale7
Thread-3.......sale6
Thread-1.......sale5
Thread-0.......sale4
Thread-2.......sale3
Thread-3.......sale2
Thread-1.......sale1
Thread-0.......sale0
Thread-2.......sale-1
Thread-3.......sale-2
*/