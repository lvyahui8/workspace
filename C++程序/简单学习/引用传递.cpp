//���ô��ݣ�
/*
	int i,j;
	int &ri=i;	//����һ��int�͵�����ri���������ʼ��Ϊ����i��һ������
	j=10;
	ri=j;		//�൱�� i=j;
	//����һ������ʱ������ͬʱ�������г�ʼ����ʹ��ָ��һ���Ѿ����ڵĶ���
	//һ��һ�����ñ���ʼ��֮�󣬾Ͳ��ܸ�Ϊָ�������Ķ���
  */

#include <iostream>
using std::cout;
using std::endl;

void swap(int &a,int &b)
{
	int t=a;
	a=b;
	b=t;
}
void main()
{
	int x=3,y=5;
	cout<<x<<' '<<y<<endl;
	swap(x,y);
	cout<<x<<' '<<y<<endl;

}