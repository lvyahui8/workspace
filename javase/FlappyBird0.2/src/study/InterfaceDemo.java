package study;

abstract class Obj{
	abstract void method_1();
	abstract void method_2();
}
//�ӿڶ�����һ����׼�����������׼���ͳ�����һ����ϵ
interface USB{
	/*����ȱʡ  abstract public 
	 * �ֶ�ȱʡ��public static final
	 * */
	void start();
	void stop();
}
/*
 * final 
 * ������Ļ��� ��ʾ��������಻�ܱ��̳�
 * �����ֶεĻ�����ʾ�ֶ�Ϊ��������ʱfinalֻ��8�ֻ����������ͺ����ñ����������ֵ������
 * 
 * fianl  int short byte char float double long boolean a = 10;//��ʱ a�ǳ���
 * 
 * String  StringBuffer s = new String()   StringBuffer();  ���� s = 0x00ff7c  fianlֻ������ص�ֵַ�����ã�s�����޸�Ϊ������ֵַ
 * 
 * ���η���  ��ʾ����������ܱ�����
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



//Java���̳У���ʵ��
class Mouse implements USB{

	@Override
	public void start() {
		System.out.println("���������");
	}

	@Override
	public void stop() {
		System.out.println("���γ�ȥ��");
	}
	
}

class KeyB implements USB{

	@Override
	public void start() {
		System.out.println("���̲������");
	}
	
	@Override
	public void stop() {
		System.out.println("���̰γ�ȥ��");
	}
	
}
