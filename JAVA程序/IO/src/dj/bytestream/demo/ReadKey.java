package dj.bytestream.demo;

//import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.PrintStream;

public class ReadKey {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		readKey();
		readKey2();
				
	}

	private static void readKey2() {
		// TODO 自动生成的方法存根
		InputStream in = System.in;
		StringBuilder sb = new StringBuilder();
		try {
			int ch = 0;
			while ((ch = in.read()) != -1) {
				if('\r'==ch) {
					continue;
				}
				if('\n' == ch){
					String str = sb.toString();
					if (str.equals("over")) {
						break;
					}
					else{
						System.out.println(str.toUpperCase());
						sb.delete(0, sb.length());
//						Console.flush();
//						System.console().flush();
					}
				}
				else
					sb.append((char)ch);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	@SuppressWarnings("unused")
	private static void readKey() {
		// TODO 自动生成的方法存根
		byte [] buffer = new byte[255];
		try {
			int len = System.in.read(buffer);
			System.out.println(new String(buffer,0,len));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
