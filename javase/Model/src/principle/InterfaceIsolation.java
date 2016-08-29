package principle;
/*
 * �ӿڸ���ԭ��
 * 
 * ������������Aͨ���ӿ�I������B����Cͨ���ӿ�I������D
 * ����A�г���I�����ã�Bʵ����I�ӿڣ���C�г���I�����ã�Dʵ����I�ӿڣ�������ӿ�I������A����C��˵����
 * ��С�ӿڣ�����B����D����ʵ�����ǲ���Ҫ�ķ���
 * 
 * �����������ӷ�׵Ľӿ�I���Ϊ�����ļ����ӿڣ���A����C�ֱ�����Ҫ�Ľӿڽ���������ϵ
 * ��Ҳ���ǲ���Ŷ�ӿڸ���ԭ��
 * 
 * �ͻ��˲�Ӧ������������Ҫ�Ľӿڣ�һ�������һ���������Ӧ�ý�������С�Ľӿ���
 * 
 * �ӿڸ���ԭ��ĺ��壺������һ�ӿڣ���Ҫ�����ж��Ӵ�ӷ�׵Ľӿڣ�����ϸ���ӿڣ��ӿ��еķ���������
 */

interface I {
	public void method_1();
	public void method_2();
	public void method_3();
	public void method_4();
	public void method_5();
}

class A2 {
	public void depend_1(I i){
		i.method_1();
	}
	public void depend_2(I i){
		i.method_2();
	}
	public void depend_3(I i){
		i.method_3();
	}
}

class B2 implements I{
	public void method_1(){
		System.out.println("��Bʵ�ֽӿ�I�ķ���1");
	}
	public void method_2(){
		System.out.println("��Bʵ�ֽӿ�I�ķ���2");
	}
	public void method_3(){
		System.out.println("��Bʵ�ֽӿ�I�ķ���3");
	}
	//	������B��˵��method_4��method_5���Ǳ���ģ��������ڽӿ�I�������������������Լ��㷽����Ϊ�գ�Ҳ��Ҫд��
	public void method_4(){
	}
	public void method_5(){
	}
}

class C{
	public void depend_1(I i){
		i.method_1();
	}
	public void depend_2(I i){
		i.method_4();
	}
	public void depend_3(I i){
		i.method_5();
	}
}

class D implements I{

	@Override
	public void method_1() {
		System.out.println("��Dʵ�ֽӿ�I�ķ���1");
	}
	//������D��˵��method_2 method_3���Ǳ���ģ���ҲҪд��
	@Override
	public void method_2() {
	}

	@Override
	public void method_3() {
	}

	@Override
	public void method_4() {
		System.out.println("��Dʵ�ֽӿ�I�ķ���4");
	}
	@Override
	public void method_5() {
		System.out.println("��Dʵ�ֽӿ�I�ķ���5");
	}
	
}

public class InterfaceIsolation {
	public static void main(String []  args){
		A2 a = new A2();
		a.depend_1(new B2());
		a.depend_2(new B2());
		a.depend_3(new B2());
		
		C c = new C();
		c.depend_1(new D());
		c.depend_2(new D());
		c.depend_3(new D());
	}
}


//���Կ����ӿڹ��ڸ��ӣ�����Ȼ������õ���ơ����潫�ӿڲ��
interface I1 {
	public void method_1();
}
interface I2 {
	public void method_2();
	public void method_3();
	
}
interface I3 {
	public void method_4();
	public void method_5();
}

//������ֻ��Ҫʵ�����������Ľӿڡ����벻��

