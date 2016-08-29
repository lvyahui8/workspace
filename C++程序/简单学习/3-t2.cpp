#include <iostream>

using std::cout;
using std::endl;
using std::cin;

class Date
{
private:
	int year;
	int month;
	int day;
public:
	Date(int y,int m=0,int d=0)					//���캯��
	{
		this->year=y;
		this->month=m;
		this->day=d;
	}
	Date(Date & p);							//���ƹ��캯��
	void setDate(int newY,int newM,int newD);
	void showDate();
	void Datejy(int jj)
	{
		day+=jj;
	}
	void Datedy(int dj)
	{
		day-=dj;
	}
};

Date::Date(Date & p)						//���帴�ƹ��캯������
{
	year=p.year;
	month=p.month;
	day=p.day;
}
		//  ���ú���
inline void Date::setDate(int newY=0,int newM=0,int newD=0)
{
	year=newY;month=newM;day=newD;
	cout<<"���óɹ���\n";
}

void Date::showDate()
{
	cout<<"This time:  "<<year<<'/'
		<<month<<'/'<<day<<endl;
}

void main()
{
	Date D1(2012,6,8),D2(2012);
	D1.showDate();
	D2.showDate();
	
	int y,m,d;
	cin>>y>>m>>d;
	D1.setDate(y,m,d);
	D1.showDate();

	D1.Datedy(3);		//������
	D1.Datejy(5);		//������
	
	D1.showDate();
}