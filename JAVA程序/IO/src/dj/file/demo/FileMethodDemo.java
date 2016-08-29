package dj.file.demo;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

public class FileMethodDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		/*
		 * File��ĳ�������
		 * 1����ȡ
		 * 		1.1  ��ȡ�ļ�����     getName()
		 * 		1.2  ��ȡ�ļ�·��
		 * 		1.3  ��ȡ�ļ�·��
		 * 		1.4  ��ȡ�ļ��޸�ʱ��
		 * 		1.5 ��ȡĿ¼����
		 * 		......
		 * 2��������ɾ��
		 * 		2.1
		 * 			boolean
		 * 3���ж�
		 * 
		 * 4��������
		 * 		���������������Լ���
		 */
		
//		getDemo();
//		createDeleteDemo();
//		isDemo();
		
		//	��ȡĿ¼����
//		listDemo();
	}

	private static void listDemo() {
		// TODO �Զ����ɵķ������
		File file = new File("C:\\");
		/*
		 * ��ȡ��ǰĿ¼�µ��ļ����ļ��е����ƣ����������ļ�
		 * ����list������file�����װ�ı�����Ŀ¼
		 * ����ᷢ����ָ���쳣NullPointerException
		 * ������ʵ���ϵͳ��Ŀ¼Ҳ�ᷢ����ָ���쳣
		 */
		String list [] = file.list();
		
		for(String name : list){
			System.out.println(name);
		}
	}

	public static void isDemo() {
		// TODO �Զ����ɵķ������
		File file  = new File("a.txt");
		boolean flag = file.exists();//�Ƿ����
		
		System.out.println(flag);
	}

	public static void createDeleteDemo() {
		// TODO �Զ����ɵķ������
		File file  =  new File("xin.txt");
		boolean flag;
		try {
//			boolean flag = file.createNewFile();//�ļ����ڲ��ᴴ�����ļ������ڲ��ᴴ�������������һ��
//			boolean flag = file.delete();
//			file.deleteOnExit();//	�������ɾ�������˳�ʱ
			flag = file.mkdir();// ����İĿ¼
			System.out.println("flag=" + flag);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void getDemo() {
		// TODO �Զ����ɵķ������
		File file = new File("ass.txt");//����ļ������ڣ����ᴴ��
		
		String name = file.getName();
		String absPath = file.getAbsolutePath();//	��ȡ����·��
		String path = file.getPath();			//  ��ȡ���·��
		long length  = file.length();	
		long time = file.lastModified();
		
		Date date = new Date(time);
		
		DateFormat datefm = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
		
		String str_time = datefm.format(date);
		
		System.out.println(name+" "+absPath+" "+path);
		System.out.println(length+" "+time+" "+str_time);
	}

}
