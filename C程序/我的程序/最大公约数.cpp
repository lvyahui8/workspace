#include <stdafx.h>

void swap(int *x,int *y)
{	// ������Ҫ�������ͱ����ĵ�ַ���β�
	*x=*x+*y;//*x==a  *y==b
	*y=*x-*y;
	*x=*x-*y;
}

int gcd(int x,int y)
{	
	if(x%y == 0)
		return y;
	else
		return gcd(y,x%y);//�ݹ����
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
