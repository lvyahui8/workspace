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


float dist(const Point &p1,const Point &p2){		//�������������β�
	double x=p1.x-p2.x;
	double y=p2.y-p2.y;
	return static_cast<float>(sqrt(x*x+y*y));
}

void main(){
	const Point myp1(1,1),myp2(4,5);				//����Point��Ķ���
	cout<<"The distance is : ";
	cout<<dist(myp1,myp2)<<endl;
}
