/*

���󣺷���һ��strcmp�������Ƚ��ַ���������ַ���ascii���ֵ

˼·������Ƚϣ�������ͬ�ı������ֵ�������Ƚϡ�

���裺
1.���������ַ���
2.�����Զ��庯�����Ƚ��ַ���
3.����ֵ���أ����

*/

#include <stdafx.h>

/*
int strcmp(char str1[],char str2[])
{
	int i;// iָ���ַ���ͬʱ�����±�
	for(i=0;str1[i]==str2[i] && str1[i]!='\0' && str2[i]!='\0';i++);
	return str1[i]-str2[i];
}
*/

int strcmp(char * str1,char * str2)

{	// �Ƚ��ַ���ֱ�����ֲ�ͬ�ĺ�'\0'��ֹ
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