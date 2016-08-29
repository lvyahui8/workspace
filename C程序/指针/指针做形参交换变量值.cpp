#include <stdafx.h>

void swap(int * x,int * y);

void main()
{
	int a,b;
	scanf("%d %d",&a,&b);
	printf("a=%d b=%d\n",a,b);
	swap(&a,&b);
	printf("a=%d b=%d\n",a,b);
}

void swap(int * x,int * y)
{
	int temp;
	temp=*x;
	*x=*y;
	*y=temp;
}
