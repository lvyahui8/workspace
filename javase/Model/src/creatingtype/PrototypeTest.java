/*
 * 原型模式
 * 原型模式主要用于对象的拷贝，其实就是C++ 中的复制构造函数
 * 原型模式的核心就是Prototype类，该类具备以下两点特征
 * 1、实现了Cloneable接口，在java语言中有一个Cloneable 接口，
 * 		它的作用只有一个，就是实现对象的复制
 * 2、重写父类的clone接口，提升父类方法的权限为public
 * 
 * 原型模式的优点：
 * 		在性能上比直接new一个对象要快的多，因为它是调用的本地方法，
 * 		它直接操作内存。
 * 		它的另一个好处就是简化对象的创建
 * 
 * 注意事项，使用哦原型模式不会调用类的构造方法，不但构造函数不会执行，甚至
 * 连访问权限都对原型模式无效。可见他是与单例模式冲突的，不可再使用单例时使用原型模式
 * 
 * Object类的clone方法只会拷贝对象中的基本数据类型，对于引用对象不拷贝，这是浅复制
 * 要想实现深复制，就需要对引用类型另行拷贝
 * 
 * PS:能够深拷贝的是JAVA的8种基本数据类型和他们的封装对象以及String类型，其余都是
 * 		浅拷贝
 */
package creatingtype;

import java.util.ArrayList;
import java.util.List;

//class Prototype{
//	private String info;
//	public Prototype(String info){
//		this.info = info;
//	}
//	public Prototype(Prototype p){
//		this.info = p.info;
//	}
//	public String toString(){
//		return super.toString() + "_" + this.info;
//	}
//}
class Prototype implements Cloneable{
	private ArrayList list = new ArrayList();

	public Prototype clone(){
		Prototype prototype = null;
		try{
			prototype = (Prototype)super.clone();//调用父类的本地方法，拷贝基本数据类型
			prototype.list = (ArrayList)this.list.clone();
		}
		catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return prototype;
	}
}

class ConcretePrototype extends Prototype{
	public void show(){
		System.out.println("原型模式实现类");
	}
}

public class PrototypeTest {

	public static void main(String[] args) {
//		Prototype p1 = new Prototype("属性1");
//		Prototype p2 = new Prototype(p1);
//		System.out.println(p1);
//		System.out.println(p2);
		
		ConcretePrototype cp = new ConcretePrototype();
		for (int i = 0; i < 10; i++) {
			ConcretePrototype clonecp = (ConcretePrototype)cp.clone();
			clonecp.show();
		}
		
	}
}
