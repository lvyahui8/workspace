package cn.itcast.StringBuffer.Demo;

public class StringBufferDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*
		 * StringBuffer 就是字符缓冲区
		 * 用于存储数据的容器。
		 * 特点
		 * 1.长度可变
		 * 2.可以存储不同类型的数据
		 * 3.
		 * 
		 * 既然是一个容器对象，；应该具有什么方法
		 * 1、存、取的方法
		 * 		StringBuffer append(data);添加
		 * 		StringBuffer insert(int index,data);
		 * 2、删除功能
		 * 		StringBuffer delete(int start,int end);	
		 * 		StringBuffer deleteCharAt(int index);
		 * 2、查询功能
		 * 		char charAt(int index);
		 * 		int  indexOf(String str);
		 * 		int lastIndexOf(String str);
		 * 3、替换功能
		 * 		StringBuffer replace(int start,int end,String str);
		 *		void setCharAt(int index,char ch);
		 */
		
		bufferMethodDemo_2();
	}

	private static void bufferMethodDemo_2() {
		// TODO 自动生成的方法存根
		StringBuffer sb = new StringBuffer("abcde");
//		sb.delete(1, 3);
//		System.out.println(sb);
//		sb.delete(0,sb.length());
//		System.out.println(sb);
		sb.setLength(20);
		sb.replace(1, 2, "nba");
		System.out.println(sb);
		
	}

	private static void bufferMethodDemo_1() {
		// TODO 自动生成的方法存根
		StringBuffer sb = new StringBuffer("base");
		sb.insert(2, "qq");
		System.out.println(sb.toString());
	}

	private static void bufferMethodDemo() {
		// TODO 自动生成的方法存根
		StringBuffer sb = new StringBuffer();
		StringBuffer s1 = sb.append(4);
		sb.append(true);
		sb.append('s').append('v').append(0);	//方法链
		System.out.println(sb); 
		System.out.println(s1);
		sb.insert(1,'g');
		System.out.println(sb); 
		System.out.println(s1);
		System.out.println(sb == s1);
	
	}   

}
