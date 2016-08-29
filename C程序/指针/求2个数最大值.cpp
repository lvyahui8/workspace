#include <stdafx.h>

int max(int x,int y)
{
	return x>y ? x : y;
}

void main()
{
	int a,b;
	int (*p)(int,int);
	scanf("%d %d",&a,&b);
	p=max;
	printf("max=%d\n",max(a,b));
	printf("max=%d\n",p(a,b));
	printf("max=%d\n",(*p)(a,b));
}

