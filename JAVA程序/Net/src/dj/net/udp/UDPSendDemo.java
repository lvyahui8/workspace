package dj.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSendDemo {

	public static void main(String[] args) throws IOException {
		System.out.println("���Ͷ�����");
		// TODO �Զ����ɵķ������
		/*
		 * ����udp����ķ��Ͷ�
		 * ˼·��
		 * 1������udp��socket����
		 * 2����Ҫ���͵����ݷ�װ�����ݰ���
		 * 3��ͨ��udp��socket�������ݰ����ͳ�ȥ
		 * 4���ر�socket����
		 */
		//	1��udpsocket����ʹ��DatagramSocket
		DatagramSocket ds = new DatagramSocket();
		
		//	2��װ���ݰ�
		String str = "12334234";
		DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("127.0.0.1"), 10000);
		
		//	3�������ݰ����ͳ�ȥ
		
		ds.send(dp);
		
		ds.close();
	}

}
