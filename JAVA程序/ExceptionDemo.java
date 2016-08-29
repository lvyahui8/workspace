/*
异常的分类：
1，编译时被检测异常：只要是Exception和其子类都是，除了特殊子类RuntimeException子体系
	这种问题出现，希望在编译时进行处理，这种问题有相应的处理方式
	这样的问题可以针对性处理
	这种异常需要捕捉或者声明

2，编译时不检测异常（运行时异常）：Exception的子体系RuntimeException体系
	这种问题的发生，无法让功能继续，运算无法进行，更多的是因为调用者的原因而导致的。
	这种问题一般不处理	
因此，在自定义异常时，要么继承 Exception,要么继承 RuntimeException

throws使用在函数头部，throw使用在函数体
throws抛出的是异常类，可以抛出多个，throw抛出的异常的对象
*/


/*
//---------------------------- 1 ------------------------------

class Demo {
    public int method(int [] arr,int index){		//	不声明抛出异常，因为里面的异常是运行时异常
		if (null == arr) {
		    throw new NullPointerException("数组的引用不能为空");
		}
		if(index>=arr.length){
//			throw new ArrayIndexOutOfBoundsException(index);
//			throw new ArrayIndexOutOfBoundsException("" + index);
			throw new ArrayIndexOutOfBoundsException("数组越界了：" + index);
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
		    throw new FuShuIndexException("出现负数角标："+index);	//当有自定义类型异常的时候，必须捕捉或者向上抛出异常
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
		
//		ExcepBase e = new ArrayErr("数组越界");
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
		       throw new ArrayErr("数组下标越界");
		   }
		   System.out.println("array["+inDex+"]="+arr[inDex]);
	}
}
//---------------------------------- 3 -----------------------------------
*/