#ifndef __ACCUMULATOR__H
#define __ACCUMULATOR__H
#include "date.h"
class Accumulator{						//��ĳ����ֵ�����ۼ�
private:
	Date lastDate;						//�ϴα����ֵ������
	double value;						//��ֵ�ĵ�ǰֵ
	double sum;							//��ֵ�İ����ۼ�֮��
public:
	//dateΪ��ʼ�ۼӵ����ڣ�valueΪ��ʼֵ
	Accumulator(const Date &date,double value)
		:lastDate(date),value(value),sum(0){}
	//�������date���ۼӽ��
	double GetSum(const Date &date) const{
		return sum+value*date.Distance(lastDate);
	}
	//��date����ֵ���Ϊvalue
	void Change(const Date &date,double value){
		sum = GetSum(date);
		lastDate = date;this->value = value;
	}
	//��ʼ���������ڱ�Ϊdate����ֵ��Ϊvalue���ۼ�������
	void Reset(const Date & date,double value){
		lastDate = date;
		this->value = value; sum = 0;
	}
};
#endif//__ACCUMULATOR__H