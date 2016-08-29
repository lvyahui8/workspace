package com.wyyfl.calendarnotepad.service.test;

import junit.framework.TestCase;

import com.wyyfl.calendarnotepad.service.CalendarManager;
import com.wyyfl.calendarnotepad.vo.Date;

public class CalendarManagerTest extends TestCase {
	public void testGetCurrentDate() {
		CalendarManager cal = new CalendarManager();
		Date date = cal.getCurrentDate();
		System.out.println(date);

	}

	public void testGetDates() {
		CalendarManager date = new CalendarManager();
		Date[][] dates = date.getDates(2014, 12);
		// date [0]=new Date[7];
		// date [1]=new Date[30];
		// date [2]=new Date[5];
		for (int i = 0; i < dates.length; i++) {
			for (int j = 0; j < dates[i].length; j++) {
				System.out.print(dates[i][j] + " ");

			}
			System.out.println();
		}
	}
}
