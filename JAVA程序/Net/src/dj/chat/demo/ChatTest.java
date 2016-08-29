package dj.chat.demo;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatTest {

	public static void main(String[] args) throws SocketException {
		// TODO 自动生成的方法存根
		DatagramSocket send = new DatagramSocket();
		DatagramSocket rece = new DatagramSocket(10000);
		Send s = new Send(send);
		Rece r = new Rece(rece);
		
		new Thread(r).start();
		new Thread(s).start();
	}

}
