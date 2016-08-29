#include <stdafx.h>

void main()
{
	int a[10][10];
	for(int i=0;i<=9;i++)
	{
		a[i][0]=1;
		a[i][i]=1;
	}
	for(i=2;i<=9;i++)
	{
		for(int j=1;j<=i-1;j++)
			a[i][j]=a[i-1][j]+a[i-1][j-1];
	}
	for(i=0;i<=9;i++)
	{
		for(int j=0;j<=i;j++)
			printf("%4d ",a[i][j]);
		printf("\n");
	}
}