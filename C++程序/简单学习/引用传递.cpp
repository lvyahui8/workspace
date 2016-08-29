//引用传递：
/*
	int i,j;
	int &ri=i;	//建立一个int型的引用ri，并将其初始化为变量i的一个别名
	j=10;
	ri=j;		//相当于 i=j;
	//声明一个引用时，必须同时对它进行初始化，使它指向一个已经存在的对象。
	//一旦一个引用被初始化之后，就不能改为指向其它的对象
  */

#include <iostream>
using std::cout;
using std::endl;

void swap(int &a,int &b)
{
	int t=a;
	a=b;
	b=t;
}
void main()
{
	int x=3,y=5;
	cout<<x<<' '<<y<<endl;
	swap(x,y);
	cout<<x<<' '<<y<<endl;

}