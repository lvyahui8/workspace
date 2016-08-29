package cn.itcast.other.demo;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SystemDemo {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
//		long time1 = System.currentTimeMillis();
//		System.out.println(time1);
//		
//		long time2 = System.currentTimeMillis();
//		System.out.println(time2 - time1);
		
//		demo_1();
//		System.out.println("Hello-"/*不同系统换行不一样\n，所以使用系统函数确认*/+System.getProperty("line.separator")+"-World");
		System.out.println("Hello-"/*不同系统换行不一样\n，所以使用系统函数确认*/+LINE_SEPARATOR+"-World");
	}

	public static void demo_1() {
		// TODO 自动生成的方法存根
		Properties prop = System.getProperties();
//		System.out.println(prop);
		Set<String> infoKey = prop.stringPropertyNames();
		
		for(String name : infoKey){
			String value = prop.getProperty(name);
			System.out.println(name+"      :      "+value);
		}
	}

}
