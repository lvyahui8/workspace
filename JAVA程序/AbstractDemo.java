
//	abstract ����������Ĺؼ��ִ���
//	private	��Ϊ��Ҫ����ʵ����������ͱ����з���Ȩ��
//	static	��Ϊ��̬����Ҫ���������Ϳ��Բ����Ǿ�ֱ��ʹ���������ʣ�������������¡�
//	final	��Ϊfinal���εķ���������д
//	�г��󷽷�������붨��Ϊ������
abstract class  Demo{
    abstract void show();
}


class Demo1 extends Demo {
    void show(){
		System.out.println("Demo1 Show");
	}
}

class Demo2 extends Demo {
    void show(){
		System.out.println("Demo2 Show");
	}
}

public class AbstractDemo 
{
	public static void main(String[] args) 
	{
		//Demo demo	=	new Demo();
		Demo1 demo1	=	new Demo1();
		Demo2 demo2	=	new Demo2();
		demo1.show();
		demo2.show();
	}
}
