
//	Object是所有java类的超类（父类、根类）
//	Object是不断抽取出来的，具备所有对象的共性内容
//
/*
*	Object的equals方法是直接比较引用  即  return  this == object
*	Object为什么要写一个有时很鸡肋的功能呢？
*	因为如果，Object不给出默认实现。Object就是抽象类，子类如果不给出
*	抽象方法的实现，就还是抽象类，不能实例化对象。所以Object给出了
*	默认实现，但你需要使用equals方法时，最好去重写该方法。
*/
class Fu {
    Fu(){
		super();
	}
	public String toString(){
		return "Person :"+"wo d";
	}
}
//RuntimeException

class Zi extends Fu {
	private int num;
    Zi(int num){
		this.num = num;
	}
	public boolean equals(Object/*这样才叫重写*/obj){
		if (obj instanceof Zi) {
		    return this.num == ((Zi)obj).num;
		}
		else {
		    throw new ClassCastException("类型错误");
		}
	}
}


class ObjectDemo 
{
	public static void main(String[] args) 
	{
		Zi myZi1 = new Zi(2);
		Zi myZi2 = new Zi(2);
		Fu fu = new Fu();
		if (myZi1.equals(myZi2)) {
		    System.out.println("相同诶！");
		}
		else {
		    System.out.println("不同哦");
		}
	//	Objecct 的 hashCode方法
		System.out.println(fu);
		System.out.println(Integer.toHexString(fu.hashCode()));
	//	Class 是 .class文件类。 对象都是以此类对象在堆中的Class对象产生的。
		Class class1 = myZi1.getClass();
		Class class2 = myZi2.getClass();
		System.out.println(class1 == class2);	//	myZi1 和 myZi2虽然是两个不同的对象，但他们都是由同一个Class对象得到的，所以这里应该是true。
		System.out.println(class1.getName());
		
		System.out.println(fu.toString());
		System.out.println(fu.getClass().getName()+"$"+Integer.toHexString(fu.hashCode()));
	
	}
}
