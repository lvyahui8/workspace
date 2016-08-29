package behavioral;

import javax.swing.JOptionPane;

/*
 * 职责链模式
 * 
 * 使多个对象都有机会处理请求，从而避免请求者与调用者之间的耦合关系。
 * 
 * 将这些对象连成一条链，并沿着这条链传递该请求，知道有对象处理它为止
 * 
 */
/*
//首先看一段代码

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

这中方式的优点是逻辑简单，直观，易于维护
	它的缺点是： 	代码臃肿:实际开发中，不会是简单的比较1 == this。可能会是非常复杂的计算，这样代码量就很大了
				耦合高：增加一个处理者就要新增if else 。而且这个比较顺序是写死的
*/

//下面使用职责连模式

class Level {//等级
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

class Request{//请求
	Level level;

	protected Request(Level level) {
		super();
		this.level = level;
	}

	public Level getLevel() {
		return level;
	}
	
}

class Response{//响应
	
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
				System.out.println("没有合适的处理器");
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
		System.out.println("请求由处理器1处理");
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
		System.out.println("请求由处理器2处理");
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
		System.out.println("请求由处理器3处理");
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
