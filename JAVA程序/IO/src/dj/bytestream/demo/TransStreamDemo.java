package dj.bytestream.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TransStreamDemo {
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		//	字符流
		runCar(System.in, System.out);											//从控制台读取内容输出到控制台上
		runCar(System.in,new FileOutputStream("a.txt"));						//从控制台读取内容写入到文件a.txt
		runCar(new FileInputStream("a.txt"),new FileOutputStream("b.txt"));		//从文件a.txt读内容写到文件b.txt
		runCar(new FileInputStream("a.txt"),System.out);						//从文件a.txt读内容写到控制台
		//		这里还必须new两次a.txt，相当于刷新文件指针，让它重新指到文件头
	}

	/**
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static void runCar(InputStream in, OutputStream out)
			throws IOException {
		//	将字节流转换成字符的桥梁，转换流
		InputStreamReader isr = new  InputStreamReader(in);
		
		//	装饰转换之后的字符流
		BufferedReader bufr = new BufferedReader(isr);
		//	字节流
		OutputStreamWriter opsw = new OutputStreamWriter(out);
		
		BufferedWriter bufw = new BufferedWriter(opsw);
		String line= null;
		while ((line = bufr.readLine()) != null) {
			if (line.equals("over")) {
				break;
			}
//			System.out.println(line.toUpperCase());
//			opsw.write(line.toUpperCase()+"\r\n");
//			opsw.flush();
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
	}

}
