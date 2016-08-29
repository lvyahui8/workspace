package dj.file.demo;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根 
		
		//可以将一个文件或目录封装成对象（不管存在与否）
		File file1 = new File("d:\\a.txt");	
		
		//可以将参数分离，方便操作
		File file2 = new File("d:\\","a.txt");
		
		File fpath = new File("d:\\");
		
		File file3 = new File(fpath,"a.txt");
		
		// 最好使用下一种
		File file4 = new File("d:"+File.separator+"abc"+File.separator+"a.txt");// 表示 d:\abc\a.txt  或 d:\\abc\\a.txt
	}

}
