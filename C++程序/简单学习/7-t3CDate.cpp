
#include <iostream>
#include <cstdlib>
#include "7-t3CDate.h"
using std::cout;
using std::endl;
namespace {
	//����ƽ����ĳ���µ�1��֮ǰ�ж����죬Ϊ����GetMaxDay������ʵ�֣���������һ��
	const int DAYS_BEFORE_MONTH[]={0,31,59,90,120,151,181,212,243,273,304,334,365};
}

CDate::CDate(int year,int month,int day):year(year),month(month),day(day){
	if(day<=0 || day>GetMaxDay()){
		cout<<"������Ч"<<endl;
	}
}

int CDate::GetMaxDay() const{
	if(IsLeapYear() && month==2)
		return 29;
	else
		return DAYS_BEFORE_MONTH[month]-DAYS_BEFORE_MONTH[month-1];
}
void CDate::Show() const{
	cout<<GetYear()<<'-'<<GetMonth()<<'-'<<GetDay();
}