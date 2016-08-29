package dj.net.tcp.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class T_UploadServer implements Runnable{
	static int count = 0;
	public T_UploadServer() {
		// TODO �Զ����ɵĹ��캯�����
	}
	private Socket sk = null;
	public T_UploadServer(Socket sk) {
		// TODO �Զ����ɵĹ��캯�����
		this.sk = sk;
	}
	/**
	 * @param sk
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void upload(Socket sk) throws FileNotFoundException,
			IOException {
		System.out.println("Դ:"+sk.getInetAddress().getHostAddress());
		//����������
		BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream((count++)+"supload.txt"));
		
		//��ȡsocket��
		BufferedInputStream bfIn = new BufferedInputStream(sk.getInputStream());
		
		int len = 0 ;
		byte [] buf = new byte[1024];
		
		while ((len = bfIn.read(buf))!=-1) {
			bfOut.write(buf, 0, len);
			bfOut.flush();
		}
		
		bfOut.close();
		
		//�����ͻ���
		OutputStream ops = sk.getOutputStream();
		
		ops.write("OVER".getBytes());
		
		sk.close();
	}

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		try {
			upload(sk);
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		ServerSocket ss = new  ServerSocket(10001);
		
		Socket sk = null;
		while(true){
			sk = ss.accept();
			new Thread(new T_UploadServer(sk)).start();
		}
		
	}

}
