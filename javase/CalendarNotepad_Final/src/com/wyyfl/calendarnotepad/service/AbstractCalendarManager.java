package com.wyyfl.calendarnotepad.service;

import java.util.Calendar;

import com.wyyfl.calendarnotepad.vo.Date;
/**
 * 日历管理者
 * @author Agrin
 * @version 1.0
 */
public abstract class AbstractCalendarManager {
	/**
	 * 每月的最少天数
	 */
	public static final int MONTHDAYS_OF_YEAR [] ={
		0,31,28,31,30,31,30,31,31,30,31,30,31
	};
	
	protected Calendar c;
	/**
	 * 判断给定年份是否是闰年
	 * @param year
	 * @return
	 */
	public  boolean isLeapYear(int year){
		return year%4==0 && year%100!=0 || year%400==0;
	}
	
	/**
	 * 获取本机当前日期
	 * @return 日期
	 */
	public abstract Date getCurrentDate();
	
	/**
	 * 根据给定的年和月生成日期列表
	 * @param year 年
	 * @param month 月
	 * @return 日期列表
	 */
	public abstract   Date [][] getDates(int year,int month);
	
}
