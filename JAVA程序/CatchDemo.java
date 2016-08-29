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
		
//		ExcepBase e = new ArrayErr("数组越界");
//		e.showErrInfo();
		show();
	}

	public static void show(){
		int [] arr = new int[3];
		try{
			//	需要被检测异常的代码块
			getArrElemt(arr,3);
			System.out.println("可能异常的代码块还在继续执行");
			getArrElemt(arr,4);
		}
		catch(ExcepBase e){
			//	处理异常的代码
			e.showErrInfo();
		}
		finally{
			//	一定会被执行的代码块
			System.out.println("finally 代码块被调用");
		}

		System.out.println("程序继续运行");
	}
	public static void getArrElemt(int [] arr,int inDex)throws ExcepBase{
		   if (inDex >= arr.length) {
		       throw new ArrayErr("数组下标越界");
		   }
		   System.out.println("array["+inDex+"]="+arr[inDex]);
	}
}