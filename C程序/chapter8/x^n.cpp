#include <stdafx.h>

double power(double x,int n)
{
	double j=x;
	for(int i=1;i<n;i++)
	{
		x=x*j;
	}
	return x;
}
