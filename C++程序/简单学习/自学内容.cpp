#include <iostream>		//For output to the screen
#include <iomanip>		//For manipulators  能够使用setw
#include <cstdlib>		//数学函数库

//using namespace std;
//命名空间。作用类似于姓氏。使大程序中的各个部分中因出现重名而导致冲突的可能性降到最低
//如果省略using语句。则必须使用全名。比如cout，要换成stu::cout。其中::是范围解析运算符
// 或者 using std::cout;

using std::cout;
using std::endl;// endl='\n'+刷新缓冲区
using std::setw;//manipulators（操纵程序）只用于下一个写入cout的值
using std::cin;

void main()
{	// <<  >> 插入运算符

//	cout<<"你好"<<"我就好"<<endl<<'a';
	
/*********************************************************
	char str[10];
	cin>>str;		//输入流
	cout<<str;		//输出流

	char ch;
	cin>>ch;
	cout<<ch;

	int i;
	cin>>i;
	cout<<i;
	
	float f;
	cin>>f;
	cout<<f;	//只输出了有效位数	
*/

//	std::cout<<"dsad";

/*********************************************************
//转义序列
	cout<<"\n\"Least said\n\t\tsoonest mended.\"\n\a";

	cout<< endl
		<< "\" Least said"
		<< endl
		<< "\t\tsoonest mended.\"\a"
		<< endl;
*/

/*********************************************************	
//setw
	cout<<setw(10)<<10<<endl;
	cout<<setw(10)<<-230<<endl;
*/

//	long int earth_d= 1234567L;// 在后面加上一个L是将该数转换Long int类型，不加也行，编译器会自动完成这个步骤

//变量定义并初始化
/*********************************************************
	int apples=10;
	int oranges=6;
	int boys=3;
	int girls=4;

	int fruit_per_child = (apples+oranges);

	cout<<endl
		<<"Each child gets "
		<<fruit_per_child<<" fruit.\n"
		<<endl;
*/

//	const int i=45;// const变量必须定义之初给其赋初值
/********************************************************
	const int inches_per_foot=12;
	const int feet_per_yards=3;
	int yards=0;
	int feet=0;
	int inches=0;

	//Read the length from the keyboard
	cout<<"Enter a length as yards,feet,and inches:";
	cin>>yards>>feet>>inches;	//输入的时候以空格或者换行符间隔

	//Output the length in inches
	cout<<endl
		<<"Length is inches is"
		<<inches+inches_per_foot * (feet+feet_per_yards*yards)
		<<endl;
*/

/*********************************************************
//<cstdlib>头文件是从C继承来的，所以许多实现方式包含了原来C函数
//的定义，它们没有在std命名空间中定义，所以函数名不使用std限定
//符.这将允许C程序在相同的环境下编译和执行，但在C++中编码时，
//应给这些函数加上std限定符。
//  数学库函数例 div()
	int v=93;
	int d=17;
	div_t results=div(v,d);
	cout<<"Output is"<< results.quot<<endl;	
	cout<<"Remainder is"<< results.rem<<endl;
//   rand()，srand(int)随机数
	int random=rand();//默认的随机种子值
	srand(15);//重置随机种子值为15	
//time()函数返回自从1970年7月1日以来过去的秒数。
	std::srand((unsigned int)std::time(O));
*/

}