#include <stdafx.h>

void main()
{
	/*
	*	��Ŀ�����������������Ƕ������ɴ��⣺ѧϰ�ɼ�>=90�ֵ�ͬѧ��
	*	A��ʾ��60-89��֮�����B��ʾ��60�����µ���C��ʾ�� 
	*	1.���������(a>b)?a:b��������������Ļ������ӡ�
	*/

	int score;
	char grade;

	scanf("%d",&score);

	grade= score>=90 ? 'A' : ( score>=60 ? 'B' : 'C');
	
	printf("%c\n",grade);
}