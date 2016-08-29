package dj.date.demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
//		writeData();
		readData();
	}

	public static void readData() throws IOException {
		// TODO 自动生成的方法存根
		DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
		String str = dis.readUTF();
		System.out.println(str);
		dis.close();
	}

	public static void writeData() throws IOException {
		// TODO 自动生成的方法存根
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
		dos.writeUTF("你好");
		
		dos.close();
	}

}
