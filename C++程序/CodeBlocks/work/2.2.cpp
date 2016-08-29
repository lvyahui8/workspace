#include <iostream>
using namespace std;
    int row,column;
    int GetSum(int *pointer,int n)
	{
	int sum;
	for(int i=1;i<n;i++)
	{
		sum=sum+*pointer;
		pointer++;
	}
	return sum;
	}//2.1
    int GetSum2(int *pointer,int n)
	{
	int sum2;
	for(int i=1;i<n;i++)
	{
		if(row==column||row+column==3)
			sum2=sum2+*pointer;
	}
	return sum2;
	}//2.2
	int GetMax(int *pointer,int n)
	{
	int max,i,imax;
	max=*pointer;
	for(i=1;i<n;i++)
	{
		pointer++;
		if(max<*pointer)
		{
			max=*pointer;
			imax=i;
		}
	}
	return i;
	}//2.3
int main()
{
	int matrix[4][4];
	int sum,sum2,i,max,rmax,cmax;//sum2是对角线之和，i为储存位置，max是最大element，rmax与cmax为其位置下标
	int *pointer=&matrix[0][0];
	for(row=0;row<4;row++)
	{
		for(column=0;column<4;column++)
		{
			cout<<"input the pointer"<<row<<column<<endl;
			cin>>matrix[row][column];
		}
	}
	sum=GetSum (pointer,17);
	sum2=GetSum2(pointer,17);
	cout<<"sum is"<<sum<<endl<<"sum2 is"<<sum2<<endl;
	i=GetMax(pointer,17);
	rmax=i/4;
	cmax=i%4;
	max=matrix[rmax][cmax];
	cout<<"max is"<<max<<"  rmax is"<<rmax<<"  cmax is"<<cmax<<endl;
	return 0;
}
