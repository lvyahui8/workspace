package dj.bytestream.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TransStreamTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		writeText_1();
	}

	/**
	 * @throws IOException
	 */
	public static void writeText_1() {
		FileWriter fw = null;
		OutputStreamWriter osw = null;
		try {
			fw = new FileWriter("gbk_1.txt");
			fw.write("���");
			osw = new OutputStreamWriter(new FileOutputStream("gbk_2.txt"));
			osw.write("���");
			osw.close();
			osw = new OutputStreamWriter(new FileOutputStream("gbk_3.txt"),"GBK");
			osw.write("���");
			osw.close();
			//	������������ͬ�ģ�����ʹ����Ĭ�ϵ�GBK����
			osw = new OutputStreamWriter(new FileOutputStream("utf-8.txt"),"UTF-8");
			osw.write("���");
			//	��һ��ʹ�õ���UTF-8 ����
		
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			try {
				fw.close();
				osw.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}

}
