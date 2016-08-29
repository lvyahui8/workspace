#include <stdafx.h>
#include <math.h>
void main()
{
	/*
	题目：用*号输出字母C的图案。 
	1.程序分析：可先用'*'号在纸上写出字母C，再分行输出。 
	2.程序源代码： 
	*/
	for(int i=-2;i<=2;i++)
	{
		if(abs(i)==2) printf("* * * *\n");
		else if(abs(i)==1) printf("*\n");
		else continue;
	}
}
