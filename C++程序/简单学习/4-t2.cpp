
#include <iostream>
#include <iomanip>
using std::cout;
using std::cin;
using std::endl;
using std::setw;

//定义日期类
class Date
{
private:
	unsigned short year;
	unsigned short month;
	unsigned short day;
public:
	Date(unsigned short y=0,						//构造函数
		unsigned short m=0,
		unsigned short d=0);
	Date(Date & p);									//复制构造函数
	void setDate(unsigned short y=0,
		unsigned short m=0,
		unsigned short d=0);
	void showDate()									//输出函数
	{
		cout<<setw(6)<<year
			<<'.'<<setw(2)<<month
			<<'.'<<setw(2)<<day<<endl;
	}
	~Date(){}
};

Date::Date(unsigned short y,				
		unsigned short m,
		unsigned short d){
	year=y;month=m;day=d;
}

Date::Date(Date & p)
{
	year = p.year;
	month = p.month;
	day = p.day;
}

inline void Date::setDate(unsigned short y,
		unsigned short m,
		unsigned short d){
	year=y;month=m;day=d;
}




//定义人员类
class Person
{
private:
	unsigned num;
	char sex;
	Date date;										//内嵌日期类对象date
	unsigned long id;
public:
	Person(unsigned n,char s,Date d,unsigned long i);	//组合类的构造函数
	Person(Person & P);									//组合类的复制构造函数
	void Entry();
	void Show();
	~Person(){}
};
//组合类的构造函数
Person::Person(unsigned n,char s,
			   Date d,unsigned long i=0)
			   :date(d){
	num=n;sex=s;id=i;
}
//组合类的复制构造函数
Person::Person(Person & P):date(P.date)
{
	num = P.num;
	sex = P.sex;
	id = P.id;
}
//录入函数
void Person::Entry()
{
	int y,m,d;					//因为不能直接使用日期类对象的私有成员。所以需要用其余变量保存日期

	cin>>num;
	cin>>sex;
//	cin>>y>>".">>m>>".">>d;		//不能这么录入
	cin>>y>>m>>d;
	cin>>id;
	date.setDate(y,m,d);		//
}
//输出函数
inline void Person::Show()
{
	cout<<"编号:"<<setw(16)<<num<<endl;
	cout<<"性别:"<<setw(16)<<sex<<endl;
	cout<<"出生日期:";
	date.showDate();
	cout<<"身份证号:"<<setw(12)<<id<<endl;
}

void main()
{		
	Date D(1994,8,16);								//建立日期对象 D
	Person P1(1,'G',D,2012060),P2(P1);				//建立两个人员类对象P1,P2
	P1.Show();										//显示P1,P2的数据成员
	P2.Show();
	D.setDate(2012,6,8);							//调整日期对象D
	Person P3(3,'M',D,2012007);						//建立人员对象 P3
	P3.Show();
	P3.Entry();										//P3 进行录入
	P3.Show();
}
