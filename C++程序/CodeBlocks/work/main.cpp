#include<iostream>
using namespace std;
int getSum (int *pointer,int n);
int getProduct(int *pointer,int n);
int getMax (int *pointer,int n);
int main()
{

int Number[4][4];
int N[16];
int k=0;
for(int i=0;i<4;i++)
{for(int j=0;j<4;j++)
{cout<<"������һ��������16����";
cin>>Number[i][j];
N[k]=Number[i][j];
k++;
}
}
cout<<"����Ԫ��֮���ǣ�"<<getSum(N,16)<<endl;
cout<<"�Խ���Ԫ��֮���ǣ�"<<getProduct(N,16)<<endl;
cout<<"���Ԫ�ص�λ���ǣ�"<<getMax(N,16)<<endl;
return 0;
}
int getSum (int *pointer,int n)
{
	int sum=0;
	for(int i=0;i<n;i++)
	{
		sum+=pointer[i];
	}
	return sum;
}
int getProduct(int *pointer,int n)
{
	int product=pointer[0]*pointer[3]*pointer[5]*pointer[6]*pointer[9]*pointer[10]*pointer[12]*pointer[15];
	return product;}
int getMax (int *pointer,int n)
{

	int maxnumber = pointer[0];
	int g=0;
for(int i=1;i<n;i++)
{
	if(pointer[i]>maxnumber)
		maxnumber=pointer[i];
	 g=i;
}

	return g;
}
