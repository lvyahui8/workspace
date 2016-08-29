package cn.itcast.other.demo;

import java.util.Calendar;

public class CalendarDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		demo1();
//		demo2();
		int year = 2014;
		int days = februaryHasDays(year);
		System.out.println(days);
	}

	private static int februaryHasDays(int year) {
		// TODO 自动生成的方法存根
		Calendar cal = Calendar.getInstance();
		cal.set(year,2,1 );
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	private static void demo2() {
		// TODO 自动生成的方法存根
		Calendar cal = Calendar.getInstance();
		cal.set(2012, 6, 8);
		System.out.println(cal.get(Calendar.YEAR) + " "
				+ cal.get(Calendar.MONTH) + " "
				+ cal.get(Calendar.DAY_OF_MONTH));
		cal.add(Calendar.DAY_OF_MONTH, 3);
		System.out.println(cal.get(Calendar.YEAR) + " "
				+ cal.get(Calendar.MONTH) + " "
				+ cal.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * 
	 */
	public static void demo1() {
		Calendar cal = Calendar.getInstance();

		// System.out.println(cal);
		/*
		 * java.util.GregorianCalendar
		 * [time=1390115653084,areFieldsSet=true,areAllFieldsSet=true,
		 * lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",
		 * offset=28800000,dstSavings=0,useDaylight=false,transitions=19,
		 * lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,
		 * YEAR=2014,MONTH=0,WEEK_OF_YEAR=4,WEEK_OF_MONTH=4,DAY_OF_MONTH=19,
		 * DAY_OF_YEAR=19,DAY_OF_WEEK=1,DAY_OF_WEEK_IN_MONTH=3,AM_PM=1,HOUR=3,
		 * HOUR_OF_DAY
		 * =15,MINUTE=14,SECOND=13,MILLISECOND=84,ZONE_OFFSET=28800000,
		 * DST_OFFSET=0]
		 */
		System.out.println(cal.get(Calendar.YEAR) + "&&"
				+ (cal.get(Calendar.MONTH) + 1) + "&&"
				+ cal.get(Calendar.DAY_OF_MONTH) + " " + "星期"
				+ cal.get(Calendar.DAY_OF_WEEK));
	}

}
