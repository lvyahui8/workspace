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
 * 将joomla插件汉化
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
		 * 方法
		 * 
		 * 在控制台输入英文配置		字段=“值”
		 * 
		 * 从文件1当中逐行读取，拆分成字段 和 值，分别输出到两个文件中，ziduan.txt  和  zhi.txt中
		 * 
		 * 将值当中的内容翻译好
		 * 
		 * 然后再从两个文件中读数据，然后拼凑在一块，输出到控制台中		
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
	 * 从文件中读取出翻译好的中文，拼凑好打印到控制台
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
			value = value.replaceAll("“", "");
			value = value.replaceAll("”", "");
			sb.append(field+" = "+"\""+value+"\""+LINE_SEPARATOR);
			field = fieldBr.readLine();
			value = valueBr.readLine();
		}
		System.out.println();
		System.out.println(sb.toString());
	}
	
	/**
	 * 将英文配置输出到文件
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
