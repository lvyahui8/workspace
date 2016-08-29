#include <stdafx.h>

void main()
{
	// 功能》求Fibonacci数列前40项
	int a1=1,a2=1;
	for(int i=1;i<=20;i++)
	{
		printf("%d\n%d\n",a1,a2);
		a1=a1+a2;
		a2=a1+a2;
	}

}
