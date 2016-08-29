package dj.net.tcp.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class T_UploadServer implements Runnable{
	static int count = 0;
	public T_UploadServer() {
		// TODO 自动生成的构造函数存根
	}
	private Socket sk = null;
	public T_UploadServer(Socket sk) {
		// TODO 自动生成的构造函数存根
		this.sk = sk;
	}
	/**
	 * @param sk
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void upload(Socket sk) throws FileNotFoundException,
			IOException {
		System.out.println("源:"+sk.getInetAddress().getHostAddress());
		//创建本地流
		BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream((count++)+"supload.txt"));
		
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
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			upload(sk);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		ServerSocket ss = new  ServerSocket(10001);
		
		Socket sk = null;
		while(true){
			sk = ss.accept();
			new Thread(new T_UploadServer(sk)).start();
		}
		
	}

}
