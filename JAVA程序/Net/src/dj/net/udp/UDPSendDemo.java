package dj.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSendDemo {

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
		DatagramSocket ds = new DatagramSocket();
		
		//	2、装数据包
		String str = "12334234";
		DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("127.0.0.1"), 10000);
		
		//	3、将数据包发送出去
		
		ds.send(dp);
		
		ds.close();
	}

}
