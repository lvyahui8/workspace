package cn.itcast.other.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		long time = System.currentTimeMillis();
		
		System.out.println(time);
		
		Date date1 = new Date();// ����ǰ���ڷ�װ�ɶ���
		System.out.println(date1);
		
		Date date2 = new Date(time/10);//	��ָ������ֵ��װ��Date����
		System.out.println(date2);
		
		/*
		 * ���ڶ���ת���ɺ���ֵ
		 * ����ֵ->����
		 * 		ͨ��new Date����
		 * 		ͨ��Date����ķ�����ͨ��setTime();
		 * ����->����ֵ
		 * 		long getTime();
		 */
		
		
		dateToFormatString(date1);
		String theDate = "1974-5-29";
		FormatStringToDate(theDate);
	}

	public static void FormatStringToDate(String theDate) {
		// TODO �Զ����ɵķ������
		/*
		 * �����ڸ�ʽ���ַ�����ת�������ڶ���
		 * 		ʹ�õ���DateFormat�е�
		 */
		DateFormat  dateFormat = DateFormat.getDateInstance();
		
		try {
			Date date = dateFormat.parse(theDate);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	/**
	 * @param date1
	 */
	private static void dateToFormatString(Date date1) {
		/*
		 * 
		 * �����ڽ��и�ʽ����
		 * �����ڶ���ת�������ڸ�ʽ���ַ���
		 * 		ʹ��DateFormat���е�format����
		 */
		String myString = DateFormat.getDateInstance().format(date1);
		
		System.out.println(myString);
		
//		DateFormat dateFormat = DateFormat.getDateInstance();
//		
//		for (int i = 0; i < 8; i++) {
//			String string = dateFormat.format(new Date());
//			System.out.println(string);
//		}
		
		DateFormat dateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.LONG); 
		
		String dateTime = dateTimeFormat.format(date1);
		System.out.println(dateTime);
		
		System.out.println(dateTimeFormat);	//	��ʵ��ʹ�õ�����Ķ���
		
		//	�Զ������ڸ�ʽ
		
		dateTimeFormat = new SimpleDateFormat("yyyy#MM#dd--HH#mm");
		String dateTime_2 = dateTimeFormat.format(date1);
		System.out.println("�Զ���:"+dateTime_2);
	}

}
