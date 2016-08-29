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
		// TODO 自动生成的方法存根
		/*
		 * Map
		 * 	|---Hashtable
		 * 		|---Properties
		 * 
		 * Properties集合：
		 * 特点：
		 * 		1、该集合中的键和值都是字符串类型
		 * 		2、集合中的数据可以保存在流中，或者从流中获取
		 * 
		 * 通常该集合用于操作一键值对行驶存在的配置文件中  .ini文件(Windows)  .properties文件(JAVA)
		 * 
		 */
//		propertiesDemo();
		//	存到文件里
//		propertiesDemo2();
		//	从文件里读
		propertiesDemo3();
		
	}
	
	private static void propertiesDemo3() throws IOException {
		// TODO 自动生成的方法存根
		
		Properties prop = new Properties();
		
		//	集合中的数据源自于一个文件
		//	需要保证该文件中的数据时键值对
		
		FileInputStream fis = new FileInputStream("in.ini");
		
		prop.load(fis);
		
		prop.list(System.out);
		
	}

	public static void propertiesDemo2() throws IOException {
		// TODO 自动生成的方法存根
		Properties prop = new Properties();

		// 存储元素
		prop.setProperty("02", "202");
		prop.setProperty("03", "203");
		prop.setProperty("04", "204");
		prop.setProperty("05", "205");
		prop.setProperty("06", "206");
		
		// 将其输出到文件
		FileOutputStream fos = new FileOutputStream("in.ini");
		
		prop.store(fos, "name=age");
		fos.close();
	}

	/*
	 * Properties集合的存和取
	 * 
	 */
	public static void propertiesDemo(){
		Properties prop = new Properties();

		// 存储元素
		prop.setProperty("02", "202");
		prop.setProperty("03", "203");
		prop.setProperty("04", "204");
		prop.setProperty("05", "205");
		prop.setProperty("06", "206");
		
		// 取出所有哦元素
		Set<String> names = prop.stringPropertyNames();
		
		for(String name : names){
			String value = prop.getProperty(name);
			System.out.println(name+"="+value);
		}
	}
}
