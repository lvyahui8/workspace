abstract class Animal {
    public abstract void eat();
	void fight(){
		System.out.println("Animal Fight!");
	}
}

class Dog extends Animal {
    public void eat(){
		System.out.println("Dog Eat!");
	}

	public void lookHome(){
		System.out.println("Look Home!");
	}
	public void fight(){	//	�Ḳ�Ǹ���ĳ�Ա����
		System.out.println("Dog Fight");
	}
}

class Cat extends Animal {
    public void eat(){
		System.out.println("Cat Eat!");
	}
	public void catchMouse(){
		System.out.println("Catch Mouse!");
	}
	public void fight(){
		System.out.println("Cat Fight");
	}
}

class Pig extends Animal {
    public void eat(){
		System.out.println("Pig Eat!");
	}
	public void sleep(){
		System.out.println("Pig Sleep!");
	}
	public void fight(){
		System.out.println("Pig Fight");
	}
}
class DTDemo 
{
	public static void main(String[] args) 
	{
		Dog	myDog = new Dog();
		Cat	myCat = new Cat();
		myDog.fight();
		myCat.fight();
		//myDog.eat();
		//myCat.eat();
		eat(myDog);
		eat(myCat);
		myDog.lookHome();
		myCat.catchMouse();

		Animal	a	=	new Pig();
		//	��ʵ�����õ���java���Զ���������(����ת��)
		a.eat();
		a.fight();
		//	Animal���ò���Pig�����ķ���.
		//a.sleep();
		//	ֻ����ʾ����ת�Ͳ��ܵ���
		Pig		p	=	(Pig)a;
		p.sleep();
		/*	������ʵ��ͬһ�����󣬹�ϣֵ��һ����
		System.out.println(a);
		System.out.println(p);
		*/
	}
	public static void eat(Animal animal){
		animal.eat();
		if(animal instanceof Cat){	//instanceof :	�����ж϶���ľ������ͣ�ֻ������������������
			Cat	c = (Cat)animal;
			c.catchMouse();
		}
		else if(animal instanceof Dog){
		    Dog d = (Dog)animal;
			d.lookHome();
		}
		else if(animal instanceof Pig){
		    Pig p = (Pig)animal;
			p.sleep();
		}
	}
}
