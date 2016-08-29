#include <stdafx.h>

void main()
{
	/*
	*	题目：输入两个正整数m和n，求
	*	其最大公约数和最小公倍数。
	*	程序分析：利用辗除法。
	*/

	int a,b,q,r,temp;
	scanf("%d %d",&a,&b);
	if(a<b)
	{
		temp=a;
		a=b;
		b=temp;
	}
	q=a/b;
	r=a%b;
	while(r != 0)
	{
		q=b/r;
		temp=r;
		r=b%r;
	}
	printf("%d\n",temp);
}