/*

需求：仿制一个strcmp函数。比较字符串。输出字符串ascii码差值

思路：逐个比较，遇到不同的变输出差值，结束比较。

步骤：
1.输入两个字符串
2.调用自定义函数，比较字符串
3.将差值返回，输出

*/

#include <stdafx.h>

/*
int strcmp(char str1[],char str2[])
{
	int i;// i指向字符不同时数组下标
	for(i=0;str1[i]==str2[i] && str1[i]!='\0' && str2[i]!='\0';i++);
	return str1[i]-str2[i];
}
*/

int strcmp(char * str1,char * str2)

{	// 比较字符，直到出现不同的和'\0'截止
	while(*str1++ == *str2++ && *str1!='\0' && *str2!='\0');
	return *--str1 - *--str2;
}

void main()
{
	char string1[20];//
	char string2[20];

	gets(string1);
	gets(string2);

	printf("%d\n",strcmp(string1,string2));
}