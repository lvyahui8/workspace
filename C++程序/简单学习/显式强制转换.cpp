#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <ctime>
using std::cout;
using std::cin;
using std::endl;
using std::setw;
//static_cast<转换后的类型>(表达式)

void main()
{
/*
	double value1 = 10.5;
	double value2 = 15.5;
	int whole_number = static_cast<int>(value1) + static_cast<int>(value2);
	cout<<whole_number<<endl;

//假定需要把单位为码的长度(小数值)转换为码、英尺和英寸(整数值)，可以编写如下的程序:

	const long feet_per_yard=3;
	const long inches_per_foot=12;

	double yards=0.0;
	long yds=0;
	long ft=0;
	long ins=0;

	cout<<"Enter a length in yards as a deciaml:";
	cin>>yards;

	yds = static_cast<long>(yards);
	ft = static_cast<long>( (yards-yds)*feet_per_yard );
	ins = static_cast<long>
		(yards*feet_per_yard*inches_per_foot) % inches_per_foot;

	cout<<endl
		<<yards<<"yards converts to "
		<<yds<<" yards "
		<<ft<<" feet "
		<<ins<<" inches.";
	cout<<endl;
*/

//老式的强制转换(强制类型)(表达式)，老式的强制转换包含了下面这4种转换。
//const_cast<>()、dynamic_cast<>()、reinterpret_cast<>()、static_cast<>()
//老式强制转换容易出错---它并不是很清晰，可能得到不希望的结果

	//伪随机数的生成，了解了强制转换，可以确保在算术表达式中使用rand()返回值时不出问题。
	// RAND_MAX= 2^15-1 = 32767 = 7FFF
	//假定希望得到的随机整数在0-10之间，可如下
	
	int limit;
	double dlimit;
	int randm_value,i;

	srand((unsigned int)time(NULL));		

/*******************得到随机数在 [0,limit-1]区间内*******************/ 
	limit=11;

	for(i=1;i<=25;i++)
	{
		randm_value = static_cast<int>(
		limit*( static_cast<float>(rand())/(RAND_MAX+1L) )
		);
		cout<<setw(2)<<randm_value<<" ";
	}
	cout<<endl;

/*******************得到随机数在 [1,limit]区间内*******************/ 
	limit=10;
	for(i=1;i<=25;i++)
	{
		randm_value = static_cast<int>(
		1L + limit*( static_cast<float>(rand())/(RAND_MAX+1L) )
		);
		cout<<setw(2)<<randm_value<<" ";
	}
	cout<<endl;

/*******************得到随机数在 [0,limit]区间内*******************/ 
	dlimit=10;
	for(i=1;i<=25;i++)
	{
		randm_value = dlimit*rand()/(RAND_MAX) ;
		cout<<setw(2)<<randm_value<<" ";
	}
	cout<<endl;
}
