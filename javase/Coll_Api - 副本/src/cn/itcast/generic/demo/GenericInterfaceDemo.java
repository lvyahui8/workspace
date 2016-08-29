package cn.itcast.generic.demo;

public class GenericInterfaceDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Inter<String>in = new InterImpl_l<String>();
		in.show("nihao");
		
		in = new InterImpl_2();
		in.show("nio");
	}
}


interface Inter<T>{
	public void show (T t);
}

class InterImpl_l <T> /*继续泛型*/implements Inter<T>{

	@Override
	public void show(T t) {
		// TODO 自动生成的方法存根
		System.out.println(t);
	}
	
}

class InterImpl_2 implements Inter<String>/*明确类型*/{

	@Override
	public void show(String t) {
		// TODO 自动生成的方法存根
		System.out.println("str:"+t);
	}
	
}