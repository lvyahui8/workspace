package cn.itcast.String.Demo;

public class StringTrim {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String str = "    Abc    HJK   ";
		String newStr = strTrim(str);
		System.out.println("newStr="+newStr);
	}

	private static String strTrim(String str) {
		// TODO �Զ����ɵķ������
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
