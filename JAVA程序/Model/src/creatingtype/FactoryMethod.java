package creatingtype;
/*
 * 
 * 概述：定义一个创建对象的接口，让其子类决定实例化哪个类。FactoryMethod是一个类的实例化延迟到其子类
 * 适用性：	当一个类不知道它锁必须创建的对象的类时
 * 			当一个类希望由它的子类来指定所创建的对象的时候
 * 			当类将创建对象的职责委托给多个帮助子类中的某一个，并且你希望将哪一个帮助子类是代理者一信息局部化的时候
 * 参与者：
 * 		Product：定义工厂方法锁创建的对象的接口
 * 		ConcreteProduct：实现Product接口
 * 		Creator：声明工厂方法，该方法返回一个Product对象
 * 		ConcreteCreator：重定义工厂方法以返回一个ConcreteProduct实例
 * 
 */

//Product
interface Work{
	void doWork();
}

//ConcreteProduct
class StudentWork implements Work{

	@Override
	public void doWork() {
		System.out.println("学生写作业");
	}
	
}
class TeacherWork implements Work{

	@Override
	public void doWork() {
		System.out.println("老师审批作业");
	}
	
}

//Creator
interface IWorkFactory{
	public Work getWork();
}

//ConcreteCreator
class StudentWorkFactory implements IWorkFactory{

	@Override
	public Work getWork() {
		return new StudentWork();
	}
	
}
class TeacherWorkFactory implements IWorkFactory{

	@Override
	public Work getWork() {
		return new TeacherWork();
	}
	
}
public class FactoryMethod {

	public static void main(String[] args) {
		IWorkFactory studenWorkFactory = new StudentWorkFactory();
		studenWorkFactory.getWork().doWork();

		IWorkFactory teacherWorkFactory = new TeacherWorkFactory();
		teacherWorkFactory.getWork().doWork();
	}

}
