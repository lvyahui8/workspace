#ifndef __ACCUMULATOR__H
#define __ACCUMULATOR__H
#include "date.h"
class Accumulator{						//将某个数值按日累加
private:
	Date lastDate;						//上次变更数值的日期
	double value;						//数值的当前值
	double sum;							//数值的按日累加之和
public:
	//date为开始累加的日期，value为初始值
	Accumulator(const Date &date,double value)
		:lastDate(date),value(value),sum(0){}
	//获得日期date的累加结果
	double GetSum(const Date &date) const{
		return sum+value*date.Distance(lastDate);
	}
	//在date将数值变更为value
	void Change(const Date &date,double value){
		sum = GetSum(date);
		lastDate = date;this->value = value;
	}
	//初始化，将日期变为date，数值变为value，累加器清零
	void Reset(const Date & date,double value){
		lastDate = date;
		this->value = value; sum = 0;
	}
};
#endif//__ACCUMULATOR__H