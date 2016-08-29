#include <stdafx.h>
#include <math.h>
void main()
{
	int m,n,a=1;
	do
	{
		printf("任意输入一个数并回车\n");
		scanf("%d",&m);
		n=m/2;
		for(int i=-n;i<=n;i++)
		{
			for(int j=1;j<=abs(i);j++)
				printf("  ");
			for(int k=0;k<=2*n-2*abs(i);k++)
				printf("* ");
			printf("\n");
		}
	}
	while(a==1);
}