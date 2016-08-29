package dj.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceDemo {

	public static void main(String[] args) throws IOException {
		System.out.println("接收端启动");
		// TODO 自动生成的方法存根
		/*
		 * 建立udp接受端的思路
		 * 1、建立udp socket服务
		 * 2、准备数据包，方便用数据包的方法解析数据
		 * 3、接受发送端传过来的数据包
		 * 4、通过数据包的方法解析数据包中的数据
		 * 5、关闭socket服务
		 * 
		 */
		
		//1
		DatagramSocket ds = new DatagramSocket(10000);
		
		//2
		byte [] buf  = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		//3
		ds.receive(dp);
		
		//4
		String data = new String(dp.getData(),0,dp.getLength());
		String ip = dp.getAddress().getHostAddress();
		int port = dp.getPort();
		System.out.println(ip+".."+data+".."+port);
		ds.close();
	}

}
