/*
 * ԭ��ģʽ
 * ԭ��ģʽ��Ҫ���ڶ���Ŀ�������ʵ����C++ �еĸ��ƹ��캯��
 * ԭ��ģʽ�ĺ��ľ���Prototype�࣬����߱�������������
 * 1��ʵ����Cloneable�ӿڣ���java��������һ��Cloneable �ӿڣ�
 * 		��������ֻ��һ��������ʵ�ֶ���ĸ���
 * 2����д�����clone�ӿڣ��������෽����Ȩ��Ϊpublic
 * 
 * ԭ��ģʽ���ŵ㣺
 * 		�������ϱ�ֱ��newһ������Ҫ��Ķ࣬��Ϊ���ǵ��õı��ط�����
 * 		��ֱ�Ӳ����ڴ档
 * 		������һ���ô����Ǽ򻯶���Ĵ���
 * 
 * ע�����ʹ��Ŷԭ��ģʽ���������Ĺ��췽�����������캯������ִ�У�����
 * ������Ȩ�޶���ԭ��ģʽ��Ч���ɼ������뵥��ģʽ��ͻ�ģ�������ʹ�õ���ʱʹ��ԭ��ģʽ
 * 
 * Object���clone����ֻ�´�������еĻ����������ͣ��������ö��󲻿���������ǳ����
 * Ҫ��ʵ����ƣ�����Ҫ�������������п���
 * 
 * PS:�ܹ��������JAVA��8�ֻ����������ͺ����ǵķ�װ�����Լ�String���ͣ����඼��
 * 		ǳ����
 */
package creatingtype;

import java.util.ArrayList;
import java.util.List;

//class Prototype{
//	private String info;
//	public Prototype(String info){
//		this.info = info;
//	}
//	public Prototype(Prototype p){
//		this.info = p.info;
//	}
//	public String toString(){
//		return super.toString() + "_" + this.info;
//	}
//}
class Prototype implements Cloneable{
	private ArrayList list = new ArrayList();

	public Prototype clone(){
		Prototype prototype = null;
		try{
			prototype = (Prototype)super.clone();//���ø���ı��ط���������������������
			prototype.list = (ArrayList)this.list.clone();
		}
		catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return prototype;
	}
}

class ConcretePrototype extends Prototype{
	public void show(){
		System.out.println("ԭ��ģʽʵ����");
	}
}

public class PrototypeTest {

	public static void main(String[] args) {
//		Prototype p1 = new Prototype("����1");
//		Prototype p2 = new Prototype(p1);
//		System.out.println(p1);
//		System.out.println(p2);
		
		ConcretePrototype cp = new ConcretePrototype();
		for (int i = 0; i < 10; i++) {
			ConcretePrototype clonecp = (ConcretePrototype)cp.clone();
			clonecp.show();
		}
		
	}
}
