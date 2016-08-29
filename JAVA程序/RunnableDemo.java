//	ʵ���̵߳�����һ�ַ�����ʵ��Runnable�ӿڡ���Ҫ����Ϊjava��֧�ֶ�̳У���֧�ֵ��̳кͶ�ʵ�֡�
/*
1��������ʵ��Runnable�ӿ���
2��ʵ�ֽӿ��е�run������
3����Runnable�ӿڵ����������ΪThread��Ĺ��캯���Ĳ������ڴ����̶߳���֮ǰ������ȷҪ���е����񣩡�
4�������̶߳����start���������߳�
*/
class Demo implements Runnable{
    private String name;
	Demo(String name){
		this.name = name;
	}
	public void show(){
		
		for (int i=1;i<=10 ;i++ ) {
		    //System.out.println("  ."+name+".  "+getName());	//	��ǰ�̶߳��������
			System.out.println("  ."+name+".  "+Thread.currentThread().getName());		//	��ǰ�����̵߳�����
		}
	}
	//	ʵ�ֽӿڵ�run������
	public void run(){
		show();
	}
}

class RunnableDemo 
{
	public static void main(String[] args) 
	{
		Demo	d1	=	new	Demo("1");
		Demo	d2	=	new	Demo("2");
		Thread	t1	=	new	Thread(d1,"�߳�1");
		Thread	t2	=	new	Thread(d2,"�߳�2");
		t1.start();
		t2.start();

	}
}
