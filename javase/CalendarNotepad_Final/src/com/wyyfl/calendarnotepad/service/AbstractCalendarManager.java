package com.wyyfl.calendarnotepad.service;

import java.util.Calendar;

import com.wyyfl.calendarnotepad.vo.Date;
/**
 * ����������
 * @author Agrin
 * @version 1.0
 */
public abstract class AbstractCalendarManager {
	/**
	 * ÿ�µ���������
	 */
	public static final int MONTHDAYS_OF_YEAR [] ={
		0,31,28,31,30,31,30,31,31,30,31,30,31
	};
	
	protected Calendar c;
	/**
	 * �жϸ�������Ƿ�������
	 * @param year
	 * @return
	 */
	public  boolean isLeapYear(int year){
		return year%4==0 && year%100!=0 || year%400==0;
	}
	
	/**
	 * ��ȡ������ǰ����
	 * @return ����
	 */
	public abstract Date getCurrentDate();
	
	/**
	 * ���ݸ�������������������б�
	 * @param year ��
	 * @param month ��
	 * @return �����б�
	 */
	public abstract   Date [][] getDates(int year,int month);
	
}
