package dj.bytestream.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TransStreamDemo {
	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		//	�ַ���
		runCar(System.in, System.out);											//�ӿ���̨��ȡ�������������̨��
		runCar(System.in,new FileOutputStream("a.txt"));						//�ӿ���̨��ȡ����д�뵽�ļ�a.txt
		runCar(new FileInputStream("a.txt"),new FileOutputStream("b.txt"));		//���ļ�a.txt������д���ļ�b.txt
		runCar(new FileInputStream("a.txt"),System.out);						//���ļ�a.txt������д������̨
		//		���ﻹ����new����a.txt���൱��ˢ���ļ�ָ�룬��������ָ���ļ�ͷ
	}

	/**
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static void runCar(InputStream in, OutputStream out)
			throws IOException {
		//	���ֽ���ת�����ַ���������ת����
		InputStreamReader isr = new  InputStreamReader(in);
		
		//	װ��ת��֮����ַ���
		BufferedReader bufr = new BufferedReader(isr);
		//	�ֽ���
		OutputStreamWriter opsw = new OutputStreamWriter(out);
		
		BufferedWriter bufw = new BufferedWriter(opsw);
		String line= null;
		while ((line = bufr.readLine()) != null) {
			if (line.equals("over")) {
				break;
			}
//			System.out.println(line.toUpperCase());
//			opsw.write(line.toUpperCase()+"\r\n");
//			opsw.flush();
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
	}

}
