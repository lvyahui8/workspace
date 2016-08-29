class Outer {
    private int num;
	static private int s_num;
	static {
		s_num = 10;
	}
	static class Inner {
	    void show(){
			//System.out.println("num..="+num);
			System.out.println("s_num..="+s_num);
		}
		static void fun(){	//����ڲ������о�̬��Ա���ڲ���Ҳ��������Ϊ��̬
			System.out.println("��̬��ľ�̬����������");
		}
	}
	public void method(){
		Inner in = new Inner();
		in.show();
	}
}

class InClassDemo 
{
	public static void main(String[] args) 
	{
		//��Ȩ�޹���ʱ,ֱ�ӷ����ڲ���
		//Outer.Inner in = new Outer().new Inner();
		//in.show();
		//���ڲ����Ǹ���̬��ʱ��,�൱��һ���ⲿ��
		Outer.Inner in = new Outer.Inner();
		in.show();
		Outer.Inner.fun();
		in.fun();
	}
}
