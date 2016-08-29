#include <stdafx.h>
#include <math.h>

void main()
{
	int a,b,sum=0;
	scanf("%d %d",&a,&b);
	a=a*(pow(10,b)-1)/9;
	printf("sum=");
	while(a != 0)
	{
		printf("%d+",a);
		sum+=a;
		a=a/10;
	}
	printf("\b=%d\n",sum);
}