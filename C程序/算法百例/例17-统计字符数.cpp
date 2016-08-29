#include <stdafx.h>

void main()
{
	/*
	*	题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。 
	*	1.程序分析：利用while语句,条件为输入的字符不为'\n'.
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