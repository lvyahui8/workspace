import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MyIOTest {
	private static final int STR_LENGTH = 25;
	private static final String [] STR = new String[STR_LENGTH];
	private static int level = -1;
	private static List<String>list = new ArrayList<String>();
	
	static
	{
		STR[0] = "";
		STR[1] = " ├──────";
		for(int i=2;i<STR.length;i++){
//			STR[i] = STR[i-1]+"------";
			STR[i] = "        "+STR[i-1];
		}
	}
	/**
	 * @param dir
	 * @param fileType
	 * @param destFile
	 * @throws IOException 
	 */
	private static void FindFilesToText(File dir, String fileType, File destFile) throws IOException {
		list.clear();
		FindFile(dir,fileType);
		BufferedWriter bufw = new BufferedWriter(new FileWriter(destFile));
		for(String name : list){
			bufw.write(name);
			bufw.newLine();
		}
		bufw.close();
	}
	
	private static void FindFile(File dir, String fileType){
		level++;
		File [] files = dir.listFiles();
		for(int i=0;i<files.length;i++){
			String name = files[i].getName();
			if (files[i].isDirectory()) {
				list.add(STR[level]+name);
				FindFile(files[i], fileType);
			}
			else{
				if (name.endsWith(fileType)) {
					list.add(STR[level]+name);
				}
			}
		}
		level--;
	}

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		File dir = new File("E:\\IT学习\\JAVA学习\\JAVA基础视频");
		File destFile = new File(dir,"avi_2.txt");
		String fileType = ".avi";
		FindFilesToText(dir,fileType,destFile);
	}
}
