package xml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XmlCreate {

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br_en = new BufferedReader(new FileReader("E:/name.txt"));
		BufferedReader br_zh = new BufferedReader(new FileReader("E:/phone.txt"));
		
		StringBuilder sb = new StringBuilder();
		String en = br_en.readLine();
		String zh = br_zh.readLine();
//		while (!"end".equals(en)) {
//			en = en.toLowerCase().replaceAll(" ", "_");
//			sb.append("<string name=\""+en+"\"></string>"+LINE_SEPARATOR);
//			en = br_en.readLine();
//		}
		while (en != null && zh != null) {
			en = en.toLowerCase().replaceAll(" ", "_");
			sb.append("<phone name=\""+en+"\">"+zh+"</phone>"+LINE_SEPARATOR);
			en = br_en.readLine();
			zh = br_zh.readLine();
		}
		System.out.println();
		System.out.println(sb.toString());
	}
	

}
