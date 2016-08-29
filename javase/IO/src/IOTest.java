import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class IOTest {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		File dir = new File("E:\\IT学习\\JAVA学习\\JAVA基础视频");
		
		FilenameFilter filter = new FilenameFilter() {	//	这里其实是定义了一个内部类，实现了FilenameFilter接口。
			@Override
			public boolean accept(File dir, String name) {
				// TODO 自动生成的方法存根
				return name.endsWith(".avi");
			}
		};
		
		List<File> list = new ArrayList<File>();
		getFiles(dir,filter,list);
		File destFile = new File(dir,"avi.txt");
		writeToFile(list, destFile);
	}
	/**
	 * 对指定目录中的内容进行深度遍历，并按照指定过滤器，进行过滤
	 * 将过滤后的内容存储到指定容器中
	 * @param dir
	 * @param filter
	 * @param list
	 */
	public static void getFiles(File dir,FilenameFilter filter,List<File> list){
		File [] files = dir.listFiles();
		for(File file : files){
			if (file.isDirectory()) {
				getFiles(file,filter,list);
			}
			else{
				if (filter.accept(dir, file.getName())) {
					list.add(file);
				}
			}
		}
	}
	
	public static void writeToFile(List<File> list,File destFile){
		BufferedWriter bufw = null;
		try {
			bufw = new BufferedWriter(new FileWriter(destFile));
			for(File file : list){
				bufw.write(file.getAbsolutePath());
				bufw.newLine();
//				bufw.flush();
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			if (bufw != null) {
				try {
					bufw.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
}
