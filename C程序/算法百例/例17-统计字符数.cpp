#include <stdafx.h>

void main()
{
	/*
	*	��Ŀ������һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ��ĸ����� 
	*	1.�������������while���,����Ϊ������ַ���Ϊ'\n'.
	*/
	
	char ch;
	int letters=0,space=0,digit=0,other=0;

	while((ch=getchar()) != '\n')
	{
		if(ch>='a' && ch <='z' || ch>='A' && ch<='Z')
		{	letters++;	}
		else if(' '==ch)
		{	space++;	}
		else if(ch>='0' && ch<='9')
		{	digit++;	}
		else
		{	other++;	}
	}
	printf("letters=%-4d space=%-4d",letters,space);
	printf("digit  =%-4d other=%-4d",digit,other);
}