/*
 * String 特点不可变（所以不用考虑多线程是否安全的问题）。虽然可以进行增删改，但实际是将引用指向另一个对象
 * 		String 对象的两种定义方式
 * 		1、String str = "XXXXXXX";
 * 				这一种是字符串常量池中找内容的字符串对象，如果有直接将引用str指向它，没有则现在常量池中生成
 * 		2、String str = new String("XXXXXXX");
 * 				这一种方式是在堆上产生字符串对象，内容自己封装，自己维护，不在字符串常量池中
 * 
 * 
 * StringBuilder 和    StringBuffer
 * 		相同点：内部维护了一个字符数组，长度可变
 * 		不同点：前者线程不安全，效率略高，适合单线程。后者线程安全（使用了同步），效率略低，适合多线程
 * 
 * 
 * 下面的测试程序显示了两者的区别
 * 
 * 测试程序使用两个插入线程对同一个对象执行插入操作
 * 运行结果显示：
 * 多次插入后，前者出现长度字段与实际字符串长度不同的问题，而后者没有
 */
package work01;

/**
 * StringTest测试StringBulder 和 StringBuffer 的区别
 * @author Agrin
 *
 */
public class StringTest {
	
//	StringBuilder sb = new StringBuilder();
	StringBuffer sb = new StringBuffer();
	private static long WAIT_TIME = 20;//毫秒  一般为计算机线程切换的时间 

	class Inserter implements Runnable{
		String str = null;
		public Inserter(String str){
			this.str = str;
		}
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(WAIT_TIME);///   1394360789497 -  1394360789373  == 124 ms
					sb.insert(0, str);
					System.out.println(sb);
				} catch (InterruptedException e) {//Interrupted
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
	

	public void inserter(String str){
		new Thread(new Inserter(str)).start();
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		StringTest st = new StringTest();
		st.inserter("-");
		st.inserter("-");
	}

}
