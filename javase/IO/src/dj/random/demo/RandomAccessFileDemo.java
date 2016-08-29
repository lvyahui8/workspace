package dj.random.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		/*
		 * RandomAccessFile
		 * 从名字中可以看出它不属于IO体系
		 * 四个关键字    随机   文件   读取   写入
		 * 1、该类的对象既能读也能写
		 * 2、该对象内部维护一个byte数组，并通过指针可以操作数组中的数据
		 * 3、可以通过getFilePointer方法获取指针的位置，还可以通过seek方法设置指针
		 * 
		 * 4、该类的内部对输入流和输出流进行了封装
		 * 5、该对象的源或汇只能是文件
		 */
		
//		writeFile();
//		readFile();
		randomWrite();
	}
	public static void randomWrite() throws IOException{
		// TODO 自动生成的方法存根
		RandomAccessFile raf = new RandomAccessFile("raf.txt","rw");
		raf.seek(3*8);
		raf.write("老刘".getBytes());
		raf.writeInt(23);
		raf.close();
	}
	public static void readFile() throws IOException {
		// TODO 自动生成的方法存根
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
		
		byte [] buf = new byte[4];
		raf.read(buf);
		int age = raf.readInt();
		
		System.out.println(new String(buf) + age);
		raf.close();

	}
	/*
	 * 使用RandomAccessFile对象写入一些人员信息
	 */
	public static void writeFile() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
		
		raf.write("红星".getBytes());
//		raf.write(97);
		raf.writeInt(97);
		raf.close();
	}
}
