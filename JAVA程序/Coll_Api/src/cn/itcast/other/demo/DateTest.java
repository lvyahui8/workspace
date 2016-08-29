package cn.itcast.other.demo;

import java.text.DateFormat;
import java.text.ParseException;

/*
 * Date练习
 * "2014-1-1"到"2014-4-23"
 * 思路：
 * 两个日期相减
 * 怎么减
 * 必须是两个可以相减的数
 * 能减的就是毫秒值
 * 所以先将日期对象转换才毫秒值
 * 然后相减
 * 将相减后的毫秒值转换成天数
 */
public class DateTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*
		 * 
		 */
		
		String date2 = "2014-4-23";
		String date1 = "2014-1-1";
		int day = distance(date1,date2);
		System.out.println(day);
	}

	private static int distance(String date1, String date2) {
		// TODO 自动生成的方法存根
		DateFormat dateFormat = DateFormat.getDateInstance();
		int day = 0;
		try {
			long time1 = dateFormat.parse(date1).getTime();
			long time2 = dateFormat.parse(date2).getTime();
			long time = Math.abs(time2-time1);
			day = (int)(time/1000/60/60/24);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return day;
	}

}
