package dj.charstream.demo;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		/*
		 * ��Ȼ�����ļ�����д���ݣ���ô�ڴ�������ʱ���ͱ�����ȷ���ļ������ڴ������ݵ�Ŀ�ĵأ�
		 * ����ļ������ڣ�����Զ�����
		 * ����ļ����ڣ��ҹ���ʱδָ��׷�ӣ��򸲸ǵ�ԭ�ļ���������ԭ�ļ�β��׷��
		 */
		FileWriter fw = new FileWriter("demo.txt",true);
		/*
		 * ����Writer�����е�write(string);������д�����ݡ�
		 * 
		 */
		//	Windowsϵͳ������\r\n
//		fw.write("nihaoa56\r\ndddddd");//	�Ƚ�����д�����ݻ�����������˵��������ȥ��
		fw.write("nihaoa56"+LINE_SEPARATOR+"dddddd");//	�Ƚ�����д�����ݻ�����������˵��������ȥ��
		fw.flush();	//����ˢ�£������ݴӻ�����д��Ŀ�ĵ�
		
		
		fw.close();
	}

}
