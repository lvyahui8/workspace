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
		// TODO �Զ����ɵķ������
		try {			
			//	2��װ���ݰ�
//			String str = JOptionPane.showInputDialog("��������Ҫ�͵�");
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
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
