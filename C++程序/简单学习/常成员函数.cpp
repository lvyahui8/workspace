
#include <iostream>

using std::cout;
using std::endl;

class R
{
private:
	int r1,r2;
public:
	R(int mr1,int mr2):r1(mr1),r2(mr2){}
	void Print();
	void Print() const;		//这是对Print的有效重载
};

void R::Print()
{
	cout<<r1<<':'<<r2<<endl;
}
//下面是常成员函数
/*************************************************
*	1、常对象只能调用常成员函数,但常成员函数可以被非常对象调用。
*	2、常成员函数调用期间，对象都会被视为常对象，因此不能更新对象的数据成员，
*	也不能调用该类对象中没有用const修饰的函数成员。
*************************************************/
void R::Print() const
{
	cout<<r1<<';'<<r2<<endl;
}

void main()
{
	R a(5,4);
	a.Print();				//调用void Print()
	const R b(20,52);
	b.Print();				//调用void Print() const
}