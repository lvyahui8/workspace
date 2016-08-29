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
		System.out.println("发送端启动");
		// TODO 自动生成的方法存根
		/*
		 * 创建udp传输的发送端
		 * 思路：
		 * 1、建立udp的socket服务。
		 * 2、将要发送的数据封装到数据包中
		 * 3、通过udp的socket服务奖数据包发送出去
		 * 4、关闭socket服务。
		 */
		//	1、udpsocket服务，使用DatagramSocket
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
		
		//	2、装数据包
//		String str = JOptionPane.showInputDialog("请输入你要送的");
		String str = null;
		byte [] buf = new byte[255];
		
		
		
		//	3、将数据包发送出去
		
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
