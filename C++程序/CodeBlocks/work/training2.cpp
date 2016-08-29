#include<iostream>
using namespace std;
void main()
{
	int getSum(int * pointer , int n);//n为二维数组的元素个数
	int getProduct(int * pointer , int n);//n为二维数组的元素个数
	int getMax(int * pointer , int n);//n为二维数组的元素个数，返回值为最大元素在数组中的位置
	int i,j;
	int Array[4][4];
	cout << "input the array:\n";
	for(i=0;i<=3;i++)
		for(j=0;j<=3;j++)
			cin>>Array[i][j];
	cout << "the Sum is:" << getSum(Array[0],16);
	cout << "\nthe Product is:" << getProduct(Array[0],16);
	int m=getMax(Array[0],16);
	cout << "\nthe maxnumber's location is:" << "\n(" <<m/4+1<<","<<m%4+1<<")";
}
int getSum(int * pointer , int n)
{
	int sum=0;
	for(int k=0;k<n;k++)
	{
		sum += *(pointer++);
	}
	return sum;
};
int getProduct(int * pointer , int n)
{
	int csum=1;
	for(int k=0;k<n;k++)
	{
		if(k%4==k/4||k%4+k/4==3)
			csum *= *pointer;
			pointer++;
	}
	return csum;
};
int getMax(int * pointer , int n)
{
	int Max = 0;
	int max = *pointer;
	for(int k=0;k<n;k++)
	{
		if(*(pointer++)>max)
		{
			max=*((--pointer)++);
			Max=k;
		}
	}
	return Max;
};