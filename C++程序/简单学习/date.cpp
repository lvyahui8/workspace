#include "date.h"
#include <iostream>
#include <cstdlib>
using namespace std;
namespace {
	//����ƽ����ĳ���µ�1��֮ǰ�ж����죬Ϊ����GetMaxDay������ʵ�֣���������һ��
	const int DAYS_BEFORE_MONTH[]={0,31,59,90,120,151,181,212,243,273,304,334,365};
}
Date::Date(int year,int month,int day):year(year),month(month),day(day){
	if(day<=0 || day>GetMaxDay()){
		cout<<"Invalid date: ";
		Show();
		cout<<endl;
		exit(1);
	}
	int years = year-1;
	totalDays = years*365+years/4-years/100+years/400
		+DAYS_BEFORE_MONTH[month-1]+day;
	if(IsLeapYear() && month>2)  totalDays++;
}

int Date::GetMaxDay() const{
	if(IsLeapYear() && month==2)
		return 29;
	else
		return DAYS_BEFORE_MONTH[month]-DAYS_BEFORE_MONTH[month-1];
}
void Date::Show() const{
	cout<<GetYear()<<'-'<<GetMonth()<<'-'<<GetDay();
}
