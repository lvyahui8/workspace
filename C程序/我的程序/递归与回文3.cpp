/*
需求：使用递归判断回文

思路：把输入的数据统一当做字符，将整个字符串反转，比较两个字符串是否相同，相同则是回文数

步骤；
1.由用户输入字符，直到输入回车。再在字符串的末尾加上'\0'.
2.调用hw函数将字符数组string1里的字符串倒转过来存到字符数组string2里.
3.利用strcmp函数比较string1和string2，相同则是回文，否则不是回文，输出结果.

*/

#include <stdafx.h>

#include <string.h>
// 该函数将字符数组str里的字符串倒转过来存到字符数组str2里
void hw(char str1[],char str2[],int i)
{
	int j=0;
	i=i-1;
	while(str2[i--]=str1[j++]);
	printf("%d %d\n",i,j);
	str2[j-1]='\0';
}

void main()
{
	char  string1[20];
	char  string2[20];
	int n=0;
	char ch;
	printf("01234567890123456789\n");
	//gets(string1);
	while( (ch=getchar()) != '\n')
	{
		string1[n++]=ch;
	}
	string1[n]='\0';

	hw(string1,string2,n);

	if(strcmp(string1,string2)==0)
		printf("shi hui wen zi fu chaun.\n");
	else
		printf("bu shi hui wen zi fu chaun.\n");
}

