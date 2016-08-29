package dj.encode.demo;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO 自动生成的方法存根
		String str = "你好";
		
		byte [] buf = str.getBytes();//默认就是GBK编码
//		byte [] buf = str.getBytes("GBK");
		
		print(buf);
		
		//解码
		
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
