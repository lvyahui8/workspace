package dj.charstream.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 需求：复制文本文件。
 * 其实是读写的过程
 * 1、需要读取源
 * 2、将读到的源数据写到目的地。
 * 3、既然是操作文本数据，使用字符流
 * 
 */
public class CopyTextTest {
	private static char [] buffer = new char[255];
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		final String soureFile = "demo.txt";
		final String destinationFile = "copydemo.txt";
		copyText_2(soureFile, destinationFile);
	}

	private static void copyText_2(String soureFile, String destinationFile) {
		// TODO 自动生成的方法存根
		FileReader fr = null;
		FileWriter fw = null;

		try {
			fr = new FileReader(soureFile);
			fw = new FileWriter(destinationFile);
			
			int len = 0;
			while((len = fr.read(buffer)) != -1){
				fw.write(buffer,0,len);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			// 关闭文件
			closeFile(fr, fw);
		}
		
	}

	/**
	 * @param fr
	 * @param fw
	 */
	public static void closeFile(FileReader fr, FileWriter fw) {
		if (null != fr) {
			try {
				fr.close();
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		if (null != fw) {
			try {
				fw.close();
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
	}

	/**
	 * @param soureFile
	 * @param destinationFile
	 */
	public static void copyText_1(final String soureFile,
			final String destinationFile) {
		// 1、创建一个读取源
		FileReader fr = null;
		// 2、创建一个目的地
		FileWriter fw = null;

		try {
			fr = new FileReader(soureFile);
			fw = new FileWriter(destinationFile);
			int ch;
			// 3、读写文件
			while ((ch = fr.read()) != -1) {
				fw.write(ch);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			closeFile(fr, fw);
		}
	}

}
