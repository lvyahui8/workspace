package dj.file.demo;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

public class FileMethodDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*
		 * File类的常见方法
		 * 1、获取
		 * 		1.1  获取文件名称     getName()
		 * 		1.2  获取文件路径
		 * 		1.3  获取文件路径
		 * 		1.4  获取文件修改时间
		 * 		1.5 获取目录内容
		 * 		......
		 * 2、创建和删除
		 * 		2.1
		 * 			boolean
		 * 3、判断
		 * 
		 * 4、重命名
		 * 		可以重命名，可以剪切
		 */
		
//		getDemo();
//		createDeleteDemo();
//		isDemo();
		
		//	获取目录内容
//		listDemo();
	}

	private static void listDemo() {
		// TODO 自动生成的方法存根
		File file = new File("C:\\");
		/*
		 * 获取当前目录下的文件及文件夹的名称，包含隐藏文件
		 * 调用list方法的file对象封装的必须是目录
		 * 否则会发生空指针异常NullPointerException
		 * 如果访问的是系统级目录也会发生空指针异常
		 */
		String list [] = file.list();
		
		for(String name : list){
			System.out.println(name);
		}
	}

	public static void isDemo() {
		// TODO 自动生成的方法存根
		File file  = new File("a.txt");
		boolean flag = file.exists();//是否存在
		
		System.out.println(flag);
	}

	public static void createDeleteDemo() {
		// TODO 自动生成的方法存根
		File file  =  new File("xin.txt");
		boolean flag;
		try {
//			boolean flag = file.createNewFile();//文件存在不会创建，文件不存在不会创建。和输出流不一样
//			boolean flag = file.delete();
//			file.deleteOnExit();//	让虚拟机删除，在退出时
			flag = file.mkdir();// 创建陌目录
			System.out.println("flag=" + flag);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void getDemo() {
		// TODO 自动生成的方法存根
		File file = new File("ass.txt");//如果文件不存在，不会创建
		
		String name = file.getName();
		String absPath = file.getAbsolutePath();//	获取绝对路径
		String path = file.getPath();			//  获取相对路径
		long length  = file.length();	
		long time = file.lastModified();
		
		Date date = new Date(time);
		
		DateFormat datefm = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
		
		String str_time = datefm.format(date);
		
		System.out.println(name+" "+absPath+" "+path);
		System.out.println(length+" "+time+" "+str_time);
	}

}
