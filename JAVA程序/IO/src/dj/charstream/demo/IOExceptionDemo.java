package dj.charstream.demo;

import java.io.FileWriter;
import java.io.IOException;

public class IOExceptionDemo {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args){
		// TODO �Զ����ɵķ������
		FileWriter fw = null;
		try {
			fw = new FileWriter("G:\\demo.txt");
			fw.write("nihaoa56" + LINE_SEPARATOR + "dddddd");
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		finally{
			if(null != fw)
				try {
					fw.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					throw new RuntimeException("�ر�ʧ��");
				}
		}
	}

}
