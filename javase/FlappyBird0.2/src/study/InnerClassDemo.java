package study;
class Test{
	void fun2(){
		
	}
	void fun(){
		
	}
}
//ʲôʱ�����ڲ��࣬��һ����ֻΪĳһ��A����񣬲��ұز����٣���ô��Ӧ�ö���Ϊ���A����ڲ���
class ExternalClass{
	private String ziduan;
	private void method(){
		
	}
	//��򵥵��ڲ���
	class InnerClass_1{
		
	}
	
	//�����ڲ���
	
	public void method_1(){
		//�����ڲ��࣬һ�㶨���ں������棬ʲôʱ��ʹ���أ���ֻ��Ҫһ�������Ķ��󣬲���ֻʹ��һ��
//		new Test(){
//			private int in_ziduan;
//			public void fun(){
//				
//			}
//		};//������ʵҲ������һ������
		
//		new Test(){
//			private int in_ziduan;
//			public void fun(){
//				System.out.println("�ڲ���");
//			}
//		}.fun();//����ʹ�������ڲ��������һ���������󣬲����ö���ķ���
		
/*��������*/	
		Test test = new Test(){//new  �������
			private int in_ziduan;//����һ���ָ�����û�е�������
			public void fun(){
				System.out.println("�ڲ���");
			}
		};//����ʹ�������ڲ��������һ���������󣬲��Ҹ�ֵ����������
		
		test.fun();//��һ�����������ָ��һ��������󣬸��������ֻ�ܵ��ø����ֵķ����������и��Ǹ���ķ����������Ը��Ǹ���ķ���Ϊ����
	}
	
}


public class InnerClassDemo {

	public static void main(String[] args) {
		new ExternalClass().method_1();//����������÷���
	}

}
