/*
 * 中介者模式：
 * 
 * 定义：用中介者对象封装一系列的对象交互，中介者使各对象不需要显示地相互作用
 * ，从而使耦合松散，而且独立改变它们之间的交互
 * 中介者模式又称为调停模式。分3部分
 * 
 * 抽象中介者
 * 实际中介者
 * 同事类
 * 
 * 为何需要这种模式：
 * 		一般而言，同事类之间的关系是比较复杂的，多个同事类之间互相关联时，它们质检单
 * 		关系会呈现出复杂的网状结构，这是一种过度耦合的架构。既不便于类的复用，也不稳定
 * 		这样的架构，任意两两同事之间都要通信，如此变成了一个有向完全图，实在太过复杂。
 * 		但如果使用中介者模式，整体结构就变成了一个星状结构，一个同事类变动，只需要修改
 * 		该类和中介者，不需要修改其他同事类。
 * 		
 */
package behavioral;
////抽象同事类
//abstract class AbstractColleague{
//	protected int number;
//	public int getNumber(){
//		return number;
//	}
//	
//	public void setNumber(int number){
//		this.number = number;
//	}
//	
//	//抽象方法，修改数字时同时修改关联对象
//	public abstract void setNumber(int number,AbstractColleague coll);
//	
//}
//
//class ColleagueA extends AbstractColleague{
//	public void setNumber(int number,AbstractColleague coll){
//		this.number = number;
//		coll.setNumber(number*100);
//	}
//}
//
//class ColleagueB extends AbstractColleague{
//
//	@Override
//	public void setNumber(int number, AbstractColleague coll) {
//		this.number = number;
//		coll.setNumber(number/100);
//	}
//	
//}
public class IntermediariesTest {

	public static void main(String[] args) {
		AbstractColleague collA = new ColleagueA();
		AbstractColleague collB = new ColleagueB();
		
		AbstractMediator am = new Mediator(collA, collB);
		

		System.out.println("==============设置A影响B==============");
//		collA.setNumber(1288,collB);
		collA.setNumber(1000, am);
		System.out.println("collA的number值:"+collA.getNumber());
//		System.out.println("collB的number值:"+collB.getNumber());
		System.out.println("collB的number值为A的100倍:"+collB.getNumber());
//		
		System.out.println("==============设置B影响A==============");
//		collB.setNumber(87635, collA);
		collB.setNumber(1000,am);
		System.out.println("collB的number值："+collB.getNumber());
//		System.out.println("collA的number值："+collA.getNumber());
		System.out.println("collA的number值为B的0.01倍："+collA.getNumber());

	}

}

//上面两个类之间直接发生关系，加入我们需要使用中介者模式，类A和类B之间是
//不可以直接关联，他们之间必须要通过一个中介者来达到关联的目的

abstract class AbstractMediator{
	protected AbstractColleague a;
	protected AbstractColleague b;
	public AbstractMediator(AbstractColleague a,AbstractColleague b){
		this.a = a;
		this.b = b;
	}
	public abstract void BaffectA();
	public abstract void AaffectB();
}
class Mediator extends AbstractMediator{

	public Mediator(AbstractColleague a, AbstractColleague b) {
		super(a, b);
	}

	@Override
	public void BaffectA() {
		int number = b.getNumber();
		a.setNumber(number/100);
	}

	@Override
	public void AaffectB() {
		int number = a.getNumber();
		b.setNumber(number*100);
	}
	
}
abstract class AbstractColleague{
	protected int number;
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int number){
		this.number = number;
	}
	
	//注意这里的参数不再是同事类，而是中介者
	public abstract void setNumber(int number,AbstractMediator am);
	
}

class ColleagueA extends AbstractColleague{
	public void setNumber(int number,AbstractMediator am){
		this.number = number;
		am.AaffectB();
	}
}

class ColleagueB extends AbstractColleague{

	@Override
	public void setNumber(int number,AbstractMediator am) {
		this.number = number;
		am.BaffectA();
	}
	
}