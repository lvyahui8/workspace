
#include <iostream>
#include <iomanip>
#include <cmath>
using std::cout;
using std::cin;
using std::endl;
using std::setw;

class Dot
{
private:
	int x,y;
public:
	Dot(int a=0,int b=0);
	Dot(float a,float b);
	~Dot(){}
	int getx(){return x;}
	int gety(){return y;}
};

Dot::Dot(int a,int b)
{
	x=a;y=b;
}

Dot::Dot(float a,float b)
{
	x=a;y=b;
}

class Distance
{
private:
	Dot d1,d2;
public:
	Distance(Dot md1,Dot md2);
	Distance(Dot m);
	int Count();
};
Distance::Distance(Dot md1,Dot md2):d1(md1),d2(md2)
{
}
Distance::Distance(Dot m):d2(m)
{
}
int Distance::Count()
{
	return sqrt( pow(d2.getx()-d1.getx(),2) + pow(d2.gety()-d1.gety(),2) );
}

void main()
{
	Dot m(0,0);
	Dot m1(3,4);
	//下面的情况会调用重载构造函数
	float a=3.6,b=4.5;
	Dot m2(a,b);
	Dot m3(3.6F,4.5F);
	Dot m4(3.6F,4.5L);
	Dot m5(3.6L,4.5F);

	Distance md1(m,m1);				
	cout<<md1.Count()<<endl;
	Distance md2(m1);			//调用重载构造函数
	cout<<md1.Count()<<endl;
}