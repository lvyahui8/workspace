#include <iostream>
using std::cout;
using std::endl;

class Base1{
public:
	int var;
	void fun(){
		cout<<"Member of Base1"<<endl;
	}
};

class Base2{
public:
	int var;
	void fun(){
		cout<<"Member of Base2"<<endl;
	}
};

class Derived:public Base1,public Base2{
public:
	int var;					//与父类同名的数据成员
	void fun(){					//与父类同名的函数成员
		cout<<"Member of Derived"<<endl;
	}
};

int main(int argc, char *argv[])
{
	Derived myD;
	Derived * lpD = &myD;

	myD.var = 1;				//对象名.成员名 标识
	myD.fun();					//访问Derived类成员

	myD.Base1::var = 2;			//作用域分辨符标识
	myD.Base1::fun();			//访问Base1父类成员

	lpD->Base2::var = 3;
	lpD->Base2::fun();

	return 0;
}
