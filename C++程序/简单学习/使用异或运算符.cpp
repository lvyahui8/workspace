#include <iostream>
#include <iomanip>
#include <bitset>
using std::cout;
using std::endl;
using std::setfill;
using std::setw;
using std::bitset;
int main()
{
	unsigned long red  = 0xFF0000UL;
	unsigned long white = 0xFFFFFFUL;
	
	cout<<std::hex;		//ʹ�Ժ�����(����������)Ϊ16���ƣ�Ҫ����10���ƣ���ʹ��std::dec,8���� Ҫ��std::ocx.������������ͬ
	cout<<setfill('0');	//ʹ�����ֵ����0ǰ����ʹ���������

	cout<<"\n���԰�λAND��OR�����.";
	cout<<"\n��ʼֵ  red           ="<<setw(8)<<red;
	cout<<"\n����   ~red           ="<<setw(8)<<~red;

	cout<<"\n��ʼֵ   white        ="<<setw(8)<<white;
	cout<<"\n����    ~white        ="<<setw(8)<<~white;

	cout<<"\n��λ AND  red & white ="<<setw(8)<<(red & white);
	cout<<"\n��λ OR   red | white ="<<setw(8)<<(red | white);

	cout<<"\n\n�������ǿ��Գ�������������.";

	unsigned long mask = red^white;

	cout<<"\n   mask = red ^ white ="<<setw(8)<<mask;
	cout<<"\n   mask ^ red         ="<<setw(8)<<(mask ^ red);
	cout<<"\n   mask ^ white       ="<<setw(8)<<(mask ^ white);

	unsigned long flags = 0xFFUL;			//��־����
	unsigned long bit1mask = 0x1UL;		//ѡ��λ 1
	unsigned long bit6mask = 0x20UL;		//ѡ��λ 6
	unsigned long bit20mask = 0x80000UL;	//ѡ��λ 20

	cout<<"\n\n����ʹ��maskѡ����趨һ���ض��ı�־λ.";
	cout<<"\nflags                 :"<<bitset<32>(flags);
	cout<<"\nѡ��1λ��flags        :" << bitset<32>(flags & bit1mask);
	cout<<"\nѡ��6λ��flags        :" << bitset<32>(flags & bit6mask);
	cout<<"\n�ص�flags�еĵ�6      :"<<  bitset<32>(flags &=  ~bit6mask);
	cout<<"\n��flags�еĵ�20     :"<<  bitset<32>(flags |=  bit20mask);
	cout<<endl;
	return 1;
}