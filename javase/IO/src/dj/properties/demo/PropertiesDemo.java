package dj.properties.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

@SuppressWarnings("unused")
public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		/*
		 * Map
		 * 	|---Hashtable
		 * 		|---Properties
		 * 
		 * Properties���ϣ�
		 * �ص㣺
		 * 		1���ü����еļ���ֵ�����ַ�������
		 * 		2�������е����ݿ��Ա��������У����ߴ����л�ȡ
		 * 
		 * ͨ���ü������ڲ���һ��ֵ����ʻ���ڵ������ļ���  .ini�ļ�(Windows)  .properties�ļ�(JAVA)
		 * 
		 */
//		propertiesDemo();
		//	�浽�ļ���
//		propertiesDemo2();
		//	���ļ����
		propertiesDemo3();
		
	}
	
	private static void propertiesDemo3() throws IOException {
		// TODO �Զ����ɵķ������
		
		Properties prop = new Properties();
		
		//	�����е�����Դ����һ���ļ�
		//	��Ҫ��֤���ļ��е�����ʱ��ֵ��
		
		FileInputStream fis = new FileInputStream("in.ini");
		
		prop.load(fis);
		
		prop.list(System.out);
		
	}

	public static void propertiesDemo2() throws IOException {
		// TODO �Զ����ɵķ������
		Properties prop = new Properties();

		// �洢Ԫ��
		prop.setProperty("02", "202");
		prop.setProperty("03", "203");
		prop.setProperty("04", "204");
		prop.setProperty("05", "205");
		prop.setProperty("06", "206");
		
		// ����������ļ�
		FileOutputStream fos = new FileOutputStream("in.ini");
		
		prop.store(fos, "name=age");
		fos.close();
	}

	/*
	 * Properties���ϵĴ��ȡ
	 * 
	 */
	public static void propertiesDemo(){
		Properties prop = new Properties();

		// �洢Ԫ��
		prop.setProperty("02", "202");
		prop.setProperty("03", "203");
		prop.setProperty("04", "204");
		prop.setProperty("05", "205");
		prop.setProperty("06", "206");
		
		// ȡ������ŶԪ��
		Set<String> names = prop.stringPropertyNames();
		
		for(String name : names){
			String value = prop.getProperty(name);
			System.out.println(name+"="+value);
		}
	}
}
