package com.wyyfl.calendarnotepad.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.wyyfl.calendarnotepad.vo.Date;

public class CalendarManager extends AbstractCalendarManager {

	
	public CalendarManager() {
		super();
		c = new GregorianCalendar();
	}

	@Override
	public Date getCurrentDate() {//得到当前计算机时间
		// TODO Auto-generated method stub
		Date cureent = new Date();
		cureent.setYear(c.get(Calendar.YEAR));
		cureent.setMonth(c.get(Calendar.MONDAY)+1);
		cureent.setDay(c.get(Calendar.DAY_OF_MONTH));
		return  cureent;
	}

	@Override
	public Date[][] getDates(int year, int month) {
		c = Calendar.getInstance();
		c.set(year,month-1,1);
		Date [][] dates = new Date[3][];//创建一个二维数组
		int firstDayOnWeek,thisMonthDays,nextMonthDays;
		firstDayOnWeek = c.get(Calendar.DAY_OF_WEEK);
		if (firstDayOnWeek == 1) {// 本月第一天为周几？周一为2
			firstDayOnWeek = 7;
		} else {
			firstDayOnWeek -= 1;// 上月显示天数:本月第一天为星期几，
								// i就为几，为周末时i=7；
		}
				
		
		//計算上個月
		dates[0] = new Date[firstDayOnWeek];//第一组有多少个数，通过前面的方法算出来
		int privMonthReallYear = year;//上一个月实际的年份
		int privMonthReallMonth = month - 1;//上一个月实际的月份
		if(1 == month){
			privMonthReallYear -= 1;
			privMonthReallMonth = 12;
		}
		int privMonthReallDays = MONTHDAYS_OF_YEAR[privMonthReallMonth];//上一个月实际的天数
		if(isLeapYear(year) && 2 == privMonthReallMonth){
			privMonthReallDays+=1;
		}
		for(int t=0;t<firstDayOnWeek;t++){
			dates[0][t] = new Date();//初始化，不然引用的都是空的
			dates[0][t].setYear(privMonthReallYear);
			dates[0][t].setMonth(privMonthReallMonth);
			dates[0][t].setDay(privMonthReallDays - firstDayOnWeek + t + 1);
		
//			int p=0;
//			if(month==1){
//				dates[0][t].setYear(year-1);
//				dates[0][t].setMonth(12);
//				p=MONTHDAYS_OF_YEAR [12]-firstDayOnWeek+1;
//				}
//			else
//			{
//				dates[0][t].setYear(year);
//				dates[0][t].setMonth(month-1);
//				p=MONTHDAYS_OF_YEAR [month-1]-firstDayOnWeek+1;
//			}
//			dates[0][t].setDay(p+t);
		}
		
		//計算當月
		thisMonthDays = MONTHDAYS_OF_YEAR[month];
		if(isLeapYear( year) && 2 == month){
			thisMonthDays+=1;
		}
		dates[1] = new Date[thisMonthDays];
		for (int t = 0; t < thisMonthDays; t++) {
			dates[1][t] = new Date();
			dates[1][t].setYear(year);
			dates[1][t].setMonth(month);
			dates[1][t].setDay(t + 1);
		}
		
		//計算下月
		nextMonthDays=42-firstDayOnWeek-thisMonthDays;//下月显示天数
		int nextMonthReallYear = year;//下一個月實際年份
		int nextMonthReallMonth = month+1;//下一個月實際月份
		if(12 == month){
			nextMonthReallYear +=1;
			nextMonthReallMonth = 1;
		}
		dates[2] =new Date[nextMonthDays];
		for(int t=0;t<nextMonthDays;t++){
			dates[2][t] = new Date();
			dates[2][t].setYear(nextMonthReallYear);
			dates[2][t].setMonth(nextMonthReallMonth);
			dates[2][t].setDay(t + 1);
//			if(month==12){
//				dates[2][t].setYear(year+1);
//				dates[2][t].setMonth(1);
//			}
//			else
//			{
//				dates[2][t].setYear(year);
//				dates[2][t].setMonth(month+1);
//			}
//			dates[2][t].setDay(t+1);
		}
		// TODO Auto-generated method stub
		
		return dates;
	}

}
