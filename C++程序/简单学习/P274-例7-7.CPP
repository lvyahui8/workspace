#include <iostream>
using std::cout;
using std::endl;

class Base0{
public:
	int var0;
	void fun0(){cout<<"Member of Base0"<<endl;}
};
class Base1:public Base0{
public:
	int var1;
};
class Base2:public Base0{
public:
	int var2;
};
class Derived:public Base1,public Base2{
public:
	int var;
	void fun(){cout<<"Member of Derived"<<endl;}
};

void main(){
	Derived myD;
	myD.Base1::var0 = 2;
	myD.Base1::fun0();
	myD.Base2::var0 = 3;
	myD.Base2::fun0();
}

