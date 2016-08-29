#include <iostream>
using namespace std;

class base
{
private:
public:
	base(){
		cout<<"fu gz"<<endl;
	}
	~base(){
		cout<<"fu dst"<<endl;
	}
protected:
};

class dri: public base{
	int num;
public:
	dri(int num){
		this->num = num;
		cout<<"zi gz"<<endl;
	}
	~dri(){
		cout<<"dri dst"<<endl;
	}
	void show(){
		cout<<num<<endl;
	}
};

void Fun( int * const & p){			//	指针类型的引用
	cout<<&p<<endl;
	cout<<*p<<endl;
}

void main(){
//	dri di(1);
//	di.show();
//	int i = 10;
//	int * p = &i;
//	cout<<"p = "<<p<<endl;
//	cout<<"i = "<<i<<endl;
// 	cout<<*p<<endl; 
//	// cout<<"*p++ = "<<(*p++)<<endl;
//	// cout<<"*(p++) = "<<(*(p++))<<endl;
//	cout<<"(*p)++ = "<<((*p)++)<<endl;
//// 	cout<<*p<<endl;
//	cout<<"p = "<<p<<endl;
// 	cout<<"i = "<<i<<endl;
//	int a=3,b=4;
//	cout<<"a = "<<a<<" b = "<<b<<endl;
//	a ^= b ^= a ^= b;
//	cout<<"a = "<<a<<" b = "<<b<<endl;
//	int * p = &a;
//	cout<<&p<<endl;
//	Fun(p);
// 	Fun(&b);
//
//	int a=3;
//	int * p = &a;
// 	int b = *p++;
	int x = 3;
	void (*fun)(int * const &) = &/*取地址符不是必须的，可要可不要*/Fun;
	(*fun)(&x);
	fun(&x);
}