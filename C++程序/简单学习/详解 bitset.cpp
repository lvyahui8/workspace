
#include <iostream>
#include <bitset>

using std::cout;
using std::cin;
using std::bitset;
using std::endl;
void main()
{
	/*
	//�Զ��������룬10�������
	bitset<8>a;
	cin>>a;
	cout<<std::dec<<a<<"\n";	//�������10���Ƶ�ֵ
	cout<<a.to_ulong()<<"\n";	//���10���Ƶ�ֵ
	*/
	int i; 
    cin>>i;
	cout<<i<<"(10)=="<<bitset<sizeof(int)*8>(i)<<"(2)"<<endl;

}