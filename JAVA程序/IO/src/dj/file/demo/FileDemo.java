package dj.file.demo;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������ 
		
		//���Խ�һ���ļ���Ŀ¼��װ�ɶ��󣨲��ܴ������
		File file1 = new File("d:\\a.txt");	
		
		//���Խ��������룬�������
		File file2 = new File("d:\\","a.txt");
		
		File fpath = new File("d:\\");
		
		File file3 = new File(fpath,"a.txt");
		
		// ���ʹ����һ��
		File file4 = new File("d:"+File.separator+"abc"+File.separator+"a.txt");// ��ʾ d:\abc\a.txt  �� d:\\abc\\a.txt
	}

}
