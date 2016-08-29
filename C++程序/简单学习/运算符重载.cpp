
/*
╔════════════════════════════════════╗
║	运算符重载规则：
║	（1）、C++中的运算符除少数几个外，基本都能重载。且只能重载已有运算符
║	（2）、重载之后运算符的优先级和结合性不会改变
║	（3）、与原有功能类似，操作对象数不变，至少要有一个自定义类型操作对象
║	不能重载的运算符：类属关系运算符'.'，成员指针运算符".*"，
║					作用域运算符"::"，和三目运算符"?:"
║	运算符重载形式：
║	（1）、重载为类的非静态成员函数。此时函数的参数个数要比原来的参数个数
║			要少一个，后置（++，--）除外。
║	（2）、重载为非成员函数。此时，可能需要访问形参类的私有成员，可以把该
║			函数设置为类的友元函数
╚════════════════════════════════════╝*/
#include <iostream>
using std::cout;
using std::endl;

#define ROUTINE 3
//	重载为类的非静态成员函数。
//				1、例8-1复数类加减法运算重载为成员函数
//				2、例8-2单目运算符“++”重载为成员函数形式
//	重载为非成员函数。
//				3、例8-3以非成员函数形式重载Complex的加减法运算和“<<”运算符
#if ROUTINE == 1
//1、例8-1复数类加减法运算重载为成员函数
class Complex{
private:
	double real;
	double imag;
public:
	Complex(double r=0,double i=0):real(r),imag(i){}
	void Display() const;
	//运算符重载
	Complex operator+(const Complex &c2) const;
	Complex operator-(const Complex &c2) const;
};

void Complex::Display()const{
	cout<<' '<<real<<'+'<<imag<<'i'<<endl;
}

Complex Complex::operator-(const Complex &c2) const{
	return Complex(real-c2.real,imag-c2.imag);			//创建一个临时对象作为返回值
}

Complex Complex::operator+(const Complex &c2) const{
	return Complex(real+c2.real,imag+c2.imag);
}

void main(){
	Complex c1(3,4),c2(1,2);
	cout<<"c1=";c1.Display();
	cout<<"c2=";c2.Display();
	Complex c3;
	c3=c1-c2;
	cout<<"c3=c1-c2=";c3.Display();
	c3=c1+c2;
	cout<<"c3=c1+c2=";c3.Display();
}
//
//
#elif ROUTINE == 2
//2、例8-2单目运算符“++”重载为成员函数形式
class Clock{
private:
	int hour,minute,second;
public:
	Clock(int hour=0,int minute=0,int second=0);
	void ShowTime()const;
	Clock & operator++();			//前置单目运算符重载
	Clock operator++(int);			//后置单目运算符重载
};

Clock::Clock(int hour/*=0*/,int minute/*=0*/,int second/*=0*/){
	if(0<=hour && hour<24 && 0<=minute && minute<60
		&& 0<=second && second<60){
		this->hour = hour;
		this->minute =minute;
		this->second = second;
	}
	else{
		cout<<"Time error!"<<endl;
	}
}

void Clock::ShowTime() const{
	cout<<hour<<':'<<minute<<':'<<second<<endl;
}
//运算符重载
Clock & Clock::operator++(){		//前置单目运算符重载函数
	second++;
	if(second>=60){
		second = 0;
		minute++;
		if(minute>=60){
			minute = 0;
			hour = (hour+1)%24;
		}
	}
	return * this;
}
Clock Clock::operator++(int){		//后置单目运算符重载函数
	Clock old = *this;
	++(*this);
	return old;
}

void main(){
	Clock myClock(23,59,59);
	cout<<"First time output: ";
	myClock.ShowTime();
	cout<<"Show myClock++: ";
	(myClock++).ShowTime();
	cout<<"Show ++myClock: ";
	(++myClock).ShowTime();
}
//
//
#elif ROUTINE == 3
//3、例8-3以非成员函数形式重载Complex的加减法运算和“<<”运算符
using std::ostream;
class Complex{
private:
	double real;
	double imag;
public:
	Complex(double r=0,double i=0):real(r),imag(i){}
	//运算符重载
	friend Complex operator+(const Complex &c1,const Complex &c2);
	friend Complex operator-(const Complex &c1,const Complex &c2);
	friend ostream & operator<<(ostream &out,const Complex &c);
};

Complex operator-(const Complex &c1,const Complex &c2){
	return Complex(c1.real-c2.real,c1.imag-c2.imag);			//创建一个临时对象作为返回值
}

Complex operator+(const Complex &c1,const Complex &c2){
	return Complex(c1.real+c2.real,c1.imag+c2.imag);
}

ostream & operator<<(ostream &out,const Complex &c){
	out<<'('<<c.real<<','<<c.imag<<')';
	return cout;
}

void main(){
	Complex c1(3,4),c2(1,2);
	cout<<"c1="<<c1<<endl;
	cout<<"c2="<<c2<<endl;
	Complex c3;
	c3=c1-c2;
	cout<<"c3=c1-c2="<<c3<<endl;
	c3=c1+c2;
	cout<<"c3=c1+c2="<<c3<<endl;
}
#endif
