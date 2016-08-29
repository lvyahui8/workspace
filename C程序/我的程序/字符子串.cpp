/*

题目:在一个字符串里面查找子字符串出现的次数

*/
#include "stdafx.h"
int search(char *p1,char *p2)
{
	char *sign=p2;
	int sum=0;
	while(*p1!='\0')
	{
		if(*p1==*p2)
		{
			while(*p1==*p2 &&*p2!='\0')
			{
				p1++;
				p2++;
			}
		}
		else
			p1++;

		if(*p2=='\0')
			sum++;

		p2=sign;
	}
	return sum;
}
void main()
{ 
	char str1[80],str2[20];
	puts("输入被查找的字符串:");
	gets(str1);
	puts("输入查找的子字符串:");
	gets(str2);
	printf("该子字符串出现%d次\n",search(str1,str2));
	getchar();
}
