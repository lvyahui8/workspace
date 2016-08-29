
#include <iostream>
#include <iomanip>
using std::cout;
using std::cin;
using std::endl;
using std::setw;

//定义日期类
class Date{
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
	void showDate(){								//内联输出函数
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

Date::Date(Date & p){
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
class Person{
private:
	unsigned num;					//编号
	char sex;						//性别
	Date date;						//生日
	unsigned long id;				//身份证
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
Person::Person(Person & P):date(P.date){
	num = P.num;
	sex = P.sex;
	id = P.id;
}
//录入函数
void Person::Entry(){
	int y,m,d;					//因为不能直接使用日期类对象的私有成员。所以需要用其余变量保存日期
	cout<<"录入人员（根据提示输入）"<<endl;
	cout<<"姓名（回车）";
	cin>>num;
	cout<<"性别（回车）";
	cin>>sex;
//	cin>>y>>".">>m>>".">>d;		//不能这么录入
	cout<<"生日（中间用空格隔开，如1994 8 16，然后回车）\n";
	cin>>y>>m>>d;
	cout<<"身份证（回车）";
	cin>>id;
	date.setDate(y,m,d);		//
}
//输出函数
inline void Person::Show(){
	cout<<"编号:"<<setw(16)<<num<<endl;
	cout<<"性别:"<<setw(16)<<sex<<endl;
	cout<<"出生日期:";
	date.showDate();
	cout<<"身份证号:"<<setw(12)<<id<<endl;
}
void main(){		
	Date D(1994,8,16);								//建立日期对象 D
	Person P1(1,'G',D,2012060),P2(P1);				//建立两个人员类对象P1,P2
	P1.Show();										//显示P1,P2的数据成员
	cout<<"已有成员"<<endl;
	P2.Show();
	D.setDate(2012,6,8);							//调整日期对象D
	cout<<"\n\n新建成员"<<endl;
	Person P3(3,'M',D,2012007);						//建立人员对象 P3
	P3.Entry();										//P3 进行录入
	P3.Show();
}
