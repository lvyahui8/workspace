package creatingtype;


/*
 * ���󹤳�ģʽ��
 * �ṩһ������һϵ����ػ��໥��������Ľӿڣ�������ָ�����Ǿ�����ࡣ
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
		// TODO �Զ����ɵķ������
		return new BlackCat();
	}

	@Override
	public IDog createDog() {
		// TODO �Զ����ɵķ������
		return new BlackDog();
	}
	
}

class WhiteAnimalFactory implements IAnimalFactory{

	public ICat createCat() {
		// TODO �Զ����ɵķ������
		return new WhiteCat();
	}

	public IDog createDog() {
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		System.out.println("The black cat is eating!");
	}
	
}

class WhiteCat implements ICat {

	@Override
	public void eat() {
		// TODO �Զ����ɵķ������
		System.out.println("The white cat is eating!");
	}
	
}

class BlackDog implements IDog {

	@Override
	public void eat() {
		// TODO �Զ����ɵķ������
		System.out.println("The black dog is eating!");
	}
	
}

class WhiteDog implements IDog {

	@Override
	public void eat() {
		// TODO �Զ����ɵķ������
		System.out.println("The white dog is eating!");
	}
	
}

//	Clinet-------------------------------------------------
public class AbstractFactoryDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
