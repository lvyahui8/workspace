/*
final���������α�������������
�� final ���ε�
����  -  ������
����  -   ���ܱ����ǣ�
��    -  ���ܱ��̳�
*/ 
class Base {
    private	int num;
	/*
	protected Base(int num){
		this.num = num;
	}*/
	protected Base(){
		System.out.println("���๹�캯��������");
		this.num = 10;
	}
	public void show(){
		System.out.println("num="+num);
	}
}

class Derived extends Base {
    private	int num;
	final double PI;	//	�����ڴ���ʾ��ʼ���������ڹ������飬���߹��캯���г�ʼ��һ�Ρ�������δ��ʼ�����������
	//	�������飬��һ��������������й��������Ʊ�����һ�Ρ�Ҳ����˵��ÿ����һ�������Ķ��󣬹������鶼�ᱻ�����ҽ�һ�Σ�
	{
		System.out.println("���๹�����鱻������");
		//PI = 3.14;
	}
	public Derived(int num,int pi){
		this(pi);			//	ȱʡ����ִ��super();��ִ��this();Ҳ����˵super�ǹ��캯���ĵ�һ�����
		System.out.println("������ι��캯��������");
		this.num = num;
	}
	public Derived(int pi){
		System.out.println("�����޲ι��캯��������");
		this.PI = pi;
	}
	public void show() {
		System.out.println("num="+num);
		super.show();
	}
}

public class ExtendDemo 
{
	public static void main(String[] args) 
	{
		Derived ded =  new Derived(5);
		ded.show();
	}
}
