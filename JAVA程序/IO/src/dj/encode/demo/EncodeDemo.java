package dj.encode.demo;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO �Զ����ɵķ������
		String str = "���";
		
		byte [] buf = str.getBytes();//Ĭ�Ͼ���GBK����
//		byte [] buf = str.getBytes("GBK");
		
		print(buf);
		
		//����
		
		String str2 = new String(buf);
		System.out.println(str2);
	}

	/**
	 * @param buf
	 */
	public static void print(byte[] buf) {
		for (int i = 0; i < buf.length; i++) {
			byte b = buf[i];
			System.out.print(b+" ");
		}
		System.out.println("");
	}

}
