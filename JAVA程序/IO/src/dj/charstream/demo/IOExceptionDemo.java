package dj.charstream.demo;

import java.io.FileWriter;
import java.io.IOException;

public class IOExceptionDemo {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args){
		// TODO 自动生成的方法存根
		FileWriter fw = null;
		try {
			fw = new FileWriter("G:\\demo.txt");
			fw.write("nihaoa56" + LINE_SEPARATOR + "dddddd");
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		finally{
			if(null != fw)
				try {
					fw.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					throw new RuntimeException("关闭失败");
				}
		}
	}

}
