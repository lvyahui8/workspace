import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;


public class MergeFile {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		File dir = new File(".");
		mergeFile(dir);
		
	}

	public static void mergeFile(File dir) {
		// TODO 自动生成的方法存根
		ArrayList<FileInputStream> list = new ArrayList<FileInputStream>();
		
		for(int i= 1; i<=5 ; i++){
			try {
				list.add(new FileInputStream(new File(dir,i+".part")));
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		Enumeration<FileInputStream> en = Collections.enumeration(list);
		
		SequenceInputStream sis = new SequenceInputStream(en);
		
		try {
			FileOutputStream fos = new FileOutputStream(new File("MergeTest.ppt"));
			byte [] buffer = new byte[1024];
			
			int len = 0;
			
			while ((len = sis.read(buffer)) != -1) {
				fos.write(buffer,0,len);
			}
			sis.close();
			fos.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
