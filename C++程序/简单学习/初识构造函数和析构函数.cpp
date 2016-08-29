#include <iostream>
using std::cout;
using std::endl;

class Clock
{
private:
	int hour,minute,second;
public:
	Clock(int newH,int newM,int newS);		//带参数的构造函数
	Clock();								//构造函数重载
	~Clock(){};								//析构函数，函数体为空不代表不会做事。
	void Showtime();
};

Clock::Clock()
{
	hour=0;minute=0;second=0;
}

Clock::Clock(int newH,int newM,int newS)
{
	hour=newH;
	minute=newM;
	second=newS;
}

inline void Clock::Showtime()
{
	cout<<"The time: "<<hour<<':'<<minute<<':'<<second<<endl;
}

void main()
{
	Clock myClock1(12,6,30);			//调用带参数的构造函数
	myClock1.Showtime();
	Clock myClock2;						//调用不带参数的构造函数
	myClock2.Showtime();
}