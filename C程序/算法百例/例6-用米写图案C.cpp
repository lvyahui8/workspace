#include <stdafx.h>
#include <math.h>
void main()
{
	/*
	��Ŀ����*�������ĸC��ͼ���� 
	1.���������������'*'����ֽ��д����ĸC���ٷ�������� 
	2.����Դ���룺 
	*/
	for(int i=-2;i<=2;i++)
	{
		if(abs(i)==2) printf("* * * *\n");
		else if(abs(i)==1) printf("*\n");
		else continue;
	}
}
