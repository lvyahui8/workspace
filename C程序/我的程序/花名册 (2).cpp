// 花名册.cpp : Defines the entry point for the console application.
/*
需求：制作员工花名册

步骤：
1.输入序号和姓名
2.根据序号用起泡法排序
3.输出序号和姓名
*/

#include "stdafx.h"
#include <string.h>
#define M 5  // 指明人数
#define N 10 // 指明人名长度
void swap(int *p1,int *p2)
{	// 交换变量值
	*p1=*p1+*p2;
	*p2=*p1-*p2;
	*p1=*p1-*p2;
}

void str_swap(char str1[],char str2[])
{	// 交换字符串
    char temp[20];
	strcpy(temp,str1);
	strcpy(str1,str2);
	strcpy(str2,temp);
}

void sort(int i_n[],char str[][N],int i_long)
{
	int i,j;
	for(i=0;i<i_long-1;i++)
	{
		for(j=0;j<i_long-1-i;j++)
		{
			if(i_n[j]>i_n[j+1])
			{
				swap(&i_n[j],&i_n[j+1]);
				str_swap(str[j],str[j+1]);
			}
		}
	}
}

void input(int i_n[],char str[][N],int i_long)
{
	int i;
	for(i=0;i<i_long;i++)
	{
		scanf("%d%*c",&i_n[i]);
		gets(str[i]);
	}
}

void output(int i_n[],char str[][N],int i_long)
{
	int i;
	for(i=0;i<i_long;i++)
	{
		printf("Number:%d Name:%s\n",i_n[i],str[i]);
	}
}

void search(int number,int i_long,int i_n[],char str[][N])
{
	/*
	int min=65531,max=0;
	int i;
	for(i=0;i<i_long;i++)
	{
		if(i_n[i]<min)
			min=i_n[i];
		if(i_n[i]>max)
			max=i_n[i];
	}
	*/
	int min=0,max=i_long-1;
	
	for(int i=0;i<i_long-1;i++)
	{
		if(number==i_n[i])
			printf("%s\n",str[i]);
	}
}

void main()
{
	int i_num[M];
	char c_name[M][N];
	// 输入初值
	input(i_num,c_name,M);
	// 排序
	sort(i_num,c_name,M);
	// 输出
	output(i_num,c_name,M);
	search(24,M,i_num,c_name);
}