#include <stdio.h>
#include <string.h>
int  main()
{
	char a;
	char *str=&a;     //申请字符串数组时要用数组才行
	strcpy(str,"hello");
	printf(str);
	return 0;
}
