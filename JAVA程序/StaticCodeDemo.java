//	静态代码块   构造代码块  构造函数
//	3者调用的顺序
//	静态代码块  如果有对象  先调用构造代码块 ，再调用构造函数
class StaticCode {
	// 随着类的加载被执行，只会被调用一次(因为类生命周期很长，一般只被加载一次)
	// 它的作用一般是给类进行初始化。（有的类是不需要对象的）
	static {		//一般在第一次产生对象时被调用
		System.out.println("静态代码块被调用了");
	}

	void show(){
		System.out.println("Show方法被调用了");
	}
    
}

class Person {
	private String name;

	{//构造代码块，将不同的构造函数中的共性代码抽取出来
		System.out.println("构造代码块被调用了");
		cry();
	}

	Person(){
		name = "Baby";
		System.out.println("无参构造函数");
		//cry();
	}

	Person(String name){
		this.name = name;
		//cry();
		System.out.println("带参构造函数");
	}

	public void cry(){
		System.out.println("cry方法被调用");
	}
    
}
class StaticCodeDemo 
{
	public static void main(String[] args) 
	{
		new StaticCode().show();
		new StaticCode().show();
		
		System.out.println("\n");
		Person pBay1 = new Person();
		Person pBay2 = new Person("DJ");
	}
}
