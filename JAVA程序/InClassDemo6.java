class Outer {
    void method(){
		new	Object(){
			public void show(){
				System.out.println("show run");
			}
		}.show();
		/*
		Object obj = new	Object(){
			public void show(){
				System.out.println("show run");
			}
		};
		//	这样是不行的，子类对象被向上转型，就不能再访问子类特有的方法
		obj.show();	
		*/
	}
}

class InClassDemo6 
{
	public static void main(String[] args) 
	{
		new Outer().method(); 
	}
}
