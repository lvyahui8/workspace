#include <iostream>
#include <limits>	
//�����������������͵���Ϣ������������ܴ�����С��ֵ
//���߷���2�������ֵ�λ��

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