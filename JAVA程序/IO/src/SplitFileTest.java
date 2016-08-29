import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class SplitFileTest {

	private static final int SIZE = 1024*1024;	

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		File file = new File("SplitTest.ppt");
		splitFile(file);
	}

	public  static void splitFile(File file){
		// �ö�ȡ������Դ�ļ�
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			byte buffer [] = new byte[SIZE];
			int len = 0;
			for(int i = 1;(len = fis.read(buffer)) != -1;i++){
				fos = new FileOutputStream(i+".part");
				fos.write(buffer, 0, len);
				fos.close();
			}
			
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			if (null!=fis) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
	}
	
}
