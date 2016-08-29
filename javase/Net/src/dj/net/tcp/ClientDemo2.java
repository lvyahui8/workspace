package dj.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDemo2 {

	public static void main(String[] args) throws IOException{
		
		//	���󣺿ͻ��˷������ݵ������
		/*
		 * Tcp���䣬�ͻ��˵Ľ�������
		 * 1������tcp�ͻ���socket����ʹ��Socket����
		 * 	����һ�����������ȷĿ�ĵ�Ҫ���ӵķ�����
		 * 
		 * 2��������ӽ����ɹ���˵�����ݴ���ͨ������
		 * 		��ͨ������socket�������ǵײ㽨���õġ�˵������������������������
		 * 		�����Ҫ��ȡ�����󣬿���ͨ��socket�ķ���
		 * 
		 * 3��ʹ���������������д����
		 * 
		 * 4���ر���Դ
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
