#include <stdafx.h>

void main()
{
	/*
	1.��������� ����Ϊ
	����1,1,2,3,5,8,13,21.... 
	2.����Դ���룺 

	*/
	long f1,f2;
	f1=1;
	f2=1;
	for(int i=1;i<=20;i++)
	{
		if(i%2==0) 
			printf("\n");
		printf("%-12ld %-12ld",f1,f2);
		f1=f1+f2;
		f2=f1+f2;
	}
	printf("\n");
}