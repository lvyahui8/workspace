//	��̬�����   ��������  ���캯��
//	3�ߵ��õ�˳��
//	��̬�����  ����ж���  �ȵ��ù������� ���ٵ��ù��캯��
class StaticCode {
	// ������ļ��ر�ִ�У�ֻ�ᱻ����һ��(��Ϊ���������ںܳ���һ��ֻ������һ��)
	// ��������һ���Ǹ�����г�ʼ�������е����ǲ���Ҫ����ģ�
	static {		//һ���ڵ�һ�β�������ʱ������
		System.out.println("��̬����鱻������");
	}

	void show(){
		System.out.println("Show������������");
	}
    
}

class Person {
	private String name;

	{//�������飬����ͬ�Ĺ��캯���еĹ��Դ����ȡ����
		System.out.println("�������鱻������");
		cry();
	}

	Person(){
		name = "Baby";
		System.out.println("�޲ι��캯��");
		//cry();
	}

	Person(String name){
		this.name = name;
		//cry();
		System.out.println("���ι��캯��");
	}

	public void cry(){
		System.out.println("cry����������");
	}
    
}
class StaticCodeDemo 
{
	public static void main(String[] args) 
	{
		new StaticCode().show();
		new StaticCode().show();
		
		System.out.println("\n");
		Person pBay1 = new Person();
		Person pBay2 = new Person("DJ");
	}
}
