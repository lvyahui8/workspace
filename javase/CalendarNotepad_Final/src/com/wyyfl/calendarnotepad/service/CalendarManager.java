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
	public Date getCurrentDate() {//�õ���ǰ�����ʱ��
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
		Date [][] dates = new Date[3][];//����һ����ά����
		int firstDayOnWeek,thisMonthDays,nextMonthDays;
		firstDayOnWeek = c.get(Calendar.DAY_OF_WEEK);
		if (firstDayOnWeek == 1) {// ���µ�һ��Ϊ�ܼ�����һΪ2
			firstDayOnWeek = 7;
		} else {
			firstDayOnWeek -= 1;// ������ʾ����:���µ�һ��Ϊ���ڼ���
								// i��Ϊ����Ϊ��ĩʱi=7��
		}
				
		
		//Ӌ���ς���
		dates[0] = new Date[firstDayOnWeek];//��һ���ж��ٸ�����ͨ��ǰ��ķ��������
		int privMonthReallYear = year;//��һ����ʵ�ʵ����
		int privMonthReallMonth = month - 1;//��һ����ʵ�ʵ��·�
		if(1 == month){
			privMonthReallYear -= 1;
			privMonthReallMonth = 12;
		}
		int privMonthReallDays = MONTHDAYS_OF_YEAR[privMonthReallMonth];//��һ����ʵ�ʵ�����
		if(isLeapYear(year) && 2 == privMonthReallMonth){
			privMonthReallDays+=1;
		}
		for(int t=0;t<firstDayOnWeek;t++){
			dates[0][t] = new Date();//��ʼ������Ȼ���õĶ��ǿյ�
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
		
		//Ӌ�㮔��
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
		
		//Ӌ������
		nextMonthDays=42-firstDayOnWeek-thisMonthDays;//������ʾ����
		int nextMonthReallYear = year;//��һ�����H���
		int nextMonthReallMonth = month+1;//��һ�����H�·�
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
