#include <iostream>
using namespace std;

class Complex
{
private:
	double real;
	double imag;
public:
	Complex(double r = 0,double i = 0):real(r),imag(i){}
	friend ostream  & operator<<(ostream &out,const Complex & c);
protected:
};

ostream & operator<< (ostream &out,const Complex & c){
	out<<c.real<<"+"<<c.imag<<"i"<<endl;
	return out;
}

int main(){
	Complex c1(5,4);
	cout<<c1;
	return 0;
}