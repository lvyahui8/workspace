package dj.chat.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send implements Runnable {
	
	private DatagramSocket ds;
	
	public Send(DatagramSocket ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {			
			//	2、装数据包
//			String str = JOptionPane.showInputDialog("请输入你要送的");
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
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
