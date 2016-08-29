#include <iostream>
#include <cmath>
using namespace std;

int getSum(int *pointer,int n)
{
	int Sum = 0;
	for (int i = 0;i < sqrt(n);i++)
		for (int j = 0;j < sqrt(n);j++)
		   Sum += *(pointer+i*4+j);
	return Sum;
}

int getProduct(int *pointer,int n)
{
	int Sum = 1;
	for (int i = 0;i<sqrt(n);i++)
		for (int j = 0 ;j <sqrt(n);j++)
		if (i == j)
			Sum *= *(pointer+i*4+j);

	return Sum;

}

int getMax(int *pointer,int n)
{
	int c = 0;
	for (int i = 0;i < sqrt(n);i++)
		for (int j = 0; j<sqrt(n);j++)
		if(*(pointer+i*4+j) >= pointer[0])
		{	pointer[0] = *(pointer+i*4+j);
			c = ((pointer+i*4+j) - pointer);
		}

	return c;
}

int main()
{
	int list[4][4];
	for (int i = 0;i<4;i++)
		for(int j = 0;j <4;j++)
		{
			int a;
			cin>>a;
			list[i][j] = a;
		}
	cout<<"the sum  is "<<getSum(list[0],16)<<endl
		<<"the product is "<<getProduct(list[0],16)<<endl
		<<"the max is "<<getMax(list[0],16);
	return 0;
}
