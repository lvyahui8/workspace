#include <iostream>

using std::cout;
using std::endl;
class CA
{
private:
	int ai;
	int bi;
public:
	CA(int a)		//���Լ�дһ�����캯��(�������ƹ��캯��)(���β�)ʱ��Ĭ�ϵĹ��캯���Ͳ�������
	{				//��ʱ��������������󴫲�
		this->ai=a;
		cout<<"hah"<<endl;
	}
	CA(int a,int b)
	{
		this->ai = a;
		this->bi = b;
	}
	CA(const CA &o)
	{
		this->ai=o.ai;
		this->bi=o.bi+2;
		cout<<"coubeicg\n";
	}
};

void main()
{
	CA a(1),b(3,4);
	a = b;			//������ԭ�ⲻ���Ŀ���
	CA c(b);
}