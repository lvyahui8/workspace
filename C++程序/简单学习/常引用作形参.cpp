#include <iostream>
#include <cmath>

using std::cout;
using std::endl;

class Point{
private:
	int x,y;
public:
	Point(int mx=0,int my=0) : x(mx),y(my){}
	int getX(){return x;}
	int getY(){return y;}
	friend float dist(const Point &p1,const Point &p2);
};


float dist(const Point &p1,const Point &p2){		//常引用做函数形参
	double x=p1.x-p2.x;
	double y=p2.y-p2.y;
	return static_cast<float>(sqrt(x*x+y*y));
}

void main(){
	const Point myp1(1,1),myp2(4,5);				//定义Point类的对象
	cout<<"The distance is : ";
	cout<<dist(myp1,myp2)<<endl;
}
