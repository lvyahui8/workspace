package dj.net.udp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {

	public static void main(String[] args) throws UnknownHostException {
		// TODO �Զ����ɵķ������
		//	��ȡ����������IP����
		InetAddress ip = InetAddress.getLocalHost();
		
		//	��ȡ����������IP����
//		ip = InetAddress.getByName("192.168.1.100");
//		ip = InetAddress.getByName("192.168.1.1");
		ip = InetAddress.getByName("74.125.39.99");
		
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());
	}

}
