#include <stdafx.h>

void main()
{
	int a[10];
	int i;
	int * a_p;
	a_p=a;
	//���鸳��ֵ
	for(i=0;i<10;i++)
	{
		a[i]=i*i-1;
	}
	
	//��ӡ����Ԫ��
	for(i=0;i<10;i++)
	{
		printf("%d ",a[i]);
	}
	
	printf("\n");

	for(i=0;i<10;i++)
	{
		printf("%d ",*(a+i));
	}

	printf("\n");

	for(i=0;i<10;i++)
	{
		printf("%d ",*(a_p+i));
	}

	printf("\n");
	
	while(*a_p++ != 80)
	{
		//putchar(*a_p);
	printf("%d ",*a_p);

	}
	printf("\n");	
}