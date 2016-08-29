package dj.charstream.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		demo_1();
		FileReader fr = null;
		BufferedReader bufr = null;
		
		try {
			fr = new FileReader("line.txt");
			bufr = new BufferedReader(fr);
			String buf;
			while ((buf = bufr.readLine())!=null) {
				System.out.println(buf);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			if (null != bufr) {
				try {
					bufr.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * 
	 */
	public static void demo_1() {
		FileReader fr = null;

		try {
			fr = new FileReader("buf.txt");
			char[] buf = new char[255];
			int len = 0;
			while ((len = fr.read(buf)) != -1) {
				System.out.println(new String(buf, 0, len));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			if (null != fr) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}

}
