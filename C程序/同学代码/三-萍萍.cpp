// kaoshixintong.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"
#include"stdlib.h"
#include"windows.h"

void loading();void daan();void jf(int x,int y);void finish();
void ti1();void ti2();void ti3();void ti4();void ti5();
void ti6();void ti7();void ti8();void ti9();void ti10();

char str1[10],str2[10];

int i,j=0,sum=0;
int xf[10];

void main()
{
	system("title ����ϵͳ  & color 1a");
	printf("                              ��ӭ���뿼�ԣ�ף�㿼��˳��!\n");
	printf("\n\n");
	printf("\t\t\t   \n����������");
	gets(str1);
	printf("\t\t\t   \n����ѧ��: ");	
	gets(str2);
	printf("\n\n");
	printf("��������У����Ժ�");
	loading();
	system("cls");
	ti1(); jf(33,i);
	ti2(); jf(0,i);
	ti3(); jf(1,i);
	ti4(); jf(4,i);
	ti5(); jf(100,i);
	ti6(); jf(1,i);
	ti7(); jf(-1,i);
	ti8(); jf(6,i);
	ti9(); jf(2,i);
	ti10(); jf(8,i);
	finish();
	for(j=0;j<=9;j++)
	{
		sum=sum+xf[j];
	}
	printf("������÷���%d\n",sum);
	system("pause");
}
void loading()
{
	for(int i=1;i<=24;i++)
	{
			printf("�~");
			Sleep(50);
	}
}
void ti1()
{
	printf("��һ��\n\t��int i=289;char c='a';c=i;�����������c��ֵΪ���٣�\n��Ĵ�: ");
	daan();
	printf("\n\n");

}
void ti2()
{
	printf("�ڶ���\n\t��i=0����ôi++��ֵ�ǣ�\n��Ĵ𰸣�");
	daan();
	printf("\n\n");


}
void ti3()
{
	printf("������\n\t�������һ���ַ����ĸ�ʽ���ǣ�\n\t1.s\t\t2.d\t\t3.c\n��Ĵ𰸣�");
	daan();
	printf("\n\n");
}
void ti4()
{
	printf("������\n\t����ϵͳΪÿһ����float������������ٸ��ֽڣ�\n��Ĵ𰸣�");
	daan();
	printf("\n\n");
}
void ti5()
{
	printf("������\n\t��for(int i=1,i<=100,i++������ʾ����ѭ�����ٴΣ�\n��Ĵ𰸣�");
	daan();
	printf("\n\n");
}
void ti6()
{
	printf("������\n\t���������Ǵ�main������ʼִ�еġ���仰����\t��ѡ��1.��\t2.����\n��Ĵ𰸣�");
	daan();
	printf("\n\n");
}
void ti7()
{
	printf("������\n\t����char c=255��printf����%d��,c�������������ǣ�\n��Ĵ𰸣�");
	daan();
	printf("\n\n");
}
void ti8()
{
	printf("�ڰ���\n\t��float�����ݿ��Եõ�����λ��Ч���֣�\n��Ĵ𰸣�");
	daan();
	printf("\n\n");
}
void ti9()
{
	printf("�ھ���\n\t�ж����б�ʾ��ʽ�Ƿ���ȷ��int=3����\n��ѡ��:1.��ȷ	2.����\n��Ĵ𰸣�");
	daan();
	printf("\n\n");
}
void ti10()
{
	printf("��ʮ��\n\t����ʽ�ӡ�a=��b=4��+��c=4�����С�a����ʾ��ֵ��?\n��Ļش�");
	daan();
	printf("\n\n");
}
void daan()
{
	scanf("%d",&i);
	i=getchar();
	printf("\n\n");
}
void jf(int x,int y)
{
	if(x==y)
	{
		xf[j]=10;
	}
	else
	{
		xf[j]=0;
	}
	j++;
}
void finish()
{
	int a;
	printf("ȷ���ύ�𣿼����������Ų��س���ȷ���ύ������0�س���");
	scanf("%d",&a);
	if(1==a)
		ti1();
	if(2==a)
		ti2();
	if(3==a)
		ti3();
	if(4==a)
		ti4();
	if(5==a)
		ti5();
	if(6==a)
		ti6();
	if(7==a)
		ti7();
	if(8==i)
		ti8();
	if(9==a)
		ti9();
	if(10==a)
		ti10();
}
