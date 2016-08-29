/*
在每次执行程序时，这个语句都会设置一个不同的种子，接着重复前面用默认种子值执行的语句。
因此，每次运行这个程序时，第一组总是生成相同的结果，而第二组的输出应是不同的。

*/
#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <ctime>

using std::cout;
using std::cin;
using std::endl;
using std::setw;
/*
using std::rand;
using std::srand;
using std::time;
*/
void main()
{
/*
	const int limitl = 500;
	const int limit2 = 31;

	cout<<"First we will use the default sequence from rand().\n";
	cout<<"Three random integer from 0 to "<<RAND_MAX<<":"
		<<rand()<<" "<<rand()<<" "<<rand()<<endl;

	cout<<endl<<"Now we will use a new seed for rand().\n";
	srand((unsigned int)time(0)); //重置随机种子值

	cout<<"Three random integer from 0 to "<<RAND_MAX<<":"
		<<rand()<<" "<<rand()<<" "<<rand()<<endl;
*/


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

}

