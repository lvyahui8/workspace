package cn.itcast.generic.demo;

public class GenericDefineDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Tool<Student> tool_1 = new Tool<Student>();
		Tool<Worker>  tool_2 = new Tool<Worker>();
		
		tool_1.setElem(new Student("ѧ��",12));
		System.out.println(tool_1);
		System.out.println(tool_1.getElem()); 
		tool_2.setElem(new Worker("IT��",23));
		System.out.println(tool_2);
		System.out.println(tool_2.getElem());
		
		
		Tool<Integer> tool_3 = new Tool<Integer>();
		
		Tool tool_4 = new Tool();
		tool_4.setElem("Object");
		System.out.println(tool_4.getElem());
		
		Tool.show("��̬ģ�庯��");
	}
}
