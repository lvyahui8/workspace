
#include <iostream>
#include <bitset>

using std::cout;
using std::cin;
using std::bitset;
using std::endl;
void main()
{
	/*
	//以二进制输入，10进制输出
	bitset<8>a;
	cin>>a;
	cout<<std::dec<<a<<"\n";	//不能输出10进制的值
	cout<<a.to_ulong()<<"\n";	//输出10进制的值
	*/
	int i; 
    cin>>i;
	cout<<i<<"(10)=="<<bitset<sizeof(int)*8>(i)<<"(2)"<<endl;

}