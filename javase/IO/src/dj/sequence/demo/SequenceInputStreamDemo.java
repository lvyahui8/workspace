package dj.sequence.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

public class SequenceInputStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		//	需求：将Seq(1).txt Seq(2).txt Seq(3).txt文件的内容合并到Seq.txt中
//		Vector<FileInputStream>  v =  new Vector<FileInputStream>();
//		
//		v.add(new FileInputStream("Seq(1).txt"));
//		v.add(new FileInputStream("Seq(2).txt"));
//		v.add(new FileInputStream("Seq(3).txt"));
		ArrayList<FileInputStream>  list =  new ArrayList<FileInputStream>();
		
		list.add(new FileInputStream("Seq(1).txt"));
		list.add(new FileInputStream("Seq(2).txt"));
		list.add(new FileInputStream("Seq(3).txt"));
		
//		SequenceInputStream sis = new SequenceInputStream(v.elements());
		
		/*final Iterator<FileInputStream> it = list.iterator();
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {
			@Override
			public boolean hasMoreElements() {
				// TODO 自动生成的方法存根
				return it.hasNext();
			}

			@Override
			public FileInputStream nextElement() {
				// TODO 自动生成的方法存根
				return it.next();
			}
		};*/
		Enumeration<FileInputStream> en = Collections.enumeration(list);// 该语句的原理就是上面注释的代码
		
		SequenceInputStream sis = new SequenceInputStream(en);
		
		FileOutputStream fos = new FileOutputStream("Seq.txt");
		
		byte [] buf = new byte[1024];
		
		int len = 0;
		
		while ((len = sis.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
		
		fos.close();
		sis.close();
	}

}
