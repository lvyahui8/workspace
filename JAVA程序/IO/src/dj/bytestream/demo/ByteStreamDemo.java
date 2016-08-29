package dj.bytestream.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		// demo_write();
		demo_read();
	}

	private static void demo_read() {
		// TODO 自动生成的方法存根
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("bytedemo.txt");
			byte[] bs = new byte[fis.available()];//不要这样，因为关联的文件可能很大。建议使用固定长度大小
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
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			} 
		}
	}

	public static void demo_write() {
		// TODO 自动生成的方法存根
		// 1、创建输出字节流对象
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("bytedemo.txt");
			fos.write("abcds".getBytes());// 直接写入到了目的地中
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			if (null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}

}
