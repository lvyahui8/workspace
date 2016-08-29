package cn.itcast.String.Demo;

public class StringMethodDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/* 
		 * 按照面向对象的思想对子符串进行功能分类
		 * "abcd"
		 * 一、获取
		 * 1、获取字符串中字符的个数（长度）	int length();
		 * 2、根据位置获取字符				char charAt(int index);
		 * 3、根据字符获取在字符串中的第一次出现的位置	
		 * 		int indexOf(int ch);
		 * 		int indexOf(int ch,int fromIndex);
		 * 		int indexOf(String str);
		 * 		int indexOf(String str,int fromIndex);
		 * 		int lastIndexOf(int ch);	// 从后往前找
		 * 		int lastIndexOf(int ch,int fromIndex);
		 * 		int lastIndexOf(String str);
		 * 		int lastIndexOf(String str,int fromIndex);
		 * 	4、获取字符串中的字串
		 * 		String subString(int beginIndex,int endIndex);
		 * 		String subString(int beginIndex);
		 * 二、
		 * 1、将字符串变成多个子字符串
		 * 		String [] split(String regex);
		 * 2、将字符串变成字符数组
		 * 		char [] toCharArray();
		 * 3、将字符串转换成字节数组
		 * 		byte [] getBytes();
		 * 4、将字符串中的字母转成大小写
		 * 		String toUpperCase():大写
		 * 		String toLowerCase():小写
		 * 5、将字符串中的内容进行替换
		 * 		String replace(char oldChar,char newChar);
		 * 		String replace(String oldStr,String newStr);
		 * 6、将一个字符串两端的空格去掉
		 * 		String trim();
		 * 7、将字符串进行连接。
		 * 		String concat(String str);
		 * 三、判断
		 * 1、两个字符串内容是否相同
		 * 		boolean equals(Object obj);
		 * 		boolean	equalsequalsIgnoreCase(String str);	//忽略大小写比较内容
		 * 2、比较字符串里是否包含某字串
		 * 		boolean contains(String str);
		 * 3、是否以指定字符串开头或结尾
		 * 		boolean startsWith(String str);
		 * 		boolean endsWith(String str);
		 * 四、比较
		 * 1、比较两个字符串大小
		 * 		int compareTo(String str);
		 */
		stringMethodDemo_4();
	}

	private static void stringMethodDemo_4() {
		// TODO 自动生成的方法存根
		System.out.println("abc".compareTo("aqd"));
	}

	private static void stringMethodDemo_3() {
		// TODO 自动生成的方法存根
		String s1 = "abc";
		System.out.println(s1.equals("ABc".toLowerCase()));
		System.out.println(s1.equalsIgnoreCase("ABc"));	//忽略大小写。
		
		System.out.println(s1.contains("cc"));
		String str = "ArrayDemo.java";
		System.out.println(str.startsWith("Array"));
		System.out.println(str.endsWith(".java"));
	}

	private static void stringMethodDemo_2() {
		// TODO 自动生成的方法存根
		String s = "张三,李四,王五";
		String [] arr = s.split(",");	// 这不是普通字符串，而是规则，是正则表达式
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		char [] chs = s.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			System.out.println(chs[i]);
		}
		s = "ab你";
		byte [] bytes = s.getBytes();
		for (int i = 0; i < bytes.length; i++) {
			System.out.println(bytes[i]);
		}
		System.out.println("AbCd".toUpperCase());
		System.out.println("java".replace('a', 'o'));
		String s1 = "java";
		String s2 = s1.replace('q','z');
		System.out.println(s1 == s2);
		System.out.println("-"+"   ab    c ".trim()+"-");
	}

	private static void stringMethodDemo_1() {
		// TODO 自动生成的方法存根
		String s = "abcdefgh";
		System.out.println("length:"+s.length());
		System.out.println("char:"+s.charAt(2));
		System.out.println("index:"+s.indexOf('k'));
		System.out.println("lastIndex"+s.lastIndexOf('d'));
		System.out.println("subString:"+s.substring(2,4));
	
	}

}
