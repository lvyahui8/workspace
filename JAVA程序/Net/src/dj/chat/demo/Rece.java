package dj.chat.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Rece implements Runnable {
	
	private DatagramSocket ds;
	
	public Rece(DatagramSocket ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			//2
			byte [] buf  = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			
			do {
				//3
				ds.receive(dp);
				//4
				String data = new String(dp.getData(), 0, dp.getLength());
				String ip = dp.getAddress().getHostAddress();
				if(data.equals("over")){
					System.out.println(ip+"  退出聊天室");
					ds.close();
					break;
				}
				int port = dp.getPort();
				System.out.println(ip + ".." + data + ".." + port);
			} while (true);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
