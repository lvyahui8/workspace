package dj.net.tcp.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class UploadClient {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		// TODO �Զ����ɵķ������
				Socket sk = new Socket("127.0.0.1", 10000);

				BufferedReader bufr = new BufferedReader(new FileReader("upload.txt"));
				
				PrintWriter pt = new PrintWriter(sk.getOutputStream(),true);
				
				String line = null;
				
				while((line = bufr.readLine())!=null){
					pt.println(line);
				}
				System.out.println("�ļ��ѷ���������");
				
//				pt.println("#OVER");
				sk.shutdownOutput();//���߷���ˣ�������
				bufr.close();
				
				
				//��֤�ϴ��Ƿ�ɹ�
				
				BufferedReader bufIn = new BufferedReader(new InputStreamReader(sk.getInputStream()));
				String str = bufIn.readLine();
				
				if("OK".equals(str)){
					System.out.println("�ϴ��ɹ�");
				}
				
				sk.close();
	}

}
