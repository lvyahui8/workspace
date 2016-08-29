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
	
	cout<<std::hex;		//使以后的输出(仅限于整数)为16进制，要换回10进制，可使用std::dec,8进制 要用std::ocx.二进制有所不同
	cout<<setfill('0');	//使输出的值加上0前导，使结果更清晰

	cout<<"\n尝试按位AND和OR运算符.";
	cout<<"\n初始值  red           ="<<setw(8)<<red;
	cout<<"\n补充   ~red           ="<<setw(8)<<~red;

	cout<<"\n初始值   white        ="<<setw(8)<<white;
	cout<<"\n补充    ~white        ="<<setw(8)<<~white;

	cout<<"\n按位 AND  red & white ="<<setw(8)<<(red & white);
	cout<<"\n按位 OR   red | white ="<<setw(8)<<(red | white);

	cout<<"\n\n现在我们可以尝试连续异或操作.";

	unsigned long mask = red^white;

	cout<<"\n   mask = red ^ white ="<<setw(8)<<mask;
	cout<<"\n   mask ^ red         ="<<setw(8)<<(mask ^ red);
	cout<<"\n   mask ^ white       ="<<setw(8)<<(mask ^ white);

	unsigned long flags = 0xFFUL;			//标志变量
	unsigned long bit1mask = 0x1UL;		//选择位 1
	unsigned long bit6mask = 0x20UL;		//选择位 6
	unsigned long bit20mask = 0x80000UL;	//选择位 20

	cout<<"\n\n现在使用mask选择或设定一个特定的标志位.";
	cout<<"\nflags                 :"<<bitset<32>(flags);
	cout<<"\n选择1位从flags        :" << bitset<32>(flags & bit1mask);
	cout<<"\n选择6位从flags        :" << bitset<32>(flags & bit6mask);
	cout<<"\n关掉flags中的点6      :"<<  bitset<32>(flags &=  ~bit6mask);
	cout<<"\n打开flags中的点20     :"<<  bitset<32>(flags |=  bit20mask);
	cout<<endl;
	return 1;
}