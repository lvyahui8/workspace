#include <iostream>
using std::cout;
using std::endl;

class Base{
public:
	virtual ~Base();	
	//如果不将它设为虚函数，则程序运行完不会调用派生类的析构函数，派生类的中动态分配的内存空间没有被释放，造成内存泄露
};

Base::~Base(){
	cout<<"Base destructor"<<endl;
}

class Derived:public Base{
public:
	Derived();
	~Derived();
private:
	int *p;
};

Derived::Derived(){
	p = new int(0);
}

Derived::~Derived(){
	cout<<"Derived destructor"<<endl;
	delete p;
}

void fun(Base * b){
	delete b;
}

int main(){
	Base * b = new Derived();
	fun(b);
	return 0;
}

