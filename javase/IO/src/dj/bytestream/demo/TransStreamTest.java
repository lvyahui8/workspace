package dj.bytestream.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TransStreamTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		writeText_1();
	}

	/**
	 * @throws IOException
	 */
	public static void writeText_1() {
		FileWriter fw = null;
		OutputStreamWriter osw = null;
		try {
			fw = new FileWriter("gbk_1.txt");
			fw.write("你好");
			osw = new OutputStreamWriter(new FileOutputStream("gbk_2.txt"));
			osw.write("你好");
			osw.close();
			osw = new OutputStreamWriter(new FileOutputStream("gbk_3.txt"),"GBK");
			osw.write("你好");
			osw.close();
			//	上面三种是相同的，都是使用了默认的GBK编码
			osw = new OutputStreamWriter(new FileOutputStream("utf-8.txt"),"UTF-8");
			osw.write("你好");
			//	这一种使用的是UTF-8 编码
		
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			try {
				fw.close();
				osw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}
