package org.lyh.utils.file;

import java.io.File;

public class DirectoryTools {
	static final int STR_LENGTH = 25;
	static final String [] STR = new String[STR_LENGTH];
	
	static
	{
		STR[0] = "";
		STR[1] = " |-----";
		for(int i=2;i<STR.length;i++){
//			STR[i] = STR[i-1]+"------";
			STR[i] = "        "+STR[i-1];
		}
	}
	static int l = -1;
	
	
	/**
	 * 打印目录树
	 * @param dir	要打印的目录的根
	 * @param level  打印多少层
	 * @param listFile  是否显示文件
	 */
	public static void listDirectory(File dir,int level,boolean listFile){
		
		if(l+1>level) return;
		
		l++;
		
		File [] files = dir.listFiles();
		
		for(int i=0;i<files.length;i++){
			if(files[i].isFile() && !listFile){
				continue;
			}
			System.out.println(STR[l]+files[i].getName());
			if(files[i].isDirectory()){
				listDirectory(files[i], level, listFile);
			}
		}
		
		l--;
	}
	
}
