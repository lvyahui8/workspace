package work09;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JpgCopyTest {

	private static final String E_1524872296_1_JPEG = "E:\\1524872296(1).jpeg";
	private static final String E_1524872296_JPEG = "E:\\1524872296.jpeg";
	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		copy_2();
	}

	public static void copy_1() throws IOException {
		// TODO �Զ����ɵķ������
		FileInputStream fis = new FileInputStream(E_1524872296_JPEG);
		FileOutputStream fos = new FileOutputStream(E_1524872296_1_JPEG);
		byte [] buffer = new byte[1024];
		
		int len = 0 ;
		
		while((len = fis.read(buffer)) != -1){
			fos.write(buffer,0,len);
		}
		
		fis.close();
		fos.close();
	}
	public static void copy_2() throws IOException {
		// TODO �Զ����ɵķ������
		FileInputStream fis = new FileInputStream(E_1524872296_JPEG);
		FileOutputStream fos = new FileOutputStream(E_1524872296_1_JPEG);
		BufferedInputStream bufis = new BufferedInputStream(fis);
		BufferedOutputStream bufos = new BufferedOutputStream(fos);

//		byte [] car = new byte[1024];
//		int len = 0 ;
		int ch;
//		while((len = bufis.read(car)) != -1){
		while((ch = bufis.read()) != -1){
//			bufos.write(car,0,len);bufos.flush();
			bufos.write(ch);
			//���ַ�ʽ���ܾ���ˢ�£�����ͺ����ˣ��൱�ڻ������������ã�������˼��ߣ�һ���ֽڵ����ݱ�������������Ȼ�������ִӻ�����д��Ӳ�̣���˵�ǲ��Ƕ��һ�٣�
		}
		
		bufis.close();
		bufos.close();
	}

}
