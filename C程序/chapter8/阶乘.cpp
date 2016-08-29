#include <stdafx.h>
double jiecheng(double x);
void main()
{
	printf("%g\n",jiecheng(5));
}
double jiecheng(double x)
{
	if(x==1)
	{
		return 1;
	}
	else
	{
		return x*jiecheng(x-1);
	}
}