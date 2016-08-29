/**
文档注释：
你好啊
注意定21行与31行的区别
*/
public class Demo 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello WDS!");
		byte	b = 3;
		short	s = 4;
		int		i = 5;
		long	l = 6;
		float	f = 2.3f;	//必须指明字面类型，或者进行显示强制转换。默认是双精度的
		System.out.println(b);
		// java能够自动提升变量到更高类型，但不能降低，降低需要显示强制转换
		char	charVar = 'h';
		short	shortVar = 3;
		byte	byteVar = 2;
		//short	shortResult = shortVar + byteVar;	// short和byte都会被提升为int
		int		intVar = 4;
		// char 与 short或byte进行算术运算时。首先char会提升为int所以最后表达式的值会是int类型,s所以是不能赋值给short
		//short	shortResult = shortVar + charVar;
		int		intResult = shortVar + charVar;
		System.out.println("intResult = shortVar + charVar = "+intResult);
		long	longVar = 6;
		long	longResult = intVar + longVar;
		float	floatResult1 = intVar + longVar;
		float	floatResult2 = floatResult1 + intVar + longVar;
		System.out.println("intVar = "+intVar+'\n'+"longVar = "+longVar);
		System.out.println("longResult = intVar + longVar = "+longResult);
		System.out.println("floatResult1 = intVar + longVar = "+floatResult1);
		System.out.println("floatResult2 = floatResult1 + intVar + longVar = "+floatResult2);
		// 定义数组两种方式。1、使用new关键字分配内存 2、直接初始化分配内存
		String [] name = new String[3];
		System.out.println(name[0]); 
		System.out.println(name[1]);
		System.out.println(name[2]);
		int [][]score = {		//与C\C++程序设计不同，第二维长度也可以不指定
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		char	ch = '你';
		System.out.println(score[1][1]);
		System.out.println(ch);
		short	sv=32767;	// 最大存到 2^15-1；如果初始化为2^15编译报错
		sv+=1;	// 很明显这里会溢出
		System.out.println(sv);
		System.out.println(8 >> 2);
		System.out.println(8 << 2);
		System.out.println(8 & 2);
		System.out.println(8 | 2);
		System.out.println(8 ^ 2);
		System.out.println(~8);
		String [] str = new String[]{"nihao","wohao"};
		//System.out.println(str[0]);
		//System.out.println(str[1]);
		//System.out.println(str[2]);
		int [] aa,bb = new int[3];
		aa = null;
		bb[0] = 0;
		bb[1] = 1;
		bb[2] = 2;
		System.out.println(aa);
		System.out.println(bb.toString());
		for(int ii=0;ii<bb.length;ii++){
			System.out.println(bb[ii]);
		}
	}
}
