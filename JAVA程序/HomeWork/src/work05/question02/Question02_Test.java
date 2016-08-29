package work05.question02;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Question02_Test {

	public static void main(String[] args) {
		Properties prop = new Properties();
		File propFile = new File("src/work05/question02/implFlyer.properties");
		Flyer [] flyers = null;
//System.out.println(propFile.getAbsolutePath());
		if(propFile.exists()){
			String[] implClassNames = readProp(prop, propFile);
			flyers = creatObjects(implClassNames);
		}
//System.out.println(flyers);
		if(flyers != null){
			for (int i = 0; i < flyers.length; i++) {
				flyers[i].fly();
			}
		}
	}

	public static String[] readProp(Properties prop, File propFile) {
		try {
			prop.load(new FileReader(propFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String implClassNames [] = null;
		String keyOfValue = ((String)prop.get("classNames"));
		if(keyOfValue!=null){
			implClassNames  = keyOfValue.split(",");
		}
		return implClassNames;
	}

	private static Flyer[] creatObjects(String[] implClassNames) {
		if(null == implClassNames){
			return null;
		}
		List<Flyer> flyersList = new ArrayList<Flyer>();
		for (int i = 0; i < implClassNames.length; i++) {
			@SuppressWarnings("rawtypes")
			Class clazz = null;
//System.out.println(implClassNames[i]);
			try {
				//加载类的字节码文件
				clazz = Class.forName(implClassNames[i]);
				if (clazz != null) {
					//创建对象，添加到容器
					flyersList.add((Flyer) clazz.newInstance());
				}
			} catch (ReflectiveOperationException e) {
				e.printStackTrace();
			} 
		}
		Flyer flyers [] = new Flyer[flyersList.size()];
		flyersList.toArray(flyers);
		return flyers;
	}

}
