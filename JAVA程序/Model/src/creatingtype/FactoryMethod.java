package creatingtype;
/*
 * 
 * ����������һ����������Ľӿڣ������������ʵ�����ĸ��ࡣFactoryMethod��һ�����ʵ�����ӳٵ�������
 * �����ԣ�	��һ���಻֪���������봴���Ķ������ʱ
 * 			��һ����ϣ��������������ָ���������Ķ����ʱ��
 * 			���ཫ���������ְ��ί�и�������������е�ĳһ����������ϣ������һ�����������Ǵ�����һ��Ϣ�ֲ�����ʱ��
 * �����ߣ�
 * 		Product�����幤�������������Ķ���Ľӿ�
 * 		ConcreteProduct��ʵ��Product�ӿ�
 * 		Creator�����������������÷�������һ��Product����
 * 		ConcreteCreator���ض��幤�������Է���һ��ConcreteProductʵ��
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
		System.out.println("ѧ��д��ҵ");
	}
	
}
class TeacherWork implements Work{

	@Override
	public void doWork() {
		System.out.println("��ʦ������ҵ");
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
