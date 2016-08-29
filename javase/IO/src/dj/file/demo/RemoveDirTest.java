package dj.file.demo;

import java.io.File;

public class RemoveDirTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*
		 * 其实Windows删除是先删除文件夹里的东西再删文件夹本身
		 */
		File dir = new File("目录 - 副本");
		removeDir(dir);
	}

	public static void removeDir(File dir) {
		// TODO 自动生成的方法存根
		File [] files = dir.listFiles();
		for(File file : files){
			if(file.isDirectory()){
				removeDir(file);
			}
			else{
				System.out.println(file+":"+file.delete());
			}
		}
		System.out.println(dir+":"+dir.delete());
	}

}
