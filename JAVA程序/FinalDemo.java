class Demo {
    public static int show(int index) throws ArrayIndexOutOfBoundsException{
		if(index<0){
			throw new ArrayIndexOutOfBoundsException("������");
		}
		int [] arr = new int[3];
		return arr[index];
	}
}
class FinalDemo 
{
	public static void main(String[] args) 
	{
		try {
		    System.out.println(Demo.show(-1));
		}
		/*
		catch (ArrayIndexOutOfBoundsException e) {
		    e.printStackTrace();
			return ;
			//System.exit(0);	//�˳������
		}
		*/
		finally {	//	finally һ�����ڹرջ����ͷ���Դ��
			//	������final֮ǰ��returnִ�У�Ҳһ����ִ�С�
			//	��һ���������ִ�У������˳����������System.exit(0);
		    System.out.println("final һ�����û��رջ����ͷ���Դ������Ͽ����ݿ������");
		}

		//	try final ������ϣ� һ�����쳣�޷�ֱ�Ӵ���������Դ����رա�
		//	try{������Դ}final{�ر���Դ}
		//
	}
}
