#include <stdafx.h>

void main()
{
	/*	
	*	题目：打印出所有的"水仙花数"，所谓
	*	"水仙花数"是指一个三位数，其各位数字
	*	立方和等于该数 本身。
	*	例如：153是一个"水仙花数"，因为153=1
	*	的三次方＋5的三次方＋3的三次方。 
	*/
	int i;
	int a1,a2,a3;
	for(i=100;i<=999;i++)
	{
		a1=i%10;
		a2=i/10 % 10;
		a3=i/100;
		if(i == a1*a1*a1+a2*a2*a2+a3*a3*a3)
		{
			printf("%d\n",i);
		}
	}
}
