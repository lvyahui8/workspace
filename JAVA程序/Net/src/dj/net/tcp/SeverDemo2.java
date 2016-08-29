package dj.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverDemo2 {

	public static void main(String[] args) throws IOException {
		
		/*
		 * ����˴���
		 * 1�����������socket ����ͨ��ServerSocket����
		 * 
		 * 2������˱�������ṩһ���˿ڣ�����ͻ����޷�����
		 * 
		 * 3���õ��ͻ��˵�socket����
		 * 
		 * 4��ʹ�øö���������ȡ�ͻ��˷���������
		 * 
		 * 5���ر���Դ��Ҫ������������ˣ��ͻ��ˣ�
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
		out.write("������յ���".getBytes());
		
		sk.close();
		ss.close();		
	}
}
