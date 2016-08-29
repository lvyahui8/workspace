#include <stdafx.h>
double fac(double n);
void main()
{
	double i,n;
	scanf("%lf",&n);
	for(i=1;i<=n;i++)
		printf("%g!=%g\n",i,fac(i));	
}

double fac(double n)
{
	register double i,f=1;
	for(i=1;i<=n;i++)
		f=f*i;
	return f;
}