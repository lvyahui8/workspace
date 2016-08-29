package dj.bytestream.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		// demo_write();
		demo_read();
	}

	private static void demo_read() {
		// TODO �Զ����ɵķ������
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("bytedemo.txt");
			byte[] bs = new byte[fis.available()];//��Ҫ��������Ϊ�������ļ����ܴܺ󡣽���ʹ�ù̶����ȴ�С
			fis.read(bs);
			//int count = fis.read(bs);
			System.out.println(new String(bs));//new String(bs,o,count)
		} catch (IOException e) {
			// TODO: handle exception
		}
		finally{
			if (null!=fis) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			} 
		}
	}

	public static void demo_write() {
		// TODO �Զ����ɵķ������
		// 1����������ֽ�������
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("bytedemo.txt");
			fos.write("abcds".getBytes());// ֱ��д�뵽��Ŀ�ĵ���
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			if (null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
	}

}
