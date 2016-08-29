#include <iostream>
#include <cmath>
using namespace std;

int getSum(int *pointer,int n)// n 为元素个数
{
	int sum = 0;
	for (int i=0;i<sqrt(n);i++)
	{
		for (int j=0;j<sqrt(n);j++)
		{
		   sum += *(pointer+i*4+j);
		}
	}
	return sum;
}

int getProduct(int *pointer,int n)
{
	int product = 1;
	for (int i = 0;i<sqrt(n);i++)
	{
		for (int j = 0 ;j <sqrt(n);j++)
		{
			if (i==j || i+j==3)
			product *= *(pointer+i*4+j);
		}
	}
	return product;
}

int getMax(int *pointer,int n)
{
	int max = 0;
	for (int i=0;i<sqrt(n);i++)
	{
		for (int j=0; j<sqrt(n);j++)
		{
			if(*(pointer+i*4+j) >= pointer[0])
			{
				pointer[0] = *(pointer+i*4+j);
			    max = ((pointer+i*4+j)- pointer) ;
			}
		}
	}
	return max;
}

int main()
{
	int a[4][4];
	for (int i=0;i<4;i++)
	{
		for (int k=0;k<4;k++)
		{
			cout << "Please input the number for a[" << i << "][" << k << "]";
			cin >> a[i][k];
		}
	}
	cout << "The sum of array is:" << getSum(a[0],16) << '\n';
	cout << "The product is:" << getProduct(a[0],16) << '\n';
	cout << "The max of array is:" << getMax(a[0],16) << '\n';
	
	return 0;
}
