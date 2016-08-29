#include <stdafx.h> 

void main()
{
	//验证VC对形参的计算顺序是从右向左
	int f(int a,int b);
	int i=2,p;
	p=f(i,++i);
	printf("%d\n",p);
}

int f(int a,int b)
{
	int c;
	if(a >b)
		c=1;
	else 
		if(a==b)
			c=0;
		else
			c=-1;
	return c;
}