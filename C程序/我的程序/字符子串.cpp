/*

��Ŀ:��һ���ַ�������������ַ������ֵĴ���

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
	puts("���뱻���ҵ��ַ���:");
	gets(str1);
	puts("������ҵ����ַ���:");
	gets(str2);
	printf("�����ַ�������%d��\n",search(str1,str2));
	getchar();
}
