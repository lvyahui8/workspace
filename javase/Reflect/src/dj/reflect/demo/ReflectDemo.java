package dj.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * 
 * JAVA 反射机制在运行状态中，对于任何一个类（class文件），都能知道这个类的属性和方法
 * 对于任意一个对象，都能够调用它的任意一个方法和属性
 * 这种动态获取的信息已经动态调用对象方法的功能称为java语言的反射机制。
 *  
 * 
 * 
 */
public class ReflectDemo {
	private String name;
	private int num;
	
	{
		name = null;
		num = 0 ;
	}
	
	public ReflectDemo(){
		
	}
	public ReflectDemo(String str,int num){
		System.out.println(str+"..."+num);
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, Exception {
		// TODO 自动生成的方法存根
		
		//下面是三种获得Class对象的方式
//		Class clazz1 = ReflectDemo.class;
//		ReflectDemo rf = new ReflectDemo();
//		Class clazz2 = rf.getClass();
//		
//		Class clazz3 = Class.forName("dj.reflect.demo.ReflectDemo");
		
//		createNewObject();
//		getFieldsDemo();
		getMethodDemo();
	}

	public static void getMethodDemo() throws Exception {
		// TODO 自动生成的方法存根
		String className = "dj.reflect.demo.ReflectDemo";
		Class clazz = Class.forName(className);//ClassNotFoundException
		Method [] methods = clazz.getMethods();
		
		for(Method method : methods){
			System.out.println(method);
		}
		
		Method method = clazz.getMethod("createNewObject", null);
		System.out.println(method);
	}
	public static void getFieldsDemo() throws ClassNotFoundException, NoSuchFieldException, SecurityException, Exception, IllegalAccessException {
		// TODO 自动生成的方法存根
		String className = "dj.reflect.demo.ReflectDemo";
		Class clazz = Class.forName(className);//ClassNotFoundException
		
		Field field = null;
//		field = clazz.getField("name");//只能获取公有的
//		field.setAccessible(true);//可以暴力访问，取消对私有字段的权限检查
		
		field = clazz.getDeclaredField("name");
//		System.out.println(field);
		
		Object obj = clazz.newInstance();
		
		Object fobj = field.get(obj);
		System.out.println(fobj);
		
		
	}
	
	public static void createNewObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO 自动生成的方法存根
		//////	创建对象
		//	早期
		dj.reflect.demo.ReflectDemo  rf = new dj.reflect.demo.ReflectDemo();
		
		//	现在
		String className = "dj.reflect.demo.ReflectDemo";
		Class clazz = Class.forName(className);//ClassNotFoundException
		Object obj = clazz.newInstance();//InstantiationException

		//////	直接获得构造函数
		Constructor con = clazz.getConstructor(String.class,int.class);//NoSuchMethodException
		Object o = con.newInstance("sads",23);//IllegalArgumentException
		Constructor [] cons = clazz.getConstructors();
		
		
	}

}
