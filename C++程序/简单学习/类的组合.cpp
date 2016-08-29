#include <iostream>
#include <cmath>
using std::cout;
using std::endl;

class Point							//Point�ඨ��
{
private:
	int x,y;
public:
	Point(int xx=0,int yy=0)
	{
		x=xx;
		y=yy;
	}
	Point(Point &p);				//���ƹ��캯��
	int getX()	{return x;}
	int getY()	{return y;}
};

Point::Point(Point &p)				//���ƹ��캯����ʵ��
{
	x=p.x;
	y=p.y;
	cout<<"Calling the copy constructor of Point."<<endl;
}

class Line							//Line��Ķ���
{
private:
	Point p1,p2;					//Point��Ķ��� p1,p2
	double len;
public:
	Line(Point xp1,Point xP2);
	Line(Line &le);
	double getLen() {return len;}
};

//�����Ĺ��캯��
Line::Line(Point xp1,Point xp2) : p1(xp1),p2(xp2)				
{								//��ʼ���б����øú����βζ�Line�����˽�г�Աp1,p2���г�ʼ��������Point��ĸ��ƹ��캯��
								//��ʶ������֮��    p1.x==xp1.x p1.y=xp1.y  p2.x==xp2.x p2.y=xp2.y
	cout<<"Calling constructor of Line"<<endl;
	double x=static_cast<double>(p1.getX()-p2.getX());		// 1-4==-3
	double y=static_cast<double>(p1.getY()-p2.getY());		// 1-5==-4
	len=sqrt(x*x+y*y);						// 9+16==5
}

//�����ĸ��ƹ��캯��
Line::Line(Line &le) : p1(le.p1),p2(le.p2)		//�ó�ʼ���б���(1)(2)�����ȼ�
{								//����le�����p1,p2ֵ���¶������p1,p2��ʼ��
//	p1=le.p1;					//  (1)
//	p2=le.p2;					//  (2)
	cout<<"Calling the copy constructor of Line."<<endl;
	len=le.len;
}

void main()
{
	Point myp1(1,1),myp2(4,5);					//����Point��Ķ��󣬻����Point��Ĺ��캯��
	Line line(myp1,myp2);						//����Line��Ķ��󣬻���������Ĺ��캯��
	Line line2(line);							//���ø��ƹ��캯������һ���µĶ���
	cout<<"The length of the line is:";
	cout<<line.getLen()<<endl;
	cout<<"The length of the line2 is:";
	cout<<line2.getLen()<<endl;
}