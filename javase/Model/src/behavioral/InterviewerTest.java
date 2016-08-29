/*
 * 访问者模式
 * 
 * 封装某种作用于某种数据结构中各元素的操作，它可以在不改变
 * 数据结构的前提下定义作用于这些元素的新的操作
 * 
 * 访问者模式比较复杂，先来个简单的
 */
package behavioral;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

////////////////////////////////////////////////////
//在本例中 B就是访问者，A就是被访问者，这就是访问模式的简单实现
class A{
	public void method1(){
		System.out.println("我是A");
	}
	public void method2(B b){
		b.showA(this);
	}
}
class B{
	public void showA(A a){
		a.method1();
	}
}
////////////////////////////////////////////////////

/*
 * 访问者模式的通用实现：
 * 主要包括以下角色
 * 抽象访问者：抽象类或者接口，声明访问者可以访问哪些元素，具体到程序中就是visited方法中的参数
 * 			定义哪些对象是可以访问的
 * 
 * 访问者：实现抽象访问者所声明的方法，它影响到访问者访问一个类之后该干什么，要做什么事情
 * 
 * 抽象元素类：接口或抽象类，声明接受哪一类访问者访问，程序上是通过accept方法中的参数来定义的。
 * 			抽象元素一般有两类方法，一部分是本身的业务逻辑，另外就是允许接收哪类访问者来访问
 * 
 * 元素类：实现抽象元素类所声明的accept方法，通常都是visitor.visit(this);，基本上已经成为一种定式了
 * 
 * 结构对象：一个元素的容器，一般包含一个容纳多个不同的类，不同接口的容器，如List，Set，Map等。在项目中一般
 * 			很少抽象这个角色
 * 
 */

abstract class Element{
	public abstract void accept(IVisitor visitor);
	public abstract void doSomething();
}

interface IVisitor {
	public void visit(ConcreteElement1 el1);
	public void visit(ConcreteElement2 el2);
}

class ConcreteElement1 extends Element{

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void doSomething() {
		System.out.println("这是元素1");
	}
	
}
class ConcreteElement2 extends Element{
	
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public void doSomething() {
		System.out.println("这是元素2");
	}
	
}

class Visitor implements IVisitor{
	@Override
	public void visit(ConcreteElement1 el1) {
		el1.doSomething();
	}

	@Override
	public void visit(ConcreteElement2 el2) {
		el2.doSomething();
	}
}

class ObjectStruture{
	public static List<Element> getlist(){
		List<Element> list = new ArrayList<Element>();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int a = r.nextInt(100);
			if(a>50){
				list.add(new ConcreteElement1());
			}
			else{
				list.add(new ConcreteElement2());
			}
		}
		return list;
	}
}
public class InterviewerTest {

	public static void main(String[] args) {
		/*A a = new A();
		a.method1();
		a.method2(new B());*/
		List<Element> list = ObjectStruture.getlist();
		for(Element e : list){
			e.accept(new Visitor());
		}
	}

}
