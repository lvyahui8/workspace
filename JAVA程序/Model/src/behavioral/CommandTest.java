/*
 * 命令模式
 * 
 * 定义：将一个请求封装成一个对象，从而使你使用不同的请求把客户端参数化，
 * 		对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能
 * 
 * 命令模式的精髓是将命令的调用者与执行者分开，使双方不必关心对方是如何操作的
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
//	调用
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
		System.out.println("接收者-处理业务");
	}
}
public class CommandTest {

	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);
		//客户端直接执行具体的命令方式（此方法与类图相符）
		command.execute();
		//客户端通过调用使用者来执行命令
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		invoker.action();
	}

}
