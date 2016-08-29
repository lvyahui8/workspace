#include <iostream>
using std::cout;
using std::endl;

#define CASE_NO 1

#ifdef CASE_NO==1
class Base{
public:
	virtual void fun1(){
		cout<<"Base::fun1()"<<endl;
	}
	void fn(){cout<<"Base::fn()"<<endl;}
	virtual ~Base(){}
};

class Derived1:public Base{
public:
	void fun1(){
		cout<<"Derived1::fun1()"<<endl;
	}
	void fun2(){
		cout<<"Derived1::fun2()"<<endl;
	}
};

void main(){
	Base * bptr;
	Derived1 *dptr;
	Derived1 nyDer;
	
	bptr = &nyDer;
	bptr->fun1();
	bptr->Base::fun1();
	//bptr->fun2();			//错误，基类指针只能调用派生类中基类声明的虚函数，不能调用派生类新增的函数
	dptr = &nyDer;
	dptr->fun1();
	dptr->Base::fun1();		//正确，派生类的指针可以通过Base::作用域分辨访问被派生类覆盖的函数	
	dptr->fn();				//正确，派生类的指针可以直接访问基类的非虚函数
	dptr->fun2();
}

#elif CASE_NO==2
//例8-9  dynamic_cast用法示例
class Base{
public:
	virtual void fun1(){
		cout<<"Base::fun1()"<<endl;
	}
	virtual ~Base(){}
};

class Derived1:public Base{
public:
	virtual void fun1(){
		cout<<"Derived1::fun1()"<<endl;
	}
	virtual void fun2(){
		cout<<"Derived1::fun2()"<<endl;
	}
};

class Derived2:public Derived1{
public:
	virtual void fun1(){
		cout<<"Derived2::fun1()"<<endl;
	}
	virtual void fun2(){
		cout<<"Derived2::fun2()"<<endl;
	}
};

void fun(Base *b){
	b->fun1();
	Derived1 * d = dynamic_cast<Derived1*>(b);		//尝试将b转换为Derived1指针
	if(d!=0)
		d->fun2();									//判断是否转换成功
}

void main(){
	Base b;
	fun(&b);
	Derived1 d1;
	fun(&d1);
	Derived2 d2;
	fun(&d2);
}
#endif