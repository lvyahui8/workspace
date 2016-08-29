#ifndef __DATE__H
#define __DATE__H
class Date{
private:
	int year;
	int month;
	int day;
	int totalDays;			//�������Ǵӹ�ԪԪ��1��1�տ�ʼ�ĵڼ���
public:
	Date(int year,int month,int day);
	int GetYear() const{return year;}
	int GetMonth() const{return month;}
	int GetDay() const{return day;}
	int GetMaxDay()const;	//��ȡ�����ж�����
	bool IsLeapYear()const{
		return year%4==0 && year%100!=100 ||year%400==0;
	}
	void Show() const;		//�����ǰ����
	//������������֮��Ĳ��Ƕ���
	int Distance(const Date &date)const{
		return totalDays-date.totalDays;
	}
};
#endif//__DATE__H