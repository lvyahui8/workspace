/*
���󣺽�һ�������޸�����ɵ����е���

˼·��
1.���룬����¼�������ĸ���
2.���򣬸��ݸ����������������
3.��������ݸ����������źõ��������
*/
#include <stdafx.h>
#define LENGTH 100
//��Ҫ�������ͱ�����ַ
void swap(int * x,int * y)
{
	int temp;
	temp=*x;
	*x=*y;
	*y=temp;
}

void inversion(int * i_array,int length)
{
	//���鵹��lengthָ�����ĸ���
	int i;
	for(i=0,length--;length>i;i++,length--)
	{
		swap(&i_array[i],&i_array[length]);
	}
}

void main()
{
	int array[LENGTH];
	int i,p;
	char ch;
	printf("The input array:\n");

	for(i=0;i<LENGTH && ch!='\n';i++)
	{
		scanf("%d",&array[i]);
		ch=getchar();
	}
	p=i;  //��ѭ����¼�ĸ�����ֵ��p����
	inversion(array,p);

	printf("The output array:\n");

	for(i=0;i<p;i++)
		printf("%d ",array[i]);

	putchar('\n');
}