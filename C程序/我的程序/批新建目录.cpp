#include <stdafx.h>
#include <stdlib.h>

void md();
void rd();

void main()
{
	int i;
	printf("1、新建目录\t2删除目录\n");
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
	printf("1、新建10个目录\t2、新建50个目录\t3、新建100个目录\n");
	scanf("%d%*c",&x);
	system("@echo off");
	switch(x)
	{
		case 1:system("for /l %i in (1,1,10) do md 目录%i");break;
		case 2:system("for /l %i in (1,1,50) do md 目录%i");break;
		case 3:system("for /l %i in (1,1,100) do md 目录%i");break;
		default :break;
	}
	system("pause");
}
void rd()
{
	int x;
	printf("1、删除10个目录\t2、删除50个目录\t3、删除100个目录\n");
	scanf("%d%*c",&x);
	system("@echo off");
	switch(x)
	{
		case 1:system("for /l %i in (1,1,10) do rd 目录%i");break;
		case 2:system("for /l %i in (1,1,50) do rd 目录%i");break;
		case 3:system("for /l %i in (1,1,100) do rd 目录%i");break;
		default :break;
	}
	system("pause");
}