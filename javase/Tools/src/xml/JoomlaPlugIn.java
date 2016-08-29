package xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * ��joomla�������
 * @author Agrin
 *
 */
public class JoomlaPlugIn {

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		/*
		 * ����
		 * 
		 * �ڿ���̨����Ӣ������		�ֶ�=��ֵ��
		 * 
		 * ���ļ�1�������ж�ȡ����ֳ��ֶ� �� ֵ���ֱ�����������ļ��У�ziduan.txt  ��  zhi.txt��
		 * 
		 * ��ֵ���е����ݷ����
		 * 
		 * Ȼ���ٴ������ļ��ж����ݣ�Ȼ��ƴ����һ�飬���������̨��		
		 * 
		 */
		File fieldFile = new File("ziduan.txt");
		File valueFile = new File("zhi.txt");
		if(!fieldFile.exists() || !valueFile.exists()){
			return;
		}
		
//		outputToFile(fieldFile, valueFile);
		
		getTranslationResult(fieldFile, valueFile);
	}
	/**
	 * ���ļ��ж�ȡ������õ����ģ�ƴ�պô�ӡ������̨
	 * @param fieldFile
	 * @param valueFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void getTranslationResult(File fieldFile, File valueFile)
			throws FileNotFoundException, IOException {
		BufferedReader fieldBr = new BufferedReader(new FileReader(fieldFile));
		BufferedReader valueBr = new BufferedReader(new FileReader(valueFile));
		
		StringBuilder sb = new StringBuilder();
		String field = fieldBr.readLine();
		String value = valueBr.readLine();

		while (field != null && value != null) {
			value = value.replaceAll("��", "");
			value = value.replaceAll("��", "");
			sb.append(field+" = "+"\""+value+"\""+LINE_SEPARATOR);
			field = fieldBr.readLine();
			value = valueBr.readLine();
		}
		System.out.println();
		System.out.println(sb.toString());
	}
	
	/**
	 * ��Ӣ������������ļ�
	 * @param fieldFile
	 * @param valueFile
	 * @throws IOException
	 */
	public static void outputToFile(File fieldFile, File valueFile)
			throws IOException {
		BufferedReader confBr = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter fieldPt = new PrintWriter(new FileWriter(fieldFile),true);
		PrintWriter valuePt = new PrintWriter(new FileWriter(valueFile),true);
		
		String input = null;
		while(!"ok".equals(input = confBr.readLine())){
			String records[] = input.split("=");
			fieldPt.println(records[0]);
			valuePt.println(records[1]);
		}
		
		fieldPt.close();
		valuePt.close();
	}
	

}
