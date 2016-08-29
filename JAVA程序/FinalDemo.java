class Demo {
    public static int show(int index) throws ArrayIndexOutOfBoundsException{
		if(index<0){
			throw new ArrayIndexOutOfBoundsException("出轨啦");
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
			//System.exit(0);	//退出虚拟机
		}
		*/
		finally {	//	finally 一般用于关闭或者释放资源。
			//	即便在final之前有return执行，也一定会执行。
			//	有一种情况不会执行，就是退出了虚拟机，System.exit(0);
		    System.out.println("final 一般用用户关闭或者释放资源，比如断开数据库的链接");
		}

		//	try final 单独组合， 一般在异常无法直接处理，但是资源必须关闭。
		//	try{开启资源}final{关闭资源}
		//
	}
}
