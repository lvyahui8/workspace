#include <iostream>

using std::cout;
using std::cin;
using std::endl;

int i;							//��ȫ�������ռ��е�ȫ�ֱ���
namespace Ns{
	int j;						//��Ns�����ռ��е�ȫ�ֱ���
}

void main()
{
	i = 5;
	Ns::j = 6;			
	{							//�ӿ� 1
		using namespace Ns;		//ʹ���ڵ�ǰ���п���ֱ������Ns�����ռ��еı�ʶ��
		int i;					//�ֲ��������ֲ�������
		i = 7;
		cout<<"i="<<i<<endl;
		cout<<"j="<<j<<endl;
	}
	cout<<"i="<<i<<endl;
}