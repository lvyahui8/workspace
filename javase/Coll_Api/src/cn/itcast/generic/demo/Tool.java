package cn.itcast.generic.demo;

public class Tool<T>{
	private T Elem;

	public T getElem() {
		return Elem;
	}

	public void setElem(T elem) {
		Elem = elem;
	}
	
	public String toString(){
		return this.Elem.toString();
	}
	public void print(T str){
		System.out.println(str);
	}
	public static <W> void show(W str){
		System.out.println(str);
	}
}
