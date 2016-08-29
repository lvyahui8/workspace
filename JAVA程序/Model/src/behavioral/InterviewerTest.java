/*
 * ������ģʽ
 * 
 * ��װĳ��������ĳ�����ݽṹ�и�Ԫ�صĲ������������ڲ��ı�
 * ���ݽṹ��ǰ���¶�����������ЩԪ�ص��µĲ���
 * 
 * ������ģʽ�Ƚϸ��ӣ��������򵥵�
 */
package behavioral;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

////////////////////////////////////////////////////
//�ڱ����� B���Ƿ����ߣ�A���Ǳ������ߣ�����Ƿ���ģʽ�ļ�ʵ��
class A{
	public void method1(){
		System.out.println("����A");
	}
	public void method2(B b){
		b.showA(this);
	}
}
class B{
	public void showA(A a){
		a.method1();
	}
}
////////////////////////////////////////////////////

/*
 * ������ģʽ��ͨ��ʵ�֣�
 * ��Ҫ�������½�ɫ
 * ��������ߣ���������߽ӿڣ����������߿��Է�����ЩԪ�أ����嵽�����о���visited�����еĲ���
 * 			������Щ�����ǿ��Է��ʵ�
 * 
 * �����ߣ�ʵ�ֳ���������������ķ�������Ӱ�쵽�����߷���һ����֮��ø�ʲô��Ҫ��ʲô����
 * 
 * ����Ԫ���ࣺ�ӿڻ�����࣬����������һ������߷��ʣ���������ͨ��accept�����еĲ���������ġ�
 * 			����Ԫ��һ�������෽����һ�����Ǳ����ҵ���߼��������������������������������
 * 
 * Ԫ���ࣺʵ�ֳ���Ԫ������������accept������ͨ������visitor.visit(this);���������Ѿ���Ϊһ�ֶ�ʽ��
 * 
 * �ṹ����һ��Ԫ�ص�������һ�����һ�����ɶ����ͬ���࣬��ͬ�ӿڵ���������List��Set��Map�ȡ�����Ŀ��һ��
 * 			���ٳ��������ɫ
 * 
 */

abstract class Element{
	public abstract void accept(IVisitor visitor);
	public abstract void doSomething();
}

interface IVisitor {
	public void visit(ConcreteElement1 el1);
	public void visit(ConcreteElement2 el2);
}

class ConcreteElement1 extends Element{

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void doSomething() {
		System.out.println("����Ԫ��1");
	}
	
}
class ConcreteElement2 extends Element{
	
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public void doSomething() {
		System.out.println("����Ԫ��2");
	}
	
}

class Visitor implements IVisitor{
	@Override
	public void visit(ConcreteElement1 el1) {
		el1.doSomething();
	}

	@Override
	public void visit(ConcreteElement2 el2) {
		el2.doSomething();
	}
}

class ObjectStruture{
	public static List<Element> getlist(){
		List<Element> list = new ArrayList<Element>();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int a = r.nextInt(100);
			if(a>50){
				list.add(new ConcreteElement1());
			}
			else{
				list.add(new ConcreteElement2());
			}
		}
		return list;
	}
}
public class InterviewerTest {

	public static void main(String[] args) {
		/*A a = new A();
		a.method1();
		a.method2(new B());*/
		List<Element> list = ObjectStruture.getlist();
		for(Element e : list){
			e.accept(new Visitor());
		}
	}

}
