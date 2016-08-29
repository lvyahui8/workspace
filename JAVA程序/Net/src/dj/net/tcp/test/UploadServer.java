package dj.net.tcp.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class UploadServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10000);
		
		Socket sk  =  ss.accept();
		System.out.println("上传者："+sk.getInetAddress().getHostAddress());
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		
		
		BufferedWriter bufw = new  BufferedWriter(new FileWriter("server.txt"));
		
		
		String line = null;
		
//		while ("#OVER".equals((line = bufIn.readLine()))) {
		while((line = bufIn.readLine())!=null){
			bufw.write(line);
			bufw.newLine();
//			bufw.flush();
		}
		bufw.close();
		
		System.out.println("服务器已经接收到文件");
		
		OutputStream out = sk.getOutputStream();
		
		PrintWriter pt = new PrintWriter(out,true);
		pt.println("OK");
		
		sk.close();
		ss.close();
		
		
	}

}
