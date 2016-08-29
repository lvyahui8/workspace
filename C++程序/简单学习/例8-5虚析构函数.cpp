#include <iostream>
using std::cout;
using std::endl;

class Base{
public:
	virtual ~Base();	
	//�����������Ϊ�麯��������������겻������������������������������ж�̬������ڴ�ռ�û�б��ͷţ�����ڴ�й¶
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

