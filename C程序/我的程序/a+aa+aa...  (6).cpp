#include <stdafx.h>

int a_sum(int x,int y)
{

	int i=x,j,sum=0;
	for(j=1;j<=y;j++)
	{
		printf("%d+",i);
		sum=sum+i;
		i=i*10+x;//构造下一项
	}
	return sum;
}

void main()
{
	int a,b,sum=0;
	scanf("%d %d",&a,&b);

	printf("sum=");

	sum=a_sum(a,b);

	printf("\b=%d\n",sum);
}

