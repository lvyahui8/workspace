package behavioral;

import javax.swing.JOptionPane;

/*
 * ְ����ģʽ
 * 
 * ʹ��������л��ᴦ�����󣬴Ӷ������������������֮�����Ϲ�ϵ��
 * 
 * ����Щ��������һ���������������������ݸ�����֪���ж�������Ϊֹ
 * 
 */
/*
//���ȿ�һ�δ���

public void test(int i,Request request){
	if(1 == i){
		handler1.response(request);
	}
	else if(2 == i){
		handler2.response(request);
	}
	else if(3 == i){
		handler3.response(request);
	}
}

���з�ʽ���ŵ����߼��򵥣�ֱ�ۣ�����ά��
	����ȱ���ǣ� 	����ӷ��:ʵ�ʿ����У������Ǽ򵥵ıȽ�1 == this�����ܻ��Ƿǳ����ӵļ��㣬�����������ͺܴ���
				��ϸߣ�����һ�������߾�Ҫ����if else ����������Ƚ�˳����д����
*/

//����ʹ��ְ����ģʽ

class Level {//�ȼ�
	private int level =0;

	protected Level(int level) {
		super();
		this.level = level;
	}
	
	public boolean abovel(Level level){
		boolean isHight = false;
		if(this.level >= level.level){
			isHight = true;
		}
		return isHight;
	}
	
}

class Request{//����
	Level level;

	protected Request(Level level) {
		super();
		this.level = level;
	}

	public Level getLevel() {
		return level;
	}
	
}

class Response{//��Ӧ
	
}

abstract class Handler{
	private Handler nextHandler;
	
	protected abstract Level getHandlerLevel();
	protected abstract Response response(Request request);
	public final Response handleRequest(Request request){
		Response response = null;
		
		if(this.getHandlerLevel().abovel(request.getLevel())){
			response = this.response(request);
			
		}
		else{
			if(this.nextHandler != null){
				this.nextHandler.handleRequest(request);
			}
			else{
				System.out.println("û�к��ʵĴ�����");
			}
		}
		return response;
	}
	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
}

class ConcreteHandler1 extends Handler{

	@Override
	protected Level getHandlerLevel() {
		//
		return new Level(1);
	}

	@Override
	protected Response response(Request request) {
		//
		System.out.println("�����ɴ�����1����");
		return null;
	}
	
}
class ConcreteHandler2 extends Handler{
	
	@Override
	protected Level getHandlerLevel() {
		//
		return new Level(2);
	}
	
	@Override
	protected Response response(Request request) {
		//
		System.out.println("�����ɴ�����2����");
		return null;
	}
	
}
class ConcreteHandler3 extends Handler{
	
	@Override
	protected Level getHandlerLevel() {
		//
		return new Level(3);
	}
	
	@Override
	protected Response response(Request request) {
		//
		System.out.println("�����ɴ�����3����");
		return null;
	}
	
}

public class ChainOfResponsibilityTest {

	
	public static void main(String[] args) {
		Handler handler1 = new ConcreteHandler1();
		Handler handler2 = new ConcreteHandler2();
		Handler handler3 = new ConcreteHandler3();
		
		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler3);
		
		Response response = handler1.handleRequest(new Request(new Level(2)));
	}

}
