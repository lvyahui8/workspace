#include <iostream>

using std::cout;
using std::cin;
using std::endl;

int i=1;					//i为全局变量，具有静态生存期

void other()
{
	//a,b为静态局部变量，具有全局寿命，局部可见，只有第一次进入函数时被初始化
	static int a=2;
	static int b;
	// c 为局部变量，具有动态生存期，每次进入函数时都初始化
	int c=10;
	a += 2;
	i += 32;
	c += 5;
	cout<<"-------OTHER-------"<<endl;
	cout<<"i:"<<i<<" a:"<<a<<" b:"<<b<<" c:"<<c<<endl;
	b=a;
}

void main()
{	// a 为静态局部变量，具有全局寿命，局部可见
	static int a;
	//b,c为局部变量，具有动态生存期
	int b=-10;
	int c=0;

	cout<<"------MAIN---------"<<endl;
	cout<<"i:"<<i<<" a:"<<a<<" b:"<<b<<" c:"<<c<<endl;
	c += 8;
	other();
	cout<<"------MAIN---------"<<endl;
	cout<<"i:"<<i<<" a:"<<a<<" b:"<<b<<" c:"<<c<<endl;
	i += 10;
	other();
}
