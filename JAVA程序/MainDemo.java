class MainDemo 
{
	// 主函数唯一可变的是形参名字
	public static void main(String[] args) 
	{
		///*
		System.out.println("args="+args);
		//System.out.println("args[0]="+args[0]);
		for (int i=0;i<args.length ;i++ ) {
		    System.out.println("args["+i+"]="+args[i]);
		}
		//*/
	}
	// 主函数名可以被重载，但不能有歧义（出现两个入口）
	public static void main(int []x){
	
	}
}
