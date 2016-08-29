package dj.net.tcp.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TransClient {
	public static void main(String [] sr) throws UnknownHostException, IOException{
		/*
		 * 转换客户端：
		 * 1、建立socket服务，使用socket对象
		 * 2、通过socket获取输出流。
		 * 3、读取键盘录入的数据，使用输出流发送给服务器
		 * 4、接收服务端的数据，将数据显示在控制台上
		 * 
		 * 5、关闭socket
		 */
		
		
		Socket sk = new Socket("127.0.0.1", 10000);	
		OutputStream out = sk.getOutputStream();								//socket  流
		PrintWriter pt = new PrintWriter(out,true);								//socket  流
		InputStream in = sk.getInputStream();									//socket  流
		BufferedReader buIn = new BufferedReader(new InputStreamReader(in));	//socket  流
		
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));//本地流
		
		String line = null;
		while ((line = bufr.readLine())!=null) {
			if (line.equals("over")) {
				break;
			}
			pt.println(line);
			
			String severRuslut = buIn.readLine();//读取一行服务端发回的数据
			System.out.println(severRuslut);	//输出结果
		}
		
		sk.close();
	}
}
