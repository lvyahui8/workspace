#include "stdafx.h"

void main()
{
	int a,b,max;
	a=1;
	b=2;
	max= a>b ? a : b; //条件运算符   变量= 条件 ？ 成立时表达式 ：不成立时表达式
	printf("%d\n",max);
}