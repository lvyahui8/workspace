package dj.charstream.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {

//	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		FileWriter fw = null;
		BufferedWriter bufw = null;
		try {
			fw = new FileWriter("buf.txt");
			bufw = new BufferedWriter(fw);
//			bufw.write("ni"+LINE_SEPARATOR+"hao");
//			bufw.write("abbcd");
//			bufw.newLine();//封装了换行方法
//			bufw.write("hao");
//			bufw.flush();
			
			for (int i = 0 ;i<5;i++){
				bufw.write("wenben"+i);
				bufw.newLine();
				bufw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			if(bufw!=null)
				try {
					bufw.close();//缓冲区关闭，底层其实关掉了流。
					//fw.write("nihao");//流已经关闭所以不能再写了
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		}

	}

}
