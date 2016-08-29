package cn.itcast.String.Demo;

public class StringMaxSub {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str1 = "abcdefghijk";
		String str2 = "yyabcdehijk";
		String maxSubStr = getMaxSameSub(str1, str2);
		System.out.println(maxSubStr);
	}

	private static String getMaxSameSub(String str1, String str2) {
		// TODO 自动生成的方法存根
		int str1Length = str1.length();
		int str2Length = str2.length();
		int length = str1Length < str2Length ? str1Length : str2Length;
		String subStr = null;
		if (str1Length < str2Length) {
			String temp = str1;
			str1 = str2;
			str2 = temp;
		}
		for (int i = length, n = 1; i > 0; i--, n++) {
			for (int j = 0; j < n; j++) {
				subStr = str2.substring(j, j + i);
				if (-1 != str1.indexOf(subStr)) {
					return subStr;
				}
			}
		}
		return subStr;
	}
}
