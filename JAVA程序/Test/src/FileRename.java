import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class FileRename {
	public static void stringSort(String [] strArr){
		
	}
	
	public static void listSort(List<?> list){
		
	}
	public static int compare(String str1,String str2){
		int i1 = Integer.parseInt(str1.split("\\.")[0]);
		int i2 = Integer.parseInt(str2.split("\\.")[0]);
//		System.out.println(i1+"     "+i2);
		int result = 0;
		if(i1>i2){
			result = 1;
		}
		else if(i1<i2){
			result = -1;
		}
		return result;
	}
	
	public static void fileSort(File [] files){
		for(int i=0;i<files.length-1;i++){
			int p = i ;
			for(int j=i+1;j<files.length;j++){
//				if(files[p].getName().compareTo(files[j].getName())  >  0){
				if(compare(files[p].getName(),files[j].getName()) >  0){
					p = j;
				}
			}
			
			if(p!=i){
				File temp = files[i];
				files[i] = files[p];
				files[p] = temp;
			}
		}
	}
	
	public static void rename(){
		File dir = new File("E:/IT学习/JAVA学习/Java多线程与并发库高级应用视频教程");
		File dirs[] = dir.listFiles();
		List<String> names = new ArrayList<String>();
		List<File> files = new ArrayList<File>();
		for (int i = 0; i < dirs.length; i++) {
//			System.out.println(dirs[i].getName());
//			if("观看帮助.txt".equals(dirs[i].getName())){
//				dirs[i].renameTo(new File(dir,"HH.txt"));
//			}
			if(dirs[i].getName().matches("[0-2]\\d_.+")){
				
//				System.out.println(dirs[i].getName());
				names.add(dirs[i].getName());
			}
			else if(dirs[i].getName().matches("\\d{1,2}.avi")){
//				System.out.println(dirs[i].getName());
				files.add(dirs[i]);
			}
		}
		
		File [] filesArr = new File[files.size()];
		files.toArray(filesArr);
//		System.out.println(filesArr.length);
		fileSort(filesArr);
		
		for(int i=0;i<names.size();i++){
			String filename = names.get(i).replaceAll("传智播客_张孝祥_", "");
//			System.out.println(filename);
//			System.out.println(filesArr[i].getName()+"更名为"+filename);
			filesArr[i].renameTo(new File(dir, filename+".avi"));
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		rename();
//		compare("1.avi","2.avi");
	}

}
