#include <stdafx.h>
/*
���󣺽��û�������ַ������Ŵ�ӡ����
˼·�����ú����ݹ�
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
