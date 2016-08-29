/*
需求：复制字符串，将串2内容复制给串1
*/
#include <stdafx.h>
#define LEN1 16
#define LEN2 12

void strcopy(char * str1,char * str2)
{
	while(*str1++ = *str2++) //当str2指向'\0'时，赋值给*str1 表达式的值为0 即为假。退出循环
		if(*str1 == '\0')	// 考虑到 串2的长度大于串1的长度，防止指针越界
			break;
}

void main()
{
	int i;
	char string1[LEN1]="aaaaaaaaaaaaaaa";
	char string2[LEN2]="bbbbbbbbbbb";
	printf("String 1:%s\nString 2:%s\n",string1,string2);

	strcopy(string1,string2);

	puts("\nUses the puts function to output:");
	printf("String 1:%s\nString 2:%s\n",string1,string2);
	// 为了显示出已经将'\0'复制过去，用循环遍历一次数组
	printf("\nThe use of loop through the array:\nString 1:");
	for(i=0;i<LEN1;i++)
		putchar(string1[i]);
	printf("\nString 2:");
	for(i=0;i<LEN2;i++)
		putchar(string2[i]);
	putchar('\n');
		
}