abstract class ExcepBase extends Exception{ //Runtime
	private String errInfo = null;
	public ExcepBase(String errInfo){
		this.errInfo = errInfo;
	}
	protected String getInfo(){
		return errInfo;
	}
    abstract public void showErrInfo();
}

class ArrayErr extends ExcepBase {
    public ArrayErr(String errInfo){
		super(errInfo);
	}
	public void showErrInfo(){
		System.out.println("Error:"+getInfo());
	}
}

class CatchDemo 
{
	public static void main(String[] args) 
	{
		//int [] arr = new int[3];
		//arr = null;
		//System.out.println("arr[3]="+arr[3]);
		
//		ExcepBase e = new ArrayErr("����Խ��");
//		e.showErrInfo();
		show();
	}

	public static void show(){
		int [] arr = new int[3];
		try{
			//	��Ҫ������쳣�Ĵ����
			getArrElemt(arr,3);
			System.out.println("�����쳣�Ĵ���黹�ڼ���ִ��");
			getArrElemt(arr,4);
		}
		catch(ExcepBase e){
			//	�����쳣�Ĵ���
			e.showErrInfo();
		}
		finally{
			//	һ���ᱻִ�еĴ����
			System.out.println("finally ����鱻����");
		}

		System.out.println("�����������");
	}
	public static void getArrElemt(int [] arr,int inDex)throws ExcepBase{
		   if (inDex >= arr.length) {
		       throw new ArrayErr("�����±�Խ��");
		   }
		   System.out.println("array["+inDex+"]="+arr[inDex]);
	}
}