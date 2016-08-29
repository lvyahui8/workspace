package dj.bytearray.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ByteArrayInputStream bis = new ByteArrayInputStream("abcdef".getBytes());
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int ch = 0;
		while((ch = bis.read())!=-1){
			bos.write(ch);
		}
		
		System.out.println(bos.toString());
	}

}

/*abstract class A{
	public abstract void run() throws Exception ;
}

class B extends A{
	public void run(){
		
	}
}*/
