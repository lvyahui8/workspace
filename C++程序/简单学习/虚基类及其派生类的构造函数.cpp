/*※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※
※	当程序中所有类使用系统默认的构造函数时，使用虚函数会很方便。但是，但虚
※	基类有自定义的构造函数时，事情就变的麻烦了。这时，在整个继承关系中，直
※	接或间接继承虚基类的所有派生类，都必须在构造函数的成员初始化列表中列出
※	对虚基类的初始化。
※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※*/
#include <iostream>
using std::cout;
using std::endl;

class Base0{								//定义基类 Base0
public:
	Base0(int var):var0(var){}				//虚基类中声明了构造函数
	int var0;
	void fun0(){cout<<"Member of Base0"<<endl;}
};

class Base1:virtual public Base0{			//定义派生类Base1
public:										//新增外部接口
	int var1;
	Base1(int var):Base0(var){}				//直接派生类对虚基类初始化
};
class Base2:virtual public Base0{			//定义派生类Base2
public:										//新增外部接口
	int var2;
	Base2(int var):Base0(var){}				//直接派生类对虚基类初始化
};

class Derived:public Base1,public Base2{	//定义派生类Derived
public:										//新增外部接口
	int var;
	Derived(int var):Base0(var),Base1(var),Base2(var){}
/*※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※
※	间接派生类也要对虚基类初始化。看起来似乎定义一个派生类Derived会对虚基
※	类进行3次初识化。其实不然，C++编译器有它处理这个问题的策略。为叙述方便
※	将建立对象时的类，称为最远派生类。如果这个对象中含有从虚基类中继承来的
※	成员，则虚基类的成员是由最远派生类的构造函数通过调用虚基类的构造函数进
※	行初始化的。而且，只有最远派生类的构造函数会调用虚基类的构造函数，该最
※	远派生类的其它基类对虚基类的构造函数的调用都会被自动忽略。
※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※*/
	void fun(){cout<<"Member of Derived"<<endl;}
};

void main(){
	Derived myD(1);
	myD.var0 = 2;							//直接访问虚基类的数据成员
	myD.fun();								//直接访问虚基类的函数成员
}
