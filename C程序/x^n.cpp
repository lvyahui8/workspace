#include <stdafx.h>

double power(double x,int n)
{
	if(n==0) return 0;
	double j=x;
	for(int i=1;i<n;i++)
	{
		x=x*j;
	}
	return x;
}
