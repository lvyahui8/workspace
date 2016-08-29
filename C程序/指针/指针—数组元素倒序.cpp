#include <stdafx.h>
#define N 10   //数组元素个数

void inv(int x[]);//倒排函数

void main()
{
	int i[N]={5,3,4,9,1,6,7,8,2,0};
	int k;
	
	for(k=0;k<N;k++)
	{
		printf("%d ",i[k]);
	}
	printf("\n");
	
	inv(i);

	for(k=0;k<N;k++)
	{
		printf("%d ",i[k]);
	}
	printf("\n");
	
}


void inv(int x[])
{
	int i,j;
	for(i=0,j=N-1; i<=(N-1)/2; i++, j--)
	{
		int temp;
		temp=x[i];
		x[i]=x[j];
		x[j]=temp;
	}
}