package cn.itcast.String.Demo;

public class StringMethodDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		/* 
		 * ������������˼����ӷ������й��ܷ���
		 * "abcd"
		 * һ����ȡ
		 * 1����ȡ�ַ������ַ��ĸ��������ȣ�	int length();
		 * 2������λ�û�ȡ�ַ�				char charAt(int index);
		 * 3�������ַ���ȡ���ַ����еĵ�һ�γ��ֵ�λ��	
		 * 		int indexOf(int ch);
		 * 		int indexOf(int ch,int fromIndex);
		 * 		int indexOf(String str);
		 * 		int indexOf(String str,int fromIndex);
		 * 		int lastIndexOf(int ch);	// �Ӻ���ǰ��
		 * 		int lastIndexOf(int ch,int fromIndex);
		 * 		int lastIndexOf(String str);
		 * 		int lastIndexOf(String str,int fromIndex);
		 * 	4����ȡ�ַ����е��ִ�
		 * 		String subString(int beginIndex,int endIndex);
		 * 		String subString(int beginIndex);
		 * ����
		 * 1�����ַ�����ɶ�����ַ���
		 * 		String [] split(String regex);
		 * 2�����ַ�������ַ�����
		 * 		char [] toCharArray();
		 * 3�����ַ���ת�����ֽ�����
		 * 		byte [] getBytes();
		 * 4�����ַ����е���ĸת�ɴ�Сд
		 * 		String toUpperCase():��д
		 * 		String toLowerCase():Сд
		 * 5�����ַ����е����ݽ����滻
		 * 		String replace(char oldChar,char newChar);
		 * 		String replace(String oldStr,String newStr);
		 * 6����һ���ַ������˵Ŀո�ȥ��
		 * 		String trim();
		 * 7�����ַ����������ӡ�
		 * 		String concat(String str);
		 * �����ж�
		 * 1�������ַ��������Ƿ���ͬ
		 * 		boolean equals(Object obj);
		 * 		boolean	equalsequalsIgnoreCase(String str);	//���Դ�Сд�Ƚ�����
		 * 2���Ƚ��ַ������Ƿ����ĳ�ִ�
		 * 		boolean contains(String str);
		 * 3���Ƿ���ָ���ַ�����ͷ���β
		 * 		boolean startsWith(String str);
		 * 		boolean endsWith(String str);
		 * �ġ��Ƚ�
		 * 1���Ƚ������ַ�����С
		 * 		int compareTo(String str);
		 */
		stringMethodDemo_4();
	}

	private static void stringMethodDemo_4() {
		// TODO �Զ����ɵķ������
		System.out.println("abc".compareTo("aqd"));
	}

	private static void stringMethodDemo_3() {
		// TODO �Զ����ɵķ������
		String s1 = "abc";
		System.out.println(s1.equals("ABc".toLowerCase()));
		System.out.println(s1.equalsIgnoreCase("ABc"));	//���Դ�Сд��
		
		System.out.println(s1.contains("cc"));
		String str = "ArrayDemo.java";
		System.out.println(str.startsWith("Array"));
		System.out.println(str.endsWith(".java"));
	}

	private static void stringMethodDemo_2() {
		// TODO �Զ����ɵķ������
		String s = "����,����,����";
		String [] arr = s.split(",");	// �ⲻ����ͨ�ַ��������ǹ�����������ʽ
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		char [] chs = s.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			System.out.println(chs[i]);
		}
		s = "ab��";
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
		// TODO �Զ����ɵķ������
		String s = "abcdefgh";
		System.out.println("length:"+s.length());
		System.out.println("char:"+s.charAt(2));
		System.out.println("index:"+s.indexOf('k'));
		System.out.println("lastIndex"+s.lastIndexOf('d'));
		System.out.println("subString:"+s.substring(2,4));
	
	}

}
