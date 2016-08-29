#include <iostream>
#include <limits>	
//可用来检索数据类型的信息，例如该类型能存的最大（小）值
//或者返回2进制数字的位数

void main()
{
	std::cout<<std::endl
		<<"Maximum value of type double is "
		<<std::numeric_limits<double>::max()
		<<std::endl;

	std::cout<<std::endl
		<<"Maximum value of type int is "
		<<std::numeric_limits<int>::max()
		<<std::endl;

	std::cout<<std::endl
		<<"Maximum value of type float is "
		<<std::numeric_limits<float>::max()
		<<std::endl;

	std::cout<<std::endl
		<<"Maximum value of type char is "
		<<std::numeric_limits<char>::max()
		<<std::endl;


}