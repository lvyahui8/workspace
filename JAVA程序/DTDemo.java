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
	public void fight(){	//	会覆盖父类的成员函数
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
		//	其实这里用到了java的自动类型提升(向上转型)
		a.eat();
		a.fight();
		//	Animal调用不到Pig新增的方法.
		//a.sleep();
		//	只有显示向下转型才能调用
		Pig		p	=	(Pig)a;
		p.sleep();
		/*	两者其实是同一个对象，哈希值是一样的
		System.out.println(a);
		System.out.println(p);
		*/
	}
	public static void eat(Animal animal){
		animal.eat();
		if(animal instanceof Cat){	//instanceof :	用于判断对象的具体类型，只能用于引用数据类型
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
