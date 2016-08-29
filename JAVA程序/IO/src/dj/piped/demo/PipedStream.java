package dj.piped.demo;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Input implements Runnable{

	private PipedInputStream in;
	
	public Input(PipedInputStream in) {
		super();
		this.in = in;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			byte [] buf = new byte[1024];
			int len = in.read(buf);
			String str = new String(buf,0,len);
			System.out.println(str);
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
class Output implements Runnable{
	private PipedOutputStream out;
	
	public Output(PipedOutputStream out) {
		super();
		this.out = out;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			out.write("xiehaol".getBytes());
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
public class PipedStream {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		
		in.connect(out);
		
		Input theIn = new Input(in);
		Output theOut = new Output(out);
		
		new Thread(theIn).start();
		new Thread(theOut).start();
	}

}
