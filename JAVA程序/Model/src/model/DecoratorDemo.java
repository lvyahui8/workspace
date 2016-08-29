package model;
/*
 * 	装饰设计模式
 *	动态的给一个对象增加额外的职责
 *
 *	装饰设计模式和继承都能实现对功能的扩展增强
 *	有什么区别呢？看下面
 *	Writer
 *		|--TextWriter:用于操作文本
 *		|--MediaWriter:用于操作媒体
 *	想要对操作的动作进行效率的提高
 *	按照面向对象的思想，可以用继承对具体的功能进行扩展
 *	效率提高需要加入缓冲的技术
 *	
 *	Writer
 *		|--TextWriter
 *			|---BufferTextWriter:加入缓冲的技术的操作文本的对象
 *		|--MediaWriter
 *			|---BufferMediaWriter:
 *	到这里就可以了。但是这样做并不理想
 *	如果这个流体系扩展出其他的流类，那还是需要继承。这样会造成流体系越来越庞大臃肿
 *	
 *	所以这是可以考虑使用装饰设计模式，只设计一个装饰类，这个装饰类可以处理一个体系
 *	或者说一个类族。
 *	可以说它是一个类族的化妆间
 *	class Buffer{
 *		Buffer(Writer w){
 *		}
 *	}
 *	// Or	一般是下面这种，因为是装饰，所以接口一般不变
 *	class Buffer extends Writer{
 *		Buffer(Writer w){
 *		}
 *	}
 *	所以在一般情况下装饰类和被装饰类一般处于同一个体系。
 *	
 *	装饰要比继承灵活
 *	用到的地方有很多，比如JAVA的IO流体系 的Buffered就是装饰类
 **/

//  Component
interface Person{
	void eat();
}

//ConcreteComponent
class Man implements Person{
	@Override
	public void eat() {
		System.out.println("男人在吃");
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
		// TODO 自动生成的构造函数存根
	}

	public void eat(){
		super.eat();
		reEat();
		System.out.println("ManDecoratorA类");
	}

	private void reEat() {
		// TODO 自动生成的方法存根
		System.out.println("再来一顿");
	}
}
class ManDecoratorB extends Decorator{
	public ManDecoratorB(Person person) {
		super(person);
		// TODO 自动生成的构造函数存根
	}

	public void eat(){
		super.eat();
		System.out.println("=========");
		System.out.println("ManDecoratorB类");
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
