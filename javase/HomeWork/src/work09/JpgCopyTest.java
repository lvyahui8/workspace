package work09;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JpgCopyTest {

	private static final String E_1524872296_1_JPEG = "E:\\1524872296(1).jpeg";
	private static final String E_1524872296_JPEG = "E:\\1524872296.jpeg";
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		copy_2();
	}

	public static void copy_1() throws IOException {
		// TODO 自动生成的方法存根
		FileInputStream fis = new FileInputStream(E_1524872296_JPEG);
		FileOutputStream fos = new FileOutputStream(E_1524872296_1_JPEG);
		byte [] buffer = new byte[1024];
		
		int len = 0 ;
		
		while((len = fis.read(buffer)) != -1){
			fos.write(buffer,0,len);
		}
		
		fis.close();
		fos.close();
	}
	public static void copy_2() throws IOException {
		// TODO 自动生成的方法存根
		FileInputStream fis = new FileInputStream(E_1524872296_JPEG);
		FileOutputStream fos = new FileOutputStream(E_1524872296_1_JPEG);
		BufferedInputStream bufis = new BufferedInputStream(fis);
		BufferedOutputStream bufos = new BufferedOutputStream(fos);

//		byte [] car = new byte[1024];
//		int len = 0 ;
		int ch;
//		while((len = bufis.read(car)) != -1){
		while((ch = bufis.read()) != -1){
//			bufos.write(car,0,len);bufos.flush();
			bufos.write(ch);
			//这种方式不能经常刷新，否则就很慢了，相当于缓冲区不起作用，还变成了鸡肋（一个字节的数据被读到缓冲区，然后立马又从缓冲区写到硬盘，你说是不是多此一举）
		}
		
		bufis.close();
		bufos.close();
	}

}
