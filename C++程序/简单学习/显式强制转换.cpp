#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <ctime>
using std::cout;
using std::cin;
using std::endl;
using std::setw;
//static_cast<ת���������>(���ʽ)

void main()
{
/*
	double value1 = 10.5;
	double value2 = 15.5;
	int whole_number = static_cast<int>(value1) + static_cast<int>(value2);
	cout<<whole_number<<endl;

//�ٶ���Ҫ�ѵ�λΪ��ĳ���(С��ֵ)ת��Ϊ�롢Ӣ�ߺ�Ӣ��(����ֵ)�����Ա�д���µĳ���:

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

//��ʽ��ǿ��ת��(ǿ������)(���ʽ)����ʽ��ǿ��ת��������������4��ת����
//const_cast<>()��dynamic_cast<>()��reinterpret_cast<>()��static_cast<>()
//��ʽǿ��ת�����׳���---�������Ǻ����������ܵõ���ϣ���Ľ��

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
