/*
����ʹ�õݹ��жϻ���

˼·�������������ͳһ�����ַ����������ַ�����ת���Ƚ������ַ����Ƿ���ͬ����ͬ���ǻ�����

���裻
1.���û������ַ���ֱ������س��������ַ�����ĩβ����'\0'.
2.����hw�������ַ�����string1����ַ�����ת�����浽�ַ�����string2��.
3.����strcmp�����Ƚ�string1��string2����ͬ���ǻ��ģ������ǻ��ģ�������.

*/

#include <stdafx.h>

#include <string.h>
// �ú������ַ�����str����ַ�����ת�����浽�ַ�����str2��
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

