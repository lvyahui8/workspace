package cn.itcast.wrapper.demo;

public class WrapperDemo2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int num = 4;
		num = num + 5;
		
		Integer i = 4;	// 1.5�汾�ų��ֵ����ԣ�����Զ�װ��  ����д
		i = i + 5;	//	���Ƚ�i��ɻ����������ͣ��ں�  6 ��� ,//i.intValue()�Զ�����
		show(i);
		
		Integer a = 127;//	JDK1.5�Ժ��Զ�װ�䣬���װ�����һ���ֽڣ���ô�����ݻᱻ���������¿��ٿռ�
		Integer b = 127;
		Integer c = null;	//һ��Ҫ����׳���ж�
		show(a == b);
		show(a.equals(b));
		Integer m = new Integer(12);
		Integer n = new Integer(12);
		show( m == n);
		show(m.equals(b));
		
	}
	public static void show(Object a) {
		// TODO �Զ����ɵķ������
		System.out.println("a="+a);
	}
}
