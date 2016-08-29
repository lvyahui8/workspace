package dj.net.tcp.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServer {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		ServerSocket ss = new  ServerSocket(10001);
		
		Socket sk = ss.accept();
		System.out.println("源:"+sk.getInetAddress().getHostAddress());
		//创建本地流
		BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream("supload.txt"));
		
		//获取socket流
		BufferedInputStream bfIn = new BufferedInputStream(sk.getInputStream());
		
		int len = 0 ;
		byte [] buf = new byte[1024];
		
		while ((len = bfIn.read(buf))!=-1) {
			bfOut.write(buf, 0, len);
			bfOut.flush();
		}
		
		bfOut.close();
		
		//回馈客户端
		OutputStream ops = sk.getOutputStream();
		
		ops.write("OVER".getBytes());
		
		sk.close();
		ss.close();
		
	}

}
