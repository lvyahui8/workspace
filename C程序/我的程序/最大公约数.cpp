#include <stdafx.h>

void swap(int *x,int *y)
{	// 函数需要两个整型变量的地址做形参
	*x=*x+*y;//*x==a  *y==b
	*y=*x-*y;
	*x=*x-*y;
}

int gcd(int x,int y)
{	
	if(x%y == 0)
		return y;
	else
		return gcd(y,x%y);//递归调用
}

void main()
{
	int a,b;

	printf("Enter two integers:");
	scanf("%d %d",&a,&b);

	if(a<b)
		swap(&a,&b);
	printf("Greatest common divisor:%d\n",gcd(a,b));
}
