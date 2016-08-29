package cn.itcast.String.Demo;

public class StringTrim {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str = "    Abc    HJK   ";
		String newStr = strTrim(str);
		System.out.println("newStr="+newStr);
	}

	private static String strTrim(String str) {
		// TODO 自动生成的方法存根
		int start = 0,end = str.length()-1;
		while( start <= end && str.charAt(start) == ' '){
			start++;
		}
		while( end >= start && str.charAt(end) == ' '){
			end--;
		}
		return str.substring(start,end+1);
	}

}
