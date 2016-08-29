package dj.regex.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*
		 * 正则表达式常见操作
		 * 
		 * 1、匹配 使用String类的matchs方法
		 * 
		 * 2、切割 使用String类的split方法
		 * 
		 * 3、替换
		 * 
		 * 
		 * 4、获取
		 */

		// method_1();
		// method_2();
		// method_3();
		method_4();
	}

	public static void method_4() {
		// TODO 自动生成的方法存根
		/*
		 * 获取 将正则规则进行对象的封装
		 * 
		 * 通过正则对象的matcher方法与字符串想关联，获取要对字符串曹组偶的匹配器对象
		 * 
		 * 通过匹配器对象进行字符串操作
		 */
		String str = "ni hao a wo,ca yi dian yex";
		String regex = "\\b[a-z]{3}\\b";//	获得3个字母的单词
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		while (m.find()) {
			String sub = m.group();
			System.out.println(sub);
		}
	}

	public static void method_3() {
		// TODO 自动生成的方法存根
		String str = "zhangdfsdjfiiergffjsrthgjkszz";
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);

		String tel = "13574332344";// "135****2344"
		tel = tel.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
		System.out.println(tel);
	}

	public static void method_2() {
		// TODO 自动生成的方法存根
		// String str = "192.32.32.43";
		// String regex = "\\.";
		// String str = "nisaf  dsf            sdfsds wert";
		// String regex = " +";
		// String str = "dfhsjhf###jdshfds&&&&&dhsufki";
		// String regex = "#+|&+";
		String str = "sddhfkjshhhhhhiweruweowwwwwwuioerto";
		String regex = "(.)\\1{1,}";// 扩好()表示一个组,\\1代表组号
		String[] sub = str.split(regex);
		for (String s : sub) {
			System.out.println(s);
		}
	}

	public static void method_1() {
		// TODO 自动生成的方法存根
		String tel = "13876547832";

		// String regex = "1[358][0-9]{9}";
		String regex = "1[358]\\d{9}";

		boolean b = tel.matches(regex);

		System.out.println(b);
	}

}
