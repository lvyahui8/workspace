
class Car{
	private int num = 0;//��ʾ��ʼ��
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
		this();		// �����޲εĹ��캯��
		
		//num = num;  // �����ǲ��е�
		this.num = num;	//��Ҫʹ��this�ؼ��ֽ�������
		//this(num);			// �ݹ鹹��������������ѭ��
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
		// ֻ new ��һ�Σ�����c1,c2ռ�õ���ͬһ���ڴ���
		System.out.println(c1);
		System.out.println(c2);
		c1.Run();
		c2.Run();
		Car myCar = null;
		System.out.println(myCar);
		new Car(3,"temp").Run();//�������󣬵�ֻ��Ҫʹ��һ�ζ����ĳ������������ʹ�ü�д������
		Car myCar2 = new Car(3);
		myCar2.Run();
	}
}
