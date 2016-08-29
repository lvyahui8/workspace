import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ChatClient extends Frame {

	private static final long serialVersionUID = 3218228979346248146L;
	private static final int FRAME_HEIGHT = 300;
	private static final int FRAME_WIDTH = 500;
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();

	Socket sk = null;
	PrintStream ps = null;

	public void launchFrame() {
		this.setLocation(500, 200);
		this.setSize(ChatClient.FRAME_WIDTH, ChatClient.FRAME_HEIGHT);
		this.add(tfTxt, BorderLayout.SOUTH);
		this.add(taContent, BorderLayout.NORTH);
		this.pack();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO 自动生成的方法存根
				disconnect();
				System.exit(0);
			}

		});
		tfTxt.addActionListener(new TFListener());
		taContent.setBackground(Color.GREEN);
		taContent.setEditable(false);
		this.setVisible(true);
		
		
	}

	private class Rece implements Runnable{
		
		@Override
		public void run() {
			// TODO 自动生成的方法存根
			try {
				rece();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
			}
		}
		public void rece() throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			while(true){
				String res = br.readLine();
				taContent.append(res+LINE_SEPARATOR);
			}
		}
	}
	
	private class TFListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			String tfStr = tfTxt.getText().trim();
			tfTxt.setText("");
//			taContent.append(sk.getInetAddress().getHostAddress()+":"+tfStr+LINE_SEPARATOR);
			ps.println(tfStr);
		}
	}

	public void disconnect(){
		try{
			sk.shutdownOutput();
			sk.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void connect() {
		if (null == sk) {
			try {
//				sk = new Socket("127.0.0.1", 9999);
				sk = new Socket(InetAddress.getLocalHost().getHostAddress(), ChatServer.PORT);
				
				ps = new PrintStream(sk.getOutputStream(), true);
			} catch (UnknownHostException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (SocketException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		new Thread(new Rece()).start();
	}

	public static void main(String[] args) {
		ChatClient cc = new ChatClient();
		cc.launchFrame();
		cc.connect();
	}
}
