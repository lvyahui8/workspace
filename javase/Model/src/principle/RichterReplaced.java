package principle;
//�����滻ԭ��
/*
 * ͨ�׽���
 * ����������Ÿ���Ĺ��ܣ������ܸı丸��ԭ�еĹ��ܣ�����������4�㺬��
 * 
 * 1���������ʵ�ָ���ĳ��󷽷��������ܸ��Ǹ���ķǳ��󷽷�
 * 2��������������Լ����еķ���
 * 3��������ķ������ظ���ķ���ʱ��������ǰ�����������������βΣ�Ҫ�ȸ��෽�������������Ϊ����
 * 4��������ķ���ʵ�ָ���ĳ��󷽷�ʱ�������ĺ���������������ֵ��Ҫ�ȸ�����ϸ�
 * 
 */
class A{
	public int func1(int a,int b){
		return a-b;
	}
}
public class RichterReplaced {

	public static void main(String[] args) {
//		A a = new A();
//		System.out.println("100-50="+a.func1(100, 50));
//		System.out.println("100-80="+a.func1(100, 80));
		
		B b = new B();
		
		System.out.println("100-50="+b.func1(100, 50));
		System.out.println("100-80="+b.func1(100, 80));
		System.out.println("100+20+100="+b.func2(100, 20));
		
	}

}


//����������Ҫ����һ�������ܣ������������ӣ�Ȼ������100��ͣ�����B�����𡣼���B��Ҫ����������ܣ�


class B extends A{
	public int func1(int a,int b){
		return a+b;
	}
	public int func2(int a,int b){
		return func1(a,b)+100;
	}
}