#include <stdafx.h>

double power(double x,int n);//此函数可求 x^n  

void main()
{
	/*
	*  s=a+aa+aaa+aaaa+.....+a(n);
	*	f1:
	*/
	unsigned int a,b,i,sum=0;
	scanf("%d %d",&a,&b);

	printf("sum=");
	for(i=1;i<=b;i++)
	{
		sum=sum+a*(power(10,i)-1)/9;  //  第i项为 a*(10^i-1)/9
		printf("%ld+",a*(int(power(10,i)-1))/9);  //打印每一项
	}
	printf("\b=%ld\n",sum);
	
}


double power(double x,int n)
{
	if(n==0) return 0;
	double j=x;
	int i;

	for(i=1;i<n;i++)
	{
		x=x*j;
	}
	return x;
}
