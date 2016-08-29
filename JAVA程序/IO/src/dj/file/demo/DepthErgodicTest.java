package dj.file.demo;

import java.io.File;

/*
 * ������ȱ���Ŀ¼����ʾĿ¼��
 */
public class DepthErgodicTest {
	static final int STR_LENGTH = 25;
	static final String [] STR = new String[STR_LENGTH];
	
	static
	{
		STR[0] = "";
		STR[1] = " |-----";
		for(int i=2;i<STR.length;i++){
//			STR[i] = STR[i-1]+"------";
			STR[i] = "        "+STR[i-1];
		}
	}
	
	static int level = -1;
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		File dir = new File("E:\\����\\C++����");
		DepthErgodic(dir);
	}

	public static void DepthErgodic(File dir) {
		// TODO �Զ����ɵķ������
		//��ȡdirĿ¼�µ�������
		level++;
		File [] files  = dir.listFiles();
		for(int i=0;i<files.length;i++){
			System.out.println(STR[level]+files[i].getName());
			if (files[i].isDirectory()) {
				DepthErgodic(files[i]);
			}
		}
		level--;
	}

}
