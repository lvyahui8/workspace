package dj.charstream.demo;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		FileReader fr = null;
		
		try {
			fr = new FileReader("demo.txt");
			char buffer1[] = new char[255];
			int count = fr.read(buffer1);
			System.out.println(new String(buffer1,0,count));
			System.out.println(count);
			char buffer2[] = new char[255];
			fr.read(buffer2,5,6);
			System.out.println(buffer2);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
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
