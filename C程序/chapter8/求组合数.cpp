#include <stdafx.h>
double jiecheng(double x);
void main()
{
	double m,n,c;
	int i=0;
	do
	{
		printf("���ã��������\n");
		printf("��������m,��ȡ��n,�����λس�\n");
		scanf("%lf %lf",&m,&n);
		c=jiecheng(m)/(jiecheng(n)*jiecheng(m-n));
		printf("����=%g ��ȡ��=%g ������=%g\n",m,n,c);
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