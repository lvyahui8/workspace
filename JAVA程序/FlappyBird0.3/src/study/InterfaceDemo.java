package study;

abstract class Obj{
	abstract void method_1();
	abstract void method_2();
}
//接口定义了一个标准，有了这个标准，就出现了一个体系
interface USB{
	/*方法缺省  abstract public 
	 * 字段缺省是public static final
	 * */
	void start();
	void stop();
}
/*
 * final 
 * 修饰类的话： 表示的是这个类不能被继承
 * 修饰字段的话：表示字段为常量，这时final只对8种基本数据类型和引用变量本身的数值起作用
 * 
 * fianl  int short byte char float double long boolean a = 10;//这时 a是常量
 * 
 * String  StringBuffer s = new String()   StringBuffer();  、、 s = 0x00ff7c  fianl只对这个地地址值起作用，s不能修改为其他地址值
 * 
 * 修饰方法  表示这个方法不能被覆盖
 * 
 */


public class InterfaceDemo {

	public static void main(String[] args) {
//		USB usb = new Mouse();
		USB usb = new KeyB();
		useUSB(usb);
	}

	public static void useUSB(USB usb) {
		if(usb!=null){
			usb.start();
			usb.stop();
		}
	}

}



//Java单继承，多实现
class Mouse implements USB{

	@Override
	public void start() {
		System.out.println("鼠标插进来了");
	}

	@Override
	public void stop() {
		System.out.println("鼠标拔出去了");
	}
	
}

class KeyB implements USB{

	@Override
	public void start() {
		System.out.println("键盘插进来了");
	}
	
	@Override
	public void stop() {
		System.out.println("键盘拔出去了");
	}
	
}
