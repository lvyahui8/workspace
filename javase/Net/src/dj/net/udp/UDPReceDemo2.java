package dj.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceDemo2 {

	public static void main(String[] args) throws IOException {
		System.out.println("���ն�����");
		// TODO �Զ����ɵķ������
		/*
		 * ����udp���ܶ˵�˼·
		 * 1������udp socket����
		 * 2��׼�����ݰ������������ݰ��ķ�����������
		 * 3�����ܷ��Ͷ˴����������ݰ�
		 * 4��ͨ�����ݰ��ķ����������ݰ��е�����
		 * 5���ر�socket����
		 * 
		 */
		
		rece();
	}

	/**
	 * @throws SocketException
	 * @throws IOException
	 */
	private static void rece() throws SocketException, IOException {
		//1
		DatagramSocket ds = new DatagramSocket(10000);
		
		//2
		byte [] buf  = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		do {
			//3
			ds.receive(dp);
			//4
			String data = new String(dp.getData(), 0, dp.getLength());
			if(data.equals("over")){
				ds.close();
				break;
			}
			String ip = dp.getAddress().getHostAddress();
			int port = dp.getPort();
			System.out.println(ip + ".." + data + ".." + port);
		} while (true);
	}

}
