package dj.charstream.demo;

import java.io.FileReader;
import java.io.IOException;

public class MyBufferedReaderTest{

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		FileReader fr = null;
		MyBufferedReader myBuFR = null;
		
		try {
			fr = new FileReader("line.txt");
			myBuFR = new MyBufferedReader(fr);
			String line = null;
			while((line = myBuFR.myReadLine()) != null){
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			if(myBuFR != null)
				try {
					myBuFR.myClose();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		}
	}

}


/*
 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 1024
	at dj.charstream.demo.MyBufferedReader.myRead(MyBufferedReader.java:29)
	at dj.charstream.demo.MyBufferedReader.myReadLine(MyBufferedReader.java:34)
	at dj.charstream.demo.MyBufferedReaderTest.main(MyBufferedReaderTest.java:18)

 */
