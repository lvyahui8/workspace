#include <stdafx.h>

double power(double x,int n);//�˺������� x^n  

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
		sum=sum+a*(power(10,i)-1)/9;  //  ��i��Ϊ a*(10^i-1)/9
		printf("%ld+",a*(int(power(10,i)-1))/9);  //��ӡÿһ��
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
