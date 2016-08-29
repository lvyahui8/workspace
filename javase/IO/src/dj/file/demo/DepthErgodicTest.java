package dj.file.demo;

import java.io.File;

/*
 * 需求：深度遍历目录，显示目录树
 */
public class DepthErgodicTest {
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
	
	static int level = -1;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		File dir = new File("E:\\程序\\C++程序");
		DepthErgodic(dir);
	}

	public static void DepthErgodic(File dir) {
		// TODO 自动生成的方法存根
		//获取dir目录下的所有项
		level++;
		File [] files  = dir.listFiles();
		for(int i=0;i<files.length;i++){
			System.out.println(STR[level]+files[i].getName());
			if (files[i].isDirectory()) {
				DepthErgodic(files[i]);
			}
		}
		level--;
	}

}
