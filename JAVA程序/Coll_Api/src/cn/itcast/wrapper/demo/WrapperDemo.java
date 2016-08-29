package cn.itcast.wrapper.demo;

public class WrapperDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*
		 * 基本数据类型封装
		 * 为了操作基本数据类型
		 * byte		Byte
		 * short	Short
		 * int		Integer
		 * long		Long
		 * float	Float
		 * double	Double
		 * char		Character
		 * boolean	Boolean
		 * 
		 * 基本数据类型和字符串之间的转换
		 * 
		 * 基本类型------>字符串
		 * 		1、基本数据类型+string
		 * 		2、用String类中的静态方法 valueOf(基本数据类型);
		 * 
		 * 字符串--------->基本类型
		 * 		1、使用包装类的静态方法，xxx  parseXxx("xxx类型字符串");
		 * 			int parseInt("int string");
		 * 			long parseLong("long string");
		 * 			boolean parseBoolean("booleanString");
		 * 			只有    Character没有parse方法
		 * 
		 * 		2、如果字符串被Integer进行了封装
		 * 			可以使用另一个非静态方法
		 * 			将一个Integer对象转换成基本数据类型
		 *  
		 * 
		 */
		
//		int num ;
		System.out.println(Integer.MAX_VALUE+"...."+Integer.MIN_VALUE);
//		num = 10;
		System.out.println(Integer.toBinaryString(-6));
		int var = Integer.parseInt("123"+1);
		System.out.println(var);
//		var = Integer.parseInt("123abc");	// 该方法抛了运行时异常，本可以不抛，但还是希望调用者注意一下，所以还是抛了
//		System.out.println(var);
		
		Integer	i	=	new Integer("123");
		System.out.println(i.intValue());
		
		/*
		 * 整数具备不同的进制体现
		 * 
		 * 十进制----->其他进制
		 * 
		 * 其他进制------>十进制
		 * 
		 */
		
		//	十进制---->其他进制
		System.out.println(Integer.toBinaryString(60));
		System.out.println(Integer.toOctalString(60));
		System.out.println(Integer.toHexString(60));
		System.out.println(Integer.toString(60, 16));
		//	其他进制------>十进制
		System.out.println(Integer.parseInt("3c", 16));
		
		Integer a = new Integer(3);
		Integer b = new Integer("3");
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println(a.compareTo(b+1));
		
	}
}
