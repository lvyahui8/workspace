#include <iostream>
#include <cmath>
using std::cout;
using std::endl;

class Point							//Point类定义
{
private:
	int x,y;
public:
	Point(int xx=0,int yy=0)
	{
		x=xx;
		y=yy;
	}
	Point(Point &p);				//复制构造函数
	int getX()	{return x;}
	int getY()	{return y;}
};

Point::Point(Point &p)				//复制构造函数的实现
{
	x=p.x;
	y=p.y;
	cout<<"Calling the copy constructor of Point."<<endl;
}

class Line							//Line类的定义
{
private:
	Point p1,p2;					//Point类的对象 p1,p2
	double len;
public:
	Line(Point xp1,Point xP2);
	Line(Line &le);
	double getLen() {return len;}
};

//组合类的构造函数
Line::Line(Point xp1,Point xp2) : p1(xp1),p2(xp2)				
{								//初始化列表，利用该函数形参对Line对象的私有成员p1,p2进行初始化，调用Point类的复制构造函数
								//初识化完了之后    p1.x==xp1.x p1.y=xp1.y  p2.x==xp2.x p2.y=xp2.y
	cout<<"Calling constructor of Line"<<endl;
	double x=static_cast<double>(p1.getX()-p2.getX());		// 1-4==-3
	double y=static_cast<double>(p1.getY()-p2.getY());		// 1-5==-4
	len=sqrt(x*x+y*y);						// 9+16==5
}

//组合类的复制构造函数
Line::Line(Line &le) : p1(le.p1),p2(le.p2)		//该初始化列表与(1)(2)两语句等价
{								//利用le对象的p1,p2值对新定义类的p1,p2初始化
//	p1=le.p1;					//  (1)
//	p2=le.p2;					//  (2)
	cout<<"Calling the copy constructor of Line."<<endl;
	len=le.len;
}

void main()
{
	Point myp1(1,1),myp2(4,5);					//建立Point类的对象，会调用Point类的构造函数
	Line line(myp1,myp2);						//建立Line类的对象，会调用组合类的构造函数
	Line line2(line);							//利用复制构造函数建立一个新的对象
	cout<<"The length of the line is:";
	cout<<line.getLen()<<endl;
	cout<<"The length of the line2 is:";
	cout<<line2.getLen()<<endl;
}