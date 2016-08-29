package cn.itcast.StringBuffer.Demo;

public class StringBufferDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		/*
		 * StringBuffer �����ַ�������
		 * ���ڴ洢���ݵ�������
		 * �ص�
		 * 1.���ȿɱ�
		 * 2.���Դ洢��ͬ���͵�����
		 * 3.
		 * 
		 * ��Ȼ��һ���������󣬣�Ӧ�þ���ʲô����
		 * 1���桢ȡ�ķ���
		 * 		StringBuffer append(data);���
		 * 		StringBuffer insert(int index,data);
		 * 2��ɾ������
		 * 		StringBuffer delete(int start,int end);	
		 * 		StringBuffer deleteCharAt(int index);
		 * 2����ѯ����
		 * 		char charAt(int index);
		 * 		int  indexOf(String str);
		 * 		int lastIndexOf(String str);
		 * 3���滻����
		 * 		StringBuffer replace(int start,int end,String str);
		 *		void setCharAt(int index,char ch);
		 */
		
		bufferMethodDemo_2();
	}

	private static void bufferMethodDemo_2() {
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		StringBuffer sb = new StringBuffer("base");
		sb.insert(2, "qq");
		System.out.println(sb.toString());
	}

	private static void bufferMethodDemo() {
		// TODO �Զ����ɵķ������
		StringBuffer sb = new StringBuffer();
		StringBuffer s1 = sb.append(4);
		sb.append(true);
		sb.append('s').append('v').append(0);	//������
		System.out.println(sb); 
		System.out.println(s1);
		sb.insert(1,'g');
		System.out.println(sb); 
		System.out.println(s1);
		System.out.println(sb == s1);
	
	}   

}
