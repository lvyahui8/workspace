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
		 * ת���ͻ��ˣ�
		 * 1������socket����ʹ��socket����
		 * 2��ͨ��socket��ȡ�������
		 * 3����ȡ����¼������ݣ�ʹ����������͸�������
		 * 4�����շ���˵����ݣ���������ʾ�ڿ���̨��
		 * 
		 * 5���ر�socket
		 */
		
		
		Socket sk = new Socket("127.0.0.1", 10000);	
		OutputStream out = sk.getOutputStream();								//socket  ��
		PrintWriter pt = new PrintWriter(out,true);								//socket  ��
		InputStream in = sk.getInputStream();									//socket  ��
		BufferedReader buIn = new BufferedReader(new InputStreamReader(in));	//socket  ��
		
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));//������
		
		String line = null;
		while ((line = bufr.readLine())!=null) {
			if (line.equals("over")) {
				break;
			}
			pt.println(line);
			
			String severRuslut = buIn.readLine();//��ȡһ�з���˷��ص�����
			System.out.println(severRuslut);	//������
		}
		
		sk.close();
	}
}
