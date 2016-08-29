package cn.itcast.generic.demo;

public class GenericInterfaceDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Inter<String>in = new InterImpl_l<String>();
		in.show("nihao");
		
		in = new InterImpl_2();
		in.show("nio");
	}
}


interface Inter<T>{
	public void show (T t);
}

class InterImpl_l <T> /*��������*/implements Inter<T>{

	@Override
	public void show(T t) {
		// TODO �Զ����ɵķ������
		System.out.println(t);
	}
	
}

class InterImpl_2 implements Inter<String>/*��ȷ����*/{

	@Override
	public void show(String t) {
		// TODO �Զ����ɵķ������
		System.out.println("str:"+t);
	}
	
}