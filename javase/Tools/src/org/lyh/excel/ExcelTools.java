package org.lyh.excel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExcelTools {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File inFile = new File("F:/tmp/ch.txt");
		File lOutFile = new File("F:/tmp/h.txt");
		File rOutFile = new File("F:/tmp/e.txt");
		
		if(!inFile.exists()){
			System.out.println("输入文件不存在");
			return ;
		}
		try {
			
			lOutFile.createNewFile();
			rOutFile.createNewFile();
			
			FileReader fr = new FileReader(inFile);
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter lfw = new FileWriter(lOutFile);
			BufferedWriter lbw = new BufferedWriter(lfw);
			
			FileWriter rfw = new FileWriter(rOutFile);
			BufferedWriter rbw = new BufferedWriter(rfw);
			
			System.out.println(fr.getEncoding());
			
			String line = null;
			while(( line =  br.readLine() )!=null){
				
				//line = new String(line.getBytes("GBK"),"utf8");
				
				int first = line.indexOf(" ");
				
				String l = line.substring(0, first).trim();
				String r = line.substring(first).trim();
				
//				int rStart = line.indexOf(r);
//				String l = line.substring(0, rStart).trim();
				
				System.out.println(l+":"+r);
				lbw.write(l+LINE_SEPARATOR);
				rbw.write(r+LINE_SEPARATOR);
				lbw.flush();
				rbw.flush();
			}
			
			lbw.close();
			rbw.close();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
