
class CDate{
private:
	int year;
	int month;
	int day;
public:
	CDate(int year,int month,int day);
	int GetYear() const{return year;}
	int GetMonth() const{return month;}
	int GetDay() const{return day;}
	int GetMaxDay()const;	//��ȡ�����ж�����
	bool IsLeapYear()const{
		return year%4==0 && year%100!=100 ||year%400==0;
	}
	void Show() const;		//�����ǰ����
};