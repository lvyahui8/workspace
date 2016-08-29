
#include <iostream>
#include <cstdlib>
#include "7-t3CDate.h"
using std::cout;
using std::endl;
namespace {
	//储存平年中某个月的1日之前有多少天，为方便GetMaxDay函数的实现，该数组多出一项
	const int DAYS_BEFORE_MONTH[]={0,31,59,90,120,151,181,212,243,273,304,334,365};
}

CDate::CDate(int year,int month,int day):year(year),month(month),day(day){
	if(day<=0 || day>GetMaxDay()){
		cout<<"日期无效"<<endl;
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