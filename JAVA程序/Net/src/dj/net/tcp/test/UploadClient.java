package dj.net.tcp.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class UploadClient {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		// TODO 自动生成的方法存根
				Socket sk = new Socket("127.0.0.1", 10000);

				BufferedReader bufr = new BufferedReader(new FileReader("upload.txt"));
				
				PrintWriter pt = new PrintWriter(sk.getOutputStream(),true);
				
				String line = null;
				
				while((line = bufr.readLine())!=null){
					pt.println(line);
				}
				System.out.println("文件已发往服务器");
				
//				pt.println("#OVER");
				sk.shutdownOutput();//告诉服务端，结束了
				bufr.close();
				
				
				//验证上传是否成功
				
				BufferedReader bufIn = new BufferedReader(new InputStreamReader(sk.getInputStream()));
				String str = bufIn.readLine();
				
				if("OK".equals(str)){
					System.out.println("上传成功");
				}
				
				sk.close();
	}

}
