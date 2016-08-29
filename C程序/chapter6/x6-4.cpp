#include <stdafx.h>

void main()
{
	//º∆À„sum=1!+2!+3!+4!+5!+...+19!+20!
	double sum=0,a=1;
	for(int i=1;i<=20;i++)
	{
		sum=sum+a;
		printf("%d!=%.0lf\n",i,a);
		a=a*(i+1);	
	}
	printf("sum=%.0lf\n",sum);
}