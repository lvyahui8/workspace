#include <iostream>

using std::cout;
using std::endl;
class CA
{
private:
	int ai;
	int bi;
public:
	CA(int a)		//当自己写一个构造函数(包括复制构造函数)(有形参)时，默认的构造函数就不存在了
	{				//这时定义对象必须给对象传参
		this->ai=a;
		cout<<"hah"<<endl;
	}
	CA(int a,int b)
	{
		this->ai = a;
		this->bi = b;
	}
	CA(const CA &o)
	{
		this->ai=o.ai;
		this->bi=o.bi+2;
		cout<<"coubeicg\n";
	}
};

void main()
{
	CA a(1),b(3,4);
	a = b;			//将属性原封不动的拷贝
	CA c(b);
}