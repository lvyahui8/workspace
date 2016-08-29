#include <stdafx.h>

void a_sum(int n)
{
	int a[n];
	for(int i=0;i<=n;i++)
	{
		a[i]=i;
	}
	return 0;
}

void main()
{
	a_sum(5);
}