#include <stdafx.h>
//声明计字符数函数
int strlen(char *string);

void main()
{
	char str[]="hello world!";
	printf("%d\n",strlen(str));
}

int strlen(char *string)
{
	int length=0;
	//依次访问字符串的内容，计算字符数
	while( (*string++) != '\0')
	{
		length += 1;
	}
	return length;
}