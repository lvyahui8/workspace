package dj.net.tcp.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class T_UploadClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO 自动生成的方法存根
		Socket sk = new Socket("127.0.0.3", 10001);
		
		//本地字节输入流，读取本地图片文件
		BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream("upload.txt"));
		
		BufferedOutputStream bfOut = new BufferedOutputStream(sk.getOutputStream());
		int len = 0;
		byte buf []  = new byte[1024];
		while ((len = bfIn.read(buf)) != -1) {
			bfOut.write(buf, 0, len);
		}
		bfOut.flush();
		bfIn.close();
		sk.shutdownOutput();
		
		InputStream ins = sk.getInputStream();
		len = ins.read(buf);
		String result = new String(buf,0,len);
		if("OVER".equals(result)){
			System.out.println("上传成功");
		}
		
		sk.close();
	}

}
