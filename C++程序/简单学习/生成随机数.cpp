/*
��ÿ��ִ�г���ʱ�������䶼������һ����ͬ�����ӣ������ظ�ǰ����Ĭ������ִֵ�е���䡣
��ˣ�ÿ�������������ʱ����һ������������ͬ�Ľ�������ڶ�������Ӧ�ǲ�ͬ�ġ�

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
	srand((unsigned int)time(0)); //�����������ֵ

	cout<<"Three random integer from 0 to "<<RAND_MAX<<":"
		<<rand()<<" "<<rand()<<" "<<rand()<<endl;
*/


	//α����������ɣ��˽���ǿ��ת��������ȷ�����������ʽ��ʹ��rand()����ֵʱ�������⡣
	// RAND_MAX= 2^15-1 = 32767 = 7FFF
	//�ٶ�ϣ���õ������������0-10֮�䣬������
	
	int limit;
	double dlimit;
	int randm_value,i;

	srand((unsigned int)time(NULL));		

/*******************�õ�������� [0,limit-1]������*******************/ 
	limit=11;

	for(i=1;i<=25;i++)
	{
		randm_value = static_cast<int>(
		limit*( static_cast<float>(rand())/(RAND_MAX+1L) )
		);
		cout<<setw(2)<<randm_value<<" ";
	}
	cout<<endl;

/*******************�õ�������� [1,limit]������*******************/ 
	limit=10;
	for(i=1;i<=25;i++)
	{
		randm_value = static_cast<int>(
		1L + limit*( static_cast<float>(rand())/(RAND_MAX+1L) )
		);
		cout<<setw(2)<<randm_value<<" ";
	}
	cout<<endl;

/*******************�õ�������� [0,limit]������*******************/ 
	dlimit=10;
	for(i=1;i<=25;i++)
	{
		randm_value = dlimit*rand()/(RAND_MAX) ;
		cout<<setw(2)<<randm_value<<" ";
	}
	cout<<endl;
}

}

