package dj.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * 
 * JAVA �������������״̬�У������κ�һ���ࣨclass�ļ���������֪�����������Ժͷ���
 * ��������һ�����󣬶��ܹ�������������һ������������
 * ���ֶ�̬��ȡ����Ϣ�Ѿ���̬���ö��󷽷��Ĺ��ܳ�Ϊjava���Եķ�����ơ�
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
		// TODO �Զ����ɵķ������
		
		//���������ֻ��Class����ķ�ʽ
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
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		String className = "dj.reflect.demo.ReflectDemo";
		Class clazz = Class.forName(className);//ClassNotFoundException
		
		Field field = null;
//		field = clazz.getField("name");//ֻ�ܻ�ȡ���е�
//		field.setAccessible(true);//���Ա������ʣ�ȡ����˽���ֶε�Ȩ�޼��
		
		field = clazz.getDeclaredField("name");
//		System.out.println(field);
		
		Object obj = clazz.newInstance();
		
		Object fobj = field.get(obj);
		System.out.println(fobj);
		
		
	}
	
	public static void createNewObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO �Զ����ɵķ������
		//////	��������
		//	����
		dj.reflect.demo.ReflectDemo  rf = new dj.reflect.demo.ReflectDemo();
		
		//	����
		String className = "dj.reflect.demo.ReflectDemo";
		Class clazz = Class.forName(className);//ClassNotFoundException
		Object obj = clazz.newInstance();//InstantiationException

		//////	ֱ�ӻ�ù��캯��
		Constructor con = clazz.getConstructor(String.class,int.class);//NoSuchMethodException
		Object o = con.newInstance("sads",23);//IllegalArgumentException
		Constructor [] cons = clazz.getConstructors();
		
		
	}

}
