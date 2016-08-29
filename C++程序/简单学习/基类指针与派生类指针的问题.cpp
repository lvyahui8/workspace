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
	//bptr->fun2();			//���󣬻���ָ��ֻ�ܵ����������л����������麯�������ܵ��������������ĺ���
	dptr = &nyDer;
	dptr->fun1();
	dptr->Base::fun1();		//��ȷ���������ָ�����ͨ��Base::������ֱ���ʱ������า�ǵĺ���	
	dptr->fn();				//��ȷ���������ָ�����ֱ�ӷ��ʻ���ķ��麯��
	dptr->fun2();
}

#elif CASE_NO==2
//��8-9  dynamic_cast�÷�ʾ��
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
	Derived1 * d = dynamic_cast<Derived1*>(b);		//���Խ�bת��ΪDerived1ָ��
	if(d!=0)
		d->fun2();									//�ж��Ƿ�ת���ɹ�
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