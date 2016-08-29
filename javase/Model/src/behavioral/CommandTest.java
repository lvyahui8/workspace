/*
 * ����ģʽ
 * 
 * ���壺��һ�������װ��һ�����󣬴Ӷ�ʹ��ʹ�ò�ͬ������ѿͻ��˲�������
 * 		�������Ŷӻ��߼�¼������־�������ṩ����ĳ����ͻָ�����
 * 
 * ����ģʽ�ľ����ǽ�����ĵ�������ִ���߷ֿ���ʹ˫�����ع��ĶԷ�����β�����
 */
package behavioral;

abstract class Command {
	public abstract void execute();
}

class ConcreteCommand extends Command{
	private Receiver receiver;
	
	public ConcreteCommand(Receiver receiver){
		this.receiver = receiver;
	}
	@Override
	public void execute() {
		this.receiver.doSomething();
	}
	
}
//	����
class Invoker {
	private Command command;
	public void setCommand(Command command){
		this.command = command;
	}
	public void action(){
		this.command.execute();
	}
}

class Receiver{
	public void doSomething(){
		System.out.println("������-����ҵ��");
	}
}
public class CommandTest {

	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);
		//�ͻ���ֱ��ִ�о�������ʽ���˷�������ͼ�����
		command.execute();
		//�ͻ���ͨ������ʹ������ִ������
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		invoker.action();
	}

}
