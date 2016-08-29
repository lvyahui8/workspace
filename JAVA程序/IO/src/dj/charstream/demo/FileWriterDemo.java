package dj.charstream.demo;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		/*
		 * 既然是往文件里面写数据，那么在创建对象时，就必须明确该文件（用于创建数据的目的地）
		 * 如果文件不存在，则会自动创建
		 * 如果文件存在，且构造时未指定追加，则覆盖掉原文件，否则在原文件尾部追加
		 */
		FileWriter fw = new FileWriter("demo.txt",true);
		/*
		 * 调用Writer对象中的write(string);方法，写入数据。
		 * 
		 */
		//	Windows系统换行是\r\n
//		fw.write("nihaoa56\r\ndddddd");//	先将数据写入数据缓冲区（或者说到流里面去）
		fw.write("nihaoa56"+LINE_SEPARATOR+"dddddd");//	先将数据写入数据缓冲区（或者说到流里面去）
		fw.flush();	//进行刷新，将数据从缓冲区写到目的地
		
		
		fw.close();
	}

}
