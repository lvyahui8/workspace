#ifndef __DATE__H
#define __DATE__H
class Date{
private:
	int year;
	int month;
	int day;
	int totalDays;			//该日期是从公元元年1月1日开始的第几天
public:
	Date(int year,int month,int day);
	int GetYear() const{return year;}
	int GetMonth() const{return month;}
	int GetDay() const{return day;}
	int GetMaxDay()const;	//获取当月有多少天
	bool IsLeapYear()const{
		return year%4==0 && year%100!=100 ||year%400==0;
	}
	void Show() const;		//输出当前日期
	//计算两个日期之间的差是多少
	int Distance(const Date &date)const{
		return totalDays-date.totalDays;
	}
};
#endif//__DATE__H