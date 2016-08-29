package cn.itcast.other.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		long time = System.currentTimeMillis();
		
		System.out.println(time);
		
		Date date1 = new Date();// 将当前日期封装成对象
		System.out.println(date1);
		
		Date date2 = new Date(time/10);//	将指定毫秒值封装成Date对象
		System.out.println(date2);
		
		/*
		 * 日期对象转换成毫秒值
		 * 毫秒值->对象
		 * 		通过new Date对象
		 * 		通过Date对象的方法，通过setTime();
		 * 对象->毫秒值
		 * 		long getTime();
		 */
		
		
		dateToFormatString(date1);
		String theDate = "1974-5-29";
		FormatStringToDate(theDate);
	}

	public static void FormatStringToDate(String theDate) {
		// TODO 自动生成的方法存根
		/*
		 * 将日期格式的字符串，转换成日期对象
		 * 		使用的是DateFormat中的
		 */
		DateFormat  dateFormat = DateFormat.getDateInstance();
		
		try {
			Date date = dateFormat.parse(theDate);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	/**
	 * @param date1
	 */
	private static void dateToFormatString(Date date1) {
		/*
		 * 
		 * 对日期进行格式化。
		 * 将日期对象转换成日期格式的字符串
		 * 		使用DateFormat类中的format方法
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
		
		System.out.println(dateTimeFormat);	//	其实是使用的子类的对象
		
		//	自定义日期格式
		
		dateTimeFormat = new SimpleDateFormat("yyyy#MM#dd--HH#mm");
		String dateTime_2 = dateTimeFormat.format(date1);
		System.out.println("自定义:"+dateTime_2);
	}

}
