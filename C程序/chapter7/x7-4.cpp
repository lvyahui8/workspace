#include <stdafx.h>
#include <string.h>
void main()
{
	//���û���������ŵ��Ѿ��ź���������У�������˳��
	int a[20]={0};
	for(int i=0;i<=9;i++)
		a[i]=2*i;
	for(i=0;i<=19;i++)
		printf("%d ",a[i]);
	int x;
	scanf("%d",&x);
	for(i=0;i<=9;i++)
	{
		if(a[i]>x)
			break;
	}
	if(i<=9)
	{
		for(int j=9; j>=i;j--)
		{
			a[j+1]=a[j];
		}
		a[i]=x;
	}
	else
		a[10]=x;
	for(i=0;i<=19;i++)
		printf("%d ",a[i]);
}