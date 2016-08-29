import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class IOTest {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		File dir = new File("E:\\ITѧϰ\\JAVAѧϰ\\JAVA������Ƶ");
		
		FilenameFilter filter = new FilenameFilter() {	//	������ʵ�Ƕ�����һ���ڲ��࣬ʵ����FilenameFilter�ӿڡ�
			@Override
			public boolean accept(File dir, String name) {
				// TODO �Զ����ɵķ������
				return name.endsWith(".avi");
			}
		};
		
		List<File> list = new ArrayList<File>();
		getFiles(dir,filter,list);
		File destFile = new File(dir,"avi.txt");
		writeToFile(list, destFile);
	}
	/**
	 * ��ָ��Ŀ¼�е����ݽ�����ȱ�����������ָ�������������й���
	 * �����˺�����ݴ洢��ָ��������
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			if (bufw != null) {
				try {
					bufw.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
	}
}
