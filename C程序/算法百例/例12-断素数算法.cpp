#include <stdafx.h>
#include <math.h>

void main()
{
	/*
	��Ŀ���ж�101-200֮���ж��ٸ�������
	��������������� 
	
	1.��������� ���һ��������N�Ƿ�
	Ϊ��������򵥵ķ��������Գ�������
	����N��С�ڵ��ڸ���N����������ȥ��
	���������޷���������NΪ�������μ�
	�����ж�����
	
	2.����Դ���룺*/
	int i,j,k,leap=0; 
	scanf("%d",&i);
	for(j=2;j<=sqrt(i);j++)
	{
		if(i%j==0)
			leap++;
	}
	if(leap==0)
		printf("%d������",i);
	else
		printf("%d��������",i);

	/*int m,i,k; 
	scanf("%d",&m); 
	k=sqrt(m); 
	for(i=2;i<=k;i++) 
		if(m%i==0)break; 
	if(i>=k+1) 
		printf("%d ������\n",m); 
	else 
		printf("%d ��������\n",m); 
	*/
}