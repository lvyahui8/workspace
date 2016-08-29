package dj.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class UDPSendDemo2 {

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
		send();
	}

	/**
	 * @throws SocketException
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	private static void send() throws SocketException, UnknownHostException,
			IOException {
		DatagramSocket ds = new DatagramSocket();
		
		//	2��װ���ݰ�
//		String str = JOptionPane.showInputDialog("��������Ҫ�͵�");
		String str = null;
		byte [] buf = new byte[255];
		
		
		
		//	3�������ݰ����ͳ�ȥ
		
		while (true) {
			int len = System.in.read(buf);
			str = new String(buf, 0, len-2);
			DatagramPacket dp = new DatagramPacket(str.getBytes(),
					str.length(), InetAddress.getByName("127.0.0.1"), 10000);
			ds.send(dp);
			if(str.equals("over")){
				ds.close();
				break;
			}
		}
	}

}
