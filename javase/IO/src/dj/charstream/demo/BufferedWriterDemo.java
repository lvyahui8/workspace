package dj.charstream.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {

//	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		FileWriter fw = null;
		BufferedWriter bufw = null;
		try {
			fw = new FileWriter("buf.txt");
			bufw = new BufferedWriter(fw);
//			bufw.write("ni"+LINE_SEPARATOR+"hao");
//			bufw.write("abbcd");
//			bufw.newLine();//��װ�˻��з���
//			bufw.write("hao");
//			bufw.flush();
			
			for (int i = 0 ;i<5;i++){
				bufw.write("wenben"+i);
				bufw.newLine();
				bufw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			if(bufw!=null)
				try {
					bufw.close();//�������رգ��ײ���ʵ�ص�������
					//fw.write("nihao");//���Ѿ��ر����Բ�����д��
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
		}

	}

}
