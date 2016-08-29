package dj.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDemo2 {

	public static void main(String[] args) throws IOException{
		
		//	需求：客户端发送数据到服务端
		/*
		 * Tcp传输，客户端的建立过程
		 * 1、创建tcp客户端socket服务，使用Socket对象
		 * 	建议一创建对象就明确目的地要连接的服务器
		 * 
		 * 2、如果连接建立成功，说明数据传输通道建立
		 * 		该通道就是socket流。它是底层建立好的。说明这里既有输入流又有输出流
		 * 		如果想要获取流对象，可以通过socket的方法
		 * 
		 * 3、使用输出流，将数据写出。
		 * 
		 * 4、关闭资源
		 * 
		 */
		Socket sk = new Socket(InetAddress.getByName("127.0.0.1"),10000);
		
		OutputStream out = sk.getOutputStream();
		
		out.write("nihao".getBytes());
		
		
		InputStream in = sk.getInputStream();
		
		byte buf [] = new byte[1024];
		int len = in.read(buf);
		String str = new String(buf,0,len);
		
		System.out.println(str);
		
		sk.close();
		
	}

}
