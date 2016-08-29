package dj.charstream.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * ���󣺸����ı��ļ���
 * ��ʵ�Ƕ�д�Ĺ���
 * 1����Ҫ��ȡԴ
 * 2����������Դ����д��Ŀ�ĵء�
 * 3����Ȼ�ǲ����ı����ݣ�ʹ���ַ���
 * 
 */
public class CopyTextTest {
	private static char [] buffer = new char[255];
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		final String soureFile = "demo.txt";
		final String destinationFile = "copydemo.txt";
		copyText_2(soureFile, destinationFile);
	}

	private static void copyText_2(String soureFile, String destinationFile) {
		// TODO �Զ����ɵķ������
		FileReader fr = null;
		FileWriter fw = null;

		try {
			fr = new FileReader(soureFile);
			fw = new FileWriter(destinationFile);
			
			int len = 0;
			while((len = fr.read(buffer)) != -1){
				fw.write(buffer,0,len);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			// �ر��ļ�
			closeFile(fr, fw);
		}
		
	}

	/**
	 * @param fr
	 * @param fw
	 */
	public static void closeFile(FileReader fr, FileWriter fw) {
		if (null != fr) {
			try {
				fr.close();
			} catch (IOException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}
		if (null != fw) {
			try {
				fw.close();
			} catch (IOException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}
	}

	/**
	 * @param soureFile
	 * @param destinationFile
	 */
	public static void copyText_1(final String soureFile,
			final String destinationFile) {
		// 1������һ����ȡԴ
		FileReader fr = null;
		// 2������һ��Ŀ�ĵ�
		FileWriter fw = null;

		try {
			fr = new FileReader(soureFile);
			fw = new FileWriter(destinationFile);
			int ch;
			// 3����д�ļ�
			while ((ch = fr.read()) != -1) {
				fw.write(ch);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			closeFile(fr, fw);
		}
	}

}
