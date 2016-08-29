#include <stdafx.h>
double jiecheng(double x);
void main()
{
	double m,n,c;
	int i=0;
	do
	{
		printf("作用：求组合数\n");
		printf("输入总数m,欲取数n,并依次回车\n");
		scanf("%lf %lf",&m,&n);
		c=jiecheng(m)/(jiecheng(n)*jiecheng(m-n));
		printf("总数=%g 欲取数=%g 方案数=%g\n",m,n,c);
	}
	while(i==0);
}

double jiecheng(double x)
{
	if(x==1)
	{
		return x;
	}
	else
	{
		return x*jiecheng(x-1);
	}
}