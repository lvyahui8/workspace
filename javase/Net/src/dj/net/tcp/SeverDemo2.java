package dj.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverDemo2 {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 服务端创建
		 * 1、创建服务端socket 服务，通过ServerSocket对象
		 * 
		 * 2、服务端必须对外提供一个端口，否则客户端无法连接
		 * 
		 * 3、拿到客户端的socket对象
		 * 
		 * 4、使用该对象获得流读取客户端发来的数据
		 * 
		 * 5、关闭资源（要关两个，服务端，客户端）
		 * 
		 */
		
		//1
		ServerSocket ss = new ServerSocket(10000);
		//2
		Socket sk  = ss.accept();
		//3
		InputStream in = sk.getInputStream();
		
		//4
		byte [] buf = new byte[1024];
		
		int len = in.read(buf);
		
		String str = new String(buf,0,len);
		
		System.out.println(sk.getInetAddress()+":"+str);
		
		OutputStream out = sk.getOutputStream();
		out.write("服务端收到了".getBytes());
		
		sk.close();
		ss.close();		
	}
}
