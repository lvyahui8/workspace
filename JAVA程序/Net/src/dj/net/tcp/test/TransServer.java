package dj.net.tcp.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根

		/*
		 * 转换服务端
		 * 1、建立severSocket服务
		 * 2、获取socket对象
		 * 3、获取输入流，读取客户端发过来的数据
		 * 4、写到控制台，并进行转换
		 * 5、获取输出流，将转换后的结果发回给客户端
		 * 
		 */
		
		ServerSocket ss = new ServerSocket(10000);
		
		
		Socket sk   =  ss.accept();
		String ip  = sk.getInetAddress().getHostAddress();
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintWriter pt = new PrintWriter(sk.getOutputStream(),true);
		
		String line = null;
		
		while ((line = bufr.readLine())!=null) {
			//不用判断也能退出，是因为客户端关闭时会植入-1，readLine会返回null
//			if(line.equals("over")){
//				break;
//			}
			System.out.println(ip+":"+line);
			pt.println(line.toUpperCase());
		}
		sk.close();
		ss.close();
	}

}
