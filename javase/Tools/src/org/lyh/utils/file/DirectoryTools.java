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
	 * ��ӡĿ¼��
	 * @param dir	Ҫ��ӡ��Ŀ¼�ĸ�
	 * @param level  ��ӡ���ٲ�
	 * @param listFile  �Ƿ���ʾ�ļ�
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
