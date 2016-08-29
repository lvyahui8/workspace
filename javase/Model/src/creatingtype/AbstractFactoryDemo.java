package creatingtype;


/*
 * 抽象工厂模式：
 * 提供一个创建一系列相关或相互依赖对象的接口，而无需指定他们具体的类。
 */

//	AbstractFactory-------------------------------------------------
interface IAnimalFactory {
	ICat createCat();
	IDog createDog();
}

//	ConcreteFactory-------------------------------------------------
class BlackAnimalFactory implements IAnimalFactory {

	@Override
	public ICat createCat() {
		// TODO 自动生成的方法存根
		return new BlackCat();
	}

	@Override
	public IDog createDog() {
		// TODO 自动生成的方法存根
		return new BlackDog();
	}
	
}

class WhiteAnimalFactory implements IAnimalFactory{

	public ICat createCat() {
		// TODO 自动生成的方法存根
		return new WhiteCat();
	}

	public IDog createDog() {
		// TODO 自动生成的方法存根
		return new WhiteDog();
	}
	
}

//	AbstractProduct-------------------------------------------------
interface ICat {
	void eat();
}

interface IDog {
	void eat();
}

//	ConcreteProduct-------------------------------------------------
class BlackCat implements ICat {

	@Override
	public void eat() {
		// TODO 自动生成的方法存根
		System.out.println("The black cat is eating!");
	}
	
}

class WhiteCat implements ICat {

	@Override
	public void eat() {
		// TODO 自动生成的方法存根
		System.out.println("The white cat is eating!");
	}
	
}

class BlackDog implements IDog {

	@Override
	public void eat() {
		// TODO 自动生成的方法存根
		System.out.println("The black dog is eating!");
	}
	
}

class WhiteDog implements IDog {

	@Override
	public void eat() {
		// TODO 自动生成的方法存根
		System.out.println("The white dog is eating!");
	}
	
}

//	Clinet-------------------------------------------------
public class AbstractFactoryDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		IAnimalFactory blackAnimalFactory = new BlackAnimalFactory();
		ICat blackCat = blackAnimalFactory.createCat();
		blackCat.eat();
		IDog blackDog = blackAnimalFactory.createDog();
		blackDog.eat();
		
		IAnimalFactory whiteAnimalFactory = new WhiteAnimalFactory();
		ICat whiteCat = whiteAnimalFactory.createCat();
		whiteCat.eat();
		IDog whiteDog = whiteAnimalFactory.createDog();
		whiteDog.eat();
		
	}

}
