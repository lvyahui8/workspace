#include <stdafx.h>
/*
需求：将用户输入的字符串倒着打印出来
思路：利用函数递归
*/
void ver()
{
	char ch;
	ch=getchar();
	if( ch!='\n')
	{
		ver();
		putchar(ch);
	}
}

void main()
{
	ver();
	putchar('\n');
}
