#include<iostream>
using namespace std;
class Complex{
public:
	Complex(double r=0.0,double i=0.0):real(r),imag(i){}
	Complex operator++(int);
	Complex operator--(int);

	friend ostream & operator<< (ostream &out,const Complex &c);
private:
	double imag,real;
};
Complex Complex::operator ++(int)
{
	return Complex(real++,imag++);
}

Complex Complex::operator --(int)
{
	return Complex(real--,imag--);
}

ostream & operator<< (ostream &out,const Complex &c)
{
	out<<"("<<c.real<<","<<c.imag<<")"<<endl;
	return out;
}

int main()
{
/*
	Complex a(1.2,3.4);
	a++;
	cout<<a;
	a--;
	cout<<a;
*/
	return 0;

}