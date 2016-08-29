
/*
�X�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�[
�U	��������ع���
�U	��1����C++�е�����������������⣬�����������ء���ֻ���������������
�U	��2��������֮������������ȼ��ͽ���Բ���ı�
�U	��3������ԭ�й������ƣ��������������䣬����Ҫ��һ���Զ������Ͳ�������
�U	�������ص��������������ϵ�����'.'����Աָ�������".*"��
�U					�����������"::"������Ŀ�����"?:"
�U	�����������ʽ��
�U	��1��������Ϊ��ķǾ�̬��Ա��������ʱ�����Ĳ�������Ҫ��ԭ���Ĳ�������
�U			Ҫ��һ�������ã�++��--�����⡣
�U	��2��������Ϊ�ǳ�Ա��������ʱ��������Ҫ�����β����˽�г�Ա�����԰Ѹ�
�U			��������Ϊ�����Ԫ����
�^�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�a*/
#include <iostream>
using std::cout;
using std::endl;

#define ROUTINE 3
//	����Ϊ��ķǾ�̬��Ա������
//				1����8-1������Ӽ�����������Ϊ��Ա����
//				2����8-2��Ŀ�������++������Ϊ��Ա������ʽ
//	����Ϊ�ǳ�Ա������
//				3����8-3�Էǳ�Ա������ʽ����Complex�ļӼ�������͡�<<�������
#if ROUTINE == 1
//1����8-1������Ӽ�����������Ϊ��Ա����
class Complex{
private:
	double real;
	double imag;
public:
	Complex(double r=0,double i=0):real(r),imag(i){}
	void Display() const;
	//���������
	Complex operator+(const Complex &c2) const;
	Complex operator-(const Complex &c2) const;
};

void Complex::Display()const{
	cout<<' '<<real<<'+'<<imag<<'i'<<endl;
}

Complex Complex::operator-(const Complex &c2) const{
	return Complex(real-c2.real,imag-c2.imag);			//����һ����ʱ������Ϊ����ֵ
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
//2����8-2��Ŀ�������++������Ϊ��Ա������ʽ
class Clock{
private:
	int hour,minute,second;
public:
	Clock(int hour=0,int minute=0,int second=0);
	void ShowTime()const;
	Clock & operator++();			//ǰ�õ�Ŀ���������
	Clock operator++(int);			//���õ�Ŀ���������
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
//���������
Clock & Clock::operator++(){		//ǰ�õ�Ŀ��������غ���
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
Clock Clock::operator++(int){		//���õ�Ŀ��������غ���
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
//3����8-3�Էǳ�Ա������ʽ����Complex�ļӼ�������͡�<<�������
using std::ostream;
class Complex{
private:
	double real;
	double imag;
public:
	Complex(double r=0,double i=0):real(r),imag(i){}
	//���������
	friend Complex operator+(const Complex &c1,const Complex &c2);
	friend Complex operator-(const Complex &c1,const Complex &c2);
	friend ostream & operator<<(ostream &out,const Complex &c);
};

Complex operator-(const Complex &c1,const Complex &c2){
	return Complex(c1.real-c2.real,c1.imag-c2.imag);			//����һ����ʱ������Ϊ����ֵ
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
