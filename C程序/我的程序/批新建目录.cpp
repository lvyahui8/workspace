#include <stdafx.h>
#include <stdlib.h>

void md();
void rd();

void main()
{
	int i;
	printf("1���½�Ŀ¼\t2ɾ��Ŀ¼\n");
	scanf("%d%*c",&i);
	switch(i)
	{
		case 1:md();break;
		case 2:rd();break;
		default : break;
	}
}

void md()
{
	int x;
	printf("1���½�10��Ŀ¼\t2���½�50��Ŀ¼\t3���½�100��Ŀ¼\n");
	scanf("%d%*c",&x);
	system("@echo off");
	switch(x)
	{
		case 1:system("for /l %i in (1,1,10) do md Ŀ¼%i");break;
		case 2:system("for /l %i in (1,1,50) do md Ŀ¼%i");break;
		case 3:system("for /l %i in (1,1,100) do md Ŀ¼%i");break;
		default :break;
	}
	system("pause");
}
void rd()
{
	int x;
	printf("1��ɾ��10��Ŀ¼\t2��ɾ��50��Ŀ¼\t3��ɾ��100��Ŀ¼\n");
	scanf("%d%*c",&x);
	system("@echo off");
	switch(x)
	{
		case 1:system("for /l %i in (1,1,10) do rd Ŀ¼%i");break;
		case 2:system("for /l %i in (1,1,50) do rd Ŀ¼%i");break;
		case 3:system("for /l %i in (1,1,100) do rd Ŀ¼%i");break;
		default :break;
	}
	system("pause");
}