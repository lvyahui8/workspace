
class Car{
	private int num = 0;//显示初始化
	private String color;
	///*
	public Car(){
		num = -1;
		color = "uuuu";
	}//*/
	public Car(int n,String c){
		num = n;
		color = c;
	}
	public Car(int num){
		this();		// 调用无参的构造函数
		
		//num = num;  // 这样是不行的
		this.num = num;	//需要使用this关键字进行区分
		//this(num);			// 递归构造器，会陷入死循环
	}
	public void Run(){
		System.out.println(num+"..."+color);
	}
}

public class  CarDemo{
	public static void main(String[] args){
		Car car = new Car(4,"Red");
		car.Run();
		Car c1 = new Car(5,"Write");
		Car c2 = c1;
		// 只 new 了一次，所以c1,c2占用的是同一块内存区
		System.out.println(c1);
		System.out.println(c2);
		c1.Run();
		c2.Run();
		Car myCar = null;
		System.out.println(myCar);
		new Car(3,"temp").Run();//匿名对象，当只需要使用一次对象的某个方法。可以使用简写成这样
		Car myCar2 = new Car(3);
		myCar2.Run();
	}
}
