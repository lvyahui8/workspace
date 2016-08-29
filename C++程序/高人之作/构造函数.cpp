
#include<iostream>
using namespace std;


//这里，封装了时钟的数据和行为，分别称为Clock类的数据成员和函数成员。
class Clock             //时钟类的定义
{
public:                 //外部接口，共有成员函数。    外部接口：可以供其他函数访问、调用。
	Clock();  //构造函数
	Clock(const Clock& theClock){
		this->hour = theClock.hour;
		this->minute = theClock.minute;
		this->second = theClock.second;
	}
	void setTime(int newH,int newM,int newS);
	void showTime();
private:                 //私有数据成员
	int hour,minute,second;
};

Clock::Clock()
{
	hour=0;
	minute=0;
	second=0;
}
void Clock::setTime(int newH,int newM,int newS)
{
	hour=newH;
	minute=newM;
	second=newS;
}


inline void Clock::showTime()    //内敛成员函数的显式声明
{
	cout<<hour<<":"<<minute<<":"<<second<<endl;
}

int main()
{
	Clock c;
	Clock newClock(c);
	Clock * pNewClock = &newClock;
	cout<<"First time set and output:"<<endl;
	c.showTime();        //显示时间
	cout<<"Second time set and output:"<<endl;
	c.setTime(8,30,30);   //设置时间为8:3:30
	return 0;
}
