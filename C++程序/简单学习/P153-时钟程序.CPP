#include <iostream>

using std::cout;
using std::cin;
using std::endl;

class Clock
{
private:
	int hour,minute,second;
public:
	Clock();
	void setTime(int newH,int newM,int newS);		//3个形参均具有函数原型作用域
	void showTime();
};

//时钟类成员函数实现
Clock::Clock():hour(0),minute(0),second(0) {}		//构造函数

void Clock::setTime(int newH,int newM,int newS)		//3个形参均具有局部作用域
{
	hour=newH;
	minute=newM;
	second=newS;
}

void Clock::showTime()
{
	cout<<hour<<":"<<minute<<":"<<second<<endl;
}

Clock globClock;		//声明对象globClock，具有静态生存期，命名空间作用域
//由默认构造函数初始化为 0:0:0

int main()
{
	cout<<"First time output:"<<endl;
	//引用具有命名空间作用域的对象 globClock
	globClock.showTime();							//对象的成员具有类作用域

	globClock.setTime(8,32,12);

	Clock myClock(globClock);						//声明具有块作用域的对象 myClock

	cout<<"Second time output:"<<endl;
	myClock.showTime();
}
