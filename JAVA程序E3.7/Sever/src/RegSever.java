import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class RegSever {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(10000);
		Socket sk = ss.accept();
		System.out.println(sk.getInetAddress().getHostAddress());
		InputStream in = sk.getInputStream();
		byte [] buf = new byte[1024*2];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		PrintWriter out = new PrintWriter(sk.getOutputStream(),true);
		out.println("<font color='green' size='7'>注册成功</font>");
		
		sk.close();
		ss.close();
		
//		Dev d = new Dev();
//		d.fun();
	}

}

//interface T {
//	void fun() throws Exception;
//}
//
//interface T2 extends T{
//	void fun();
//}
//
//class Tc implements T2{
//	public void fun(){
//		System.out.println("Tc fun");
//	}
//}
//class Test{
//	public void fun() throws Exception{
//		System.out.println("Test fun");
//	}
//}
//
//class Dev extends Test implements T2{
//	public void fun(){
//		System.out.println("Dev fun");
//	}
//}


