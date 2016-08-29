#include <iostream>
using std::cout;
using std::endl;
void Swap1(int a,int b){
	a = a ^ b;
	b = a ^ b;
	a = a ^ b;
	cout<<"a="<<a<<"  b="<<b<<endl;
}
void Swap2(int a,int b){
	a = a ^ (b = b ^ (a = a ^ b));
	cout<<"a="<<a<<"  b="<<b<<endl;
}
void Swap3(int a,int b){
	a ^= b ^= a ^= b;
	cout<<"a="<<a<<"  b="<<b<<endl;
}

void main(){
	Swap1(3,4);
	Swap2(3,4);
	Swap3(3,4);
}