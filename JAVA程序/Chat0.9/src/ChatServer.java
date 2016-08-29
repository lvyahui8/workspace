import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	public static final int PORT = 10000;
	private List<Client> clients = new ArrayList<Client>(); 
	
	public ChatServer() {

	}

	public static void main(String[] args) {
		new ChatServer().start();
	}
	
	
	/**
	 * 
	 */
	public  void start() {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(ChatServer.PORT);
		} catch (IOException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}

		try {
			while (true) {
				Socket sk = ss.accept();
				Client c = new Client(sk);
				clients.add(c);
				new Thread(c).start();
			}
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			if (ss!=null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
	}

	private class Client implements Runnable {
		private Socket sk = null;

		/**
		 * @param sk
		 * @throws IOException
		 */

		public synchronized void rece() throws IOException {
			
			System.out.println(sk.getInetAddress().getHostAddress());

			BufferedReader br = new BufferedReader(new InputStreamReader(
					sk.getInputStream()));
			while (true) {
				String str = br.readLine();
				if(null == str){
					clients.remove(this);
					return;
				}
				System.out.println(str);
				for(int i=0;i<clients.size();i++){
					Client c = clients.get(i);
//					if(this != c){
						c.send(this.sk.getInetAddress().getHostAddress()+":"+str);
//					}
				}
			}
		}
		
		public  void send(String str) throws IOException{
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(this.sk.getOutputStream()));
			PrintWriter pt = new PrintWriter(bw,true);
			pt.println(str);
		}
		
		public Client(Socket sk) {
			this.sk = sk;
		}

		@Override
		public void run() {
			// TODO �Զ����ɵķ������
			try {
				rece();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}

	}

}
