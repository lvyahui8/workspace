abstract class Demo{
	abstract void show();
}

interface Inter {
    void show1();
	void show2();
}

class Outer {
    public void method(){
//---------�����ڲ���-------------
		new Demo(){		
			void show(){
				System.out.println("��ð�");
			}
		}.show();
		Inter in = new Inter(){
			public void show1(){
				System.out.println("Outer.method.inter.show1();");
			}
			public void show2(){
				System.out.println("Outer.method.inter.show2();");
			}
		};
		in.show1();
		in.show2();
	}
}

/*
ʹ�ó���֮һ��
�����������ǽӿ�����ʱ�����ҽӿ��еķ���������3��
����ʹ�������ڲ�����Ϊʵ�ʲ�����Ϊ����
*/
class NmInClass 
{
	public static void main(String[] args) 
	{
		new Outer().method();
		show(
			new Inter()
			{
				public void show1(){
					System.out.println("Show1");
				}
				public void show2(){
					System.out.println("Show2");
				}
			}
			);
	}

	public static void show(Inter in){
		in.show1();
		in.show2();
	}

}


