package cn.itcast.String.Demo;

public class StringSubCount {

	public static void main(String[] args) {
		String mainStr = "abcdfiabckacbbaabc";
		String sub = "abc";
		System.out.println("count="+getSubCount(mainStr,sub));
		System.out.println("mainStr="+mainStr);
		
	}

	private static int getSubCount(String mainStr, String sub) {
		// TODO �Զ����ɵķ������
		String currentStr = mainStr;
		int count = 0;
		int index=0;
		while ((index = currentStr.indexOf(sub,index)) != -1) {
			count++;
			index += sub.length();
			//currentStr = currentStr.substring(index+sub.length());
		}
		return count;
	}

}
