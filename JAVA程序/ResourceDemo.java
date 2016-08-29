/*
�ȴ�/���ѻ��ơ�
�漰����

1.wait();		//	���̴߳��ڶ���״̬����wait���̻߳ᱻ�洢���̳߳��У��̳߳��кܶ�����ö�Ӧ���������֡�
2.notify();		//	���ڻ����̳߳��е�һ���߳�(����)��
3.notifyAll();	//	�����̳߳��е������̣߳��������߳̾߱�CPU��ִ���ʸ񣩣�

//	��Щ��������������ͬ����
//	��Ϊ��Щ�������ڲ����߳�״̬�ķ���
//	����Ҫ��ȷ���ײ��������ĸ����ϵ��̣߳������ѱ���Ҫ������   ��.wait();,��.notify();,��.notifyAll();
*/
class  Resource {
    private String	name;
	private String	sex;
	boolean	flag = false;
	private static final Resource s = new Resource();
	private Resource(){}
	public static Resource getInstance(){
		return s;
	}

	public synchronized void set(String name,String sex){
		if (this.flag) {
				//	��.wait();(������.wait(),����waitҲ��һ�ּ���������)
			try{this.wait();}catch(InterruptedException e){}
		}
		this.name = name;
		this.sex  = sex;
		this.flag = true;
		this.notify();
	}
	public synchronized void outInfo(){
		if (!this.flag){
			try{this.wait();}catch(Exception e){}
		}
		System.out.println(this.name+" # "+this.sex);
		this.flag = false;
		this.notify();
	}

}

class Input implements Runnable{
	Resource r = Resource.getInstance();
    public void run(){
		int	x	=	0;
		while (true) {
			if (0 == x) {
				r.set("����","��");
			}
			else {
				r.set("����","Ů****");
			}
			x = (x+1)%2;
		}
	}
}

class Output implements Runnable{
	Resource r = Resource.getInstance();
    public void run(){
		while (true) {
			r.outInfo();
		}
	}
}

class  ResourceDemo
{
	public static void main(String[] args) 
	{
		Input	in	=	new Input();
		Output	out	=	new	Output();

		Thread	t1	=	new	Thread(in);
		Thread	t2	=	new	Thread(out);

		t1.start();
		t2.start();
	}
}
