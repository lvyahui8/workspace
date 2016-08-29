package dj.regex.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		/*
		 * ������ʽ��������
		 * 
		 * 1��ƥ�� ʹ��String���matchs����
		 * 
		 * 2���и� ʹ��String���split����
		 * 
		 * 3���滻
		 * 
		 * 
		 * 4����ȡ
		 */

		// method_1();
		// method_2();
		// method_3();
		method_4();
	}

	public static void method_4() {
		// TODO �Զ����ɵķ������
		/*
		 * ��ȡ �����������ж���ķ�װ
		 * 
		 * ͨ����������matcher�������ַ������������ȡҪ���ַ�������ż��ƥ��������
		 * 
		 * ͨ��ƥ������������ַ�������
		 */
		String str = "ni hao a wo,ca yi dian yex";
		String regex = "\\b[a-z]{3}\\b";//	���3����ĸ�ĵ���
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		while (m.find()) {
			String sub = m.group();
			System.out.println(sub);
		}
	}

	public static void method_3() {
		// TODO �Զ����ɵķ������
		String str = "zhangdfsdjfiiergffjsrthgjkszz";
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);

		String tel = "13574332344";// "135****2344"
		tel = tel.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
		System.out.println(tel);
	}

	public static void method_2() {
		// TODO �Զ����ɵķ������
		// String str = "192.32.32.43";
		// String regex = "\\.";
		// String str = "nisaf  dsf            sdfsds wert";
		// String regex = " +";
		// String str = "dfhsjhf###jdshfds&&&&&dhsufki";
		// String regex = "#+|&+";
		String str = "sddhfkjshhhhhhiweruweowwwwwwuioerto";
		String regex = "(.)\\1{1,}";// ����()��ʾһ����,\\1�������
		String[] sub = str.split(regex);
		for (String s : sub) {
			System.out.println(s);
		}
	}

	public static void method_1() {
		// TODO �Զ����ɵķ������
		String tel = "13876547832";

		// String regex = "1[358][0-9]{9}";
		String regex = "1[358]\\d{9}";

		boolean b = tel.matches(regex);

		System.out.println(b);
	}

}
