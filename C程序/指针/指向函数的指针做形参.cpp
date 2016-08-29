#include <stdafx.h>

int max(int x,int y)
{
	return x>y ? x : y;
}

int min(int x,int y)
{
	return x<y ? x : y;
}

int add(int x,int y)
{
	return x+y;
}

void process(int a,int b,int (*p)(int,int))
{
	printf("%d\n",p(a,b));
}

void main()
{
	int a,b;
	scanf("%d %d",&a,&b);

	process(a,b,max);

	process(a,b,min);

	process(a,b,add);
}

