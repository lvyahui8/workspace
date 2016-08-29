package dj.charstream.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextByBufferTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		FileReader fr = null;
		BufferedReader bufr = null;

		FileWriter fw = null;
		BufferedWriter bufw = null;
		try {
			fr = new FileReader("line.txt");
			bufr = new BufferedReader(fr);
			fw = new FileWriter("line_copy.txt");
			bufw = new BufferedWriter(fw);
			
			String line = null;
			while ((line = bufr.readLine()) != null) {
				bufw.write(line);
				bufw.newLine();
				bufw.flush();
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
		finally{
			if (bufw != null) {
				try {
					bufw.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if (bufr != null) {
				try {
					bufr.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}

	}

}
