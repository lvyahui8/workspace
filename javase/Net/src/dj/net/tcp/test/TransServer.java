package dj.net.tcp.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������

		/*
		 * ת�������
		 * 1������severSocket����
		 * 2����ȡsocket����
		 * 3����ȡ����������ȡ�ͻ��˷�����������
		 * 4��д������̨��������ת��
		 * 5����ȡ���������ת����Ľ�����ظ��ͻ���
		 * 
		 */
		
		ServerSocket ss = new ServerSocket(10000);
		
		
		Socket sk   =  ss.accept();
		String ip  = sk.getInetAddress().getHostAddress();
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintWriter pt = new PrintWriter(sk.getOutputStream(),true);
		
		String line = null;
		
		while ((line = bufr.readLine())!=null) {
			//�����ж�Ҳ���˳�������Ϊ�ͻ��˹ر�ʱ��ֲ��-1��readLine�᷵��null
//			if(line.equals("over")){
//				break;
//			}
			System.out.println(ip+":"+line);
			pt.println(line.toUpperCase());
		}
		sk.close();
		ss.close();
	}

}
