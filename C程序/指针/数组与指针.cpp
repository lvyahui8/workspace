#include <stdafx.h>

void main()
{
	int i[10]={0,1,2,3,4,5,6,7,8,9};
	int * p;
	p=i;

	/*	
	for(int k=0;k<10;k++)
	{
		printf("%d",*p++);
	}
	//�±�Խ���������ò�Ҫ����Խ������
	printf("\ni[10]=%d\n",*p);
	printf("&i[10]-&i[9]=%d\n",&i[10]-&i[9]);
	printf("&i[9]-&i[8]=%d\n",&i[9]-&i[8]);
	*/

	/*
	p++;
	*p=1;
	printf("i[1]=%d\n",*p);
	*/
	//����������飬��֤�±겻Խ��ķ���
	/*
	for(p=i;p<i+10;p++)
	{
		printf("%d ",*p);
	}
	p--;


	for(int a=0;a<10;a++)
	{
		printf("%d ",*(i+a));
	}
	
	for(int a=0;a<10;a++)
	{
		printf("%d ",p[a]);
		//C���� p[a]==*(i+a)==*(p+a)
	}
	*/

	printf("\n*p=%d\n",*p);

}