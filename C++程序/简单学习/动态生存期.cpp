#include <iostream>

using std::cout;
using std::cin;
using std::endl;

int i=1;					//iΪȫ�ֱ��������о�̬������

void other()
{
	//a,bΪ��̬�ֲ�����������ȫ���������ֲ��ɼ���ֻ�е�һ�ν��뺯��ʱ����ʼ��
	static int a=2;
	static int b;
	// c Ϊ�ֲ����������ж�̬�����ڣ�ÿ�ν��뺯��ʱ����ʼ��
	int c=10;
	a += 2;
	i += 32;
	c += 5;
	cout<<"-------OTHER-------"<<endl;
	cout<<"i:"<<i<<" a:"<<a<<" b:"<<b<<" c:"<<c<<endl;
	b=a;
}

void main()
{	// a Ϊ��̬�ֲ�����������ȫ���������ֲ��ɼ�
	static int a;
	//b,cΪ�ֲ����������ж�̬������
	int b=-10;
	int c=0;

	cout<<"------MAIN---------"<<endl;
	cout<<"i:"<<i<<" a:"<<a<<" b:"<<b<<" c:"<<c<<endl;
	c += 8;
	other();
	cout<<"------MAIN---------"<<endl;
	cout<<"i:"<<i<<" a:"<<a<<" b:"<<b<<" c:"<<c<<endl;
	i += 10;
	other();
}
