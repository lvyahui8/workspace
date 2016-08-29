#include <stdafx.h>

void main()
{
	/*
	题目：输出9*9口诀。 
	1.程序分析：分行与列考虑，共9行9列，i控
	制行，j控制列。 
	2.程序源代码：
	*/
	for(int i=1;i<=9;i++)
	{
		for(int j=1;j<=i;j++)
		{
			printf("%d*%d=%d  ",j,i,j*i);
		}
		printf("\n");
	}
}