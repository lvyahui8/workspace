package dj.file.demo;

import java.io.File;

public class RemoveDirTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		/*
		 * ��ʵWindowsɾ������ɾ���ļ�����Ķ�����ɾ�ļ��б���
		 */
		File dir = new File("Ŀ¼ - ����");
		removeDir(dir);
	}

	public static void removeDir(File dir) {
		// TODO �Զ����ɵķ������
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
