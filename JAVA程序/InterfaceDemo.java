
/*
��һ�������������з������ǳ����ʱ����ʱ���Խ�
�ó�����������һ����ʽ����ͱ�ʾ������ǽӿ�
*/
/*
�ӿ��г�����Ա
��Щ��Ա�й̶������η�,���ûдjava���Զ����ϡ�
1.ȫ�ֳ���		public static final
2.�ӿڷ���		public abstract
*/
interface Demo {
    public abstract void show1();
	abstract void show2();
	public static final double PI = 3.14;
	/*�ӿ��в����к���ʵ��
	void show3(){
	}
	*/
}

// ������֮���Ǽ̳й�ϵ������ӿ�֮����ʵ�ֹ�ϵ
class DemoImpl implements Demo {
	//	�ӿڸ��Ǳ�������ʾ����public
    public void show1(){
		System.out.println("Show1ʵ����:"+PI);
	}
	public void show2(){
		System.out.println("Show2ʵ����:"+PI);
	}

	double x;
}
/*
��JAVA�в�ֱ��֧�ֶ�̳У�java���иĽ���
����˶�ʵ�֣�һ�������ʵ�ֶ���ӿڣ�

*/

/*
����ϸ��
������ֵ֮���Ǽ̳й�ϵ�����ܶ�̳�
����ӿ�֮����ʵ�ֹ�ϵ�����Զ�ʵ��
�ӿ���ӿ�֮���Ǽ̳й�ϵ�����Զ�̳�
*/
public class InterfaceDemo 
{
	public static void main(String[] args) 
	{
		DemoImpl di	=	new DemoImpl();
		di.show1();
		di.show2();
		System.out.println(di.x=5);
	}
}
