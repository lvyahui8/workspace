//	����ʽ������ģʽ
class Single {
    private static final Single s = new Single();
	private Single(){}
	public static Single getInstance(){
		return s;
	}
}
//	����ʽ���ӳټ��ص���ģʽ
class Single {
    private static Single s = null;

	private Single(){}

	public static  Single getInstance(){
		if (null == s) {			//	��һ���ж���Ϊ�����Ч������
		    synchronized (Single.class){	//	������Ϊ�˽���̰߳�ȫ����
				if (null == s) {			
					s = new Single();
				}
			}
		}
		return s;
	}
}

class SingleDemo 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
