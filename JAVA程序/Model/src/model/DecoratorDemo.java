package model;
/*
 * 	װ�����ģʽ
 *	��̬�ĸ�һ���������Ӷ����ְ��
 *
 *	װ�����ģʽ�ͼ̳ж���ʵ�ֶԹ��ܵ���չ��ǿ
 *	��ʲô�����أ�������
 *	Writer
 *		|--TextWriter:���ڲ����ı�
 *		|--MediaWriter:���ڲ���ý��
 *	��Ҫ�Բ����Ķ�������Ч�ʵ����
 *	������������˼�룬�����ü̳жԾ���Ĺ��ܽ�����չ
 *	Ч�������Ҫ���뻺��ļ���
 *	
 *	Writer
 *		|--TextWriter
 *			|---BufferTextWriter:���뻺��ļ����Ĳ����ı��Ķ���
 *		|--MediaWriter
 *			|---BufferMediaWriter:
 *	������Ϳ����ˡ�������������������
 *	����������ϵ��չ�����������࣬�ǻ�����Ҫ�̳С��������������ϵԽ��Խ�Ӵ�ӷ��
 *	
 *	�������ǿ��Կ���ʹ��װ�����ģʽ��ֻ���һ��װ���࣬���װ������Դ���һ����ϵ
 *	����˵һ�����塣
 *	����˵����һ������Ļ�ױ��
 *	class Buffer{
 *		Buffer(Writer w){
 *		}
 *	}
 *	// Or	һ�����������֣���Ϊ��װ�Σ����Խӿ�һ�㲻��
 *	class Buffer extends Writer{
 *		Buffer(Writer w){
 *		}
 *	}
 *	������һ�������װ����ͱ�װ����һ�㴦��ͬһ����ϵ��
 *	
 *	װ��Ҫ�ȼ̳����
 *	�õ��ĵط��кܶ࣬����JAVA��IO����ϵ ��Buffered����װ����
 **/

//  Component
interface Person{
	void eat();
}

//ConcreteComponent
class Man implements Person{
	@Override
	public void eat() {
		System.out.println("�����ڳ�");
	}
}
//  Decorator
abstract class Decorator implements Person{
	protected Person person;
	public Decorator(Person person){
		this.person = person;
	}
	
	public void eat(){
		person.eat();
	}
}
//  ConcreteDecorator
class ManDecoratorA extends Decorator{
	public ManDecoratorA(Person person) {
		super(person);
		// TODO �Զ����ɵĹ��캯�����
	}

	public void eat(){
		super.eat();
		reEat();
		System.out.println("ManDecoratorA��");
	}

	private void reEat() {
		// TODO �Զ����ɵķ������
		System.out.println("����һ��");
	}
}
class ManDecoratorB extends Decorator{
	public ManDecoratorB(Person person) {
		super(person);
		// TODO �Զ����ɵĹ��캯�����
	}

	public void eat(){
		super.eat();
		System.out.println("=========");
		System.out.println("ManDecoratorB��");
	}
}
public class DecoratorDemo {
	public static void main(String [] args){
		Man man = new Man();
		ManDecoratorA manA = new ManDecoratorA(man);
		ManDecoratorB manB = new ManDecoratorB(man);
		manA.eat();
		manB.eat();
	}
}

/*class Person{
	void eat(){
		System.out.println("person eat");
	}
}

class NewPerson{
	private Person p ;
	NewPerson(Person p){
		this.p = p;
	}
	public void eat(){
		System.out.println("person newEat");
		p.eat();
	}
}*/
