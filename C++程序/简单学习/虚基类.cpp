/*※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※
※	之前由于多继承中，部分或全部直接基类又继承于同一基类时，会造成继承而来	
※	的同名成员隐藏，如果要访问这样的成员，需要使用作用域分辨符来唯一标识并
※	访问们。为了能够直接使用派生类对象访问这样的成员，可以将直接基类的共同
※	基类设置为虚基类。
※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※*/
#include <iostream>
using std::cout;
using std::endl;

class Base0{								//定义基类 Base0
public:
	int var0;
	void fun(){cout<<"Member of Base0"<<endl;}
};

class Base1:virtual public Base0{			//定义派生类Base1
public:										//新增外部接口
	int var1;
};
class Base2:virtual public Base0{			//定义派生类Base2
public:										//新增外部接口
	int var2;
};

class Derived:public Base1,public Base2{	//定义派生类Derived
public:										//新增外部接口
	int var;
	void fun(){cout<<"Member of Derived"<<endl;}
};

void main(){
	Derived myD;
	myD.var0 = 2;							//直接访问虚基类的数据成员
	myD.fun();								//直接访问虚基类的函数成员
}
