/*
���󣺽�һ�������޸�����ɵ����е���

˼·��
1.���룬����¼�������ĸ���
2.���򣬸��ݸ����������������
3.��������ݸ����������źõ��������
*/

#include <stdafx.h>
#define LENGTH 100

int input(int * i_array,int length)
{	// ���룬lengthָ�����鳤��
	int i;
	char ch;
	printf("The input array:\n");
	for(i=0;i<length && ch!='\n';i++)
	{
		scanf("%d",&i_array[i]);
		ch=getchar();
	}
	return i;// �����û��������ĸ���
}

void swap(int * x,int * y)
{   //��Ҫ�������ͱ�����ַ,���Խ�������ֵ
	int temp;
	temp=*x;
	*x=*y;
	*y=temp;
}

void inversion(int * i_array,int length)
{	//���鵹��lengthָ�����ĸ���
	int i;
	for(i=0,length--;length>i;i++,length--)
	{
		swap(&i_array[i],&i_array[length]);
	}
}

void output(int * i_array,int length) 
{	//������飬lengthָ�����ĸ���
	int i;
	printf("The output array:\n");
	for(i=0;i<length;i++)
		printf("%d ",i_array[i]);
	putchar('\n');
}

void void_fuc(int * i_array,int length,void (*p)(int * m,int))
{
	p(i_array,length);// pΪָ������ָ��  
	//���紫ֵʱ�β�Ϊoutput����p==output,���ʽ�ͱ����output(i_array,length);
}

int int_fuc(int * i_array,int length,int (*p)(int * m,int))
{
	return p(i_array,length);
}

void main()
{
	int array[LENGTH];
	int p;

	p=int_fuc(array,LENGTH,input);
	void_fuc(array,p,inversion);
	void_fuc(array,p,output);
}