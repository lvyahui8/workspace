class Outer {
    void method(){
		new	Object(){
			public void show(){
				System.out.println("show run");
			}
		}.show();
		/*
		Object obj = new	Object(){
			public void show(){
				System.out.println("show run");
			}
		};
		//	�����ǲ��еģ������������ת�ͣ��Ͳ����ٷ����������еķ���
		obj.show();	
		*/
	}
}

class InClassDemo6 
{
	public static void main(String[] args) 
	{
		new Outer().method(); 
	}
}
