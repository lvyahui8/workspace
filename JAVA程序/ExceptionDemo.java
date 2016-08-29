/*
�쳣�ķ��ࣺ
1������ʱ������쳣��ֻҪ��Exception�������඼�ǣ�������������RuntimeException����ϵ
	����������֣�ϣ���ڱ���ʱ���д���������������Ӧ�Ĵ���ʽ
	�����������������Դ���
	�����쳣��Ҫ��׽��������

2������ʱ������쳣������ʱ�쳣����Exception������ϵRuntimeException��ϵ
	��������ķ������޷��ù��ܼ����������޷����У����������Ϊ�����ߵ�ԭ������µġ�
	��������һ�㲻����	
��ˣ����Զ����쳣ʱ��Ҫô�̳� Exception,Ҫô�̳� RuntimeException

throwsʹ���ں���ͷ����throwʹ���ں�����
throws�׳������쳣�࣬�����׳������throw�׳����쳣�Ķ���
*/


/*
//---------------------------- 1 ------------------------------

class Demo {
    public int method(int [] arr,int index){		//	�������׳��쳣����Ϊ������쳣������ʱ�쳣
		if (null == arr) {
		    throw new NullPointerException("��������ò���Ϊ��");
		}
		if(index>=arr.length){
//			throw new ArrayIndexOutOfBoundsException(index);
//			throw new ArrayIndexOutOfBoundsException("" + index);
			throw new ArrayIndexOutOfBoundsException("����Խ���ˣ�" + index);
		}
		return arr[index];
		//System.out.println(arr[index]);
	}
}

class ExceptionDemo 
{
	public static void main(String[] args) 
	{
		int [] arr = new int[3];
		int num = new Demo().method(arr,3);
	}
}
//------------------------------ 1 --------------------------------
*/
class FuShuIndexException extends Exception {
    FuShuIndexException(){

	}
	FuShuIndexException(String msg){
		super(msg);
	}
}

class ExceptionDemo 
{
	public static void method(int [] arr,int index) throws FuShuIndexException
	{
		if (index<0) {
		    throw new FuShuIndexException("���ָ����Ǳ꣺"+index);	//�����Զ��������쳣��ʱ�򣬱��벶׽���������׳��쳣
		}
		else if(index>=arr.length){
		    throw new ArrayIndexOutOfBoundsException(index);
		}
		System.out.println(arr[index]);
	}
	public static void main(String[] args) throws FuShuIndexException
	{
		int [] arr = new int[3];
		method(arr,-1);
		method(arr,4);
	}
}

/*
//-------------------------------- 3 -----------------------------

abstract class ExcepBase extends Throwable{
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
class ExceptionDemo 
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
			getArrElemt(arr,3);
		}
		catch(ExcepBase e){
			e.showErrInfo();
		}
	}
	public static void getArrElemt(int [] arr,int inDex){
		   if (inDex >= arr.length) {
		       throw new ArrayErr("�����±�Խ��");
		   }
		   System.out.println("array["+inDex+"]="+arr[inDex]);
	}
}
//---------------------------------- 3 -----------------------------------
*/